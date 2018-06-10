package bash.input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bash.Bash;
import bash.input.commands.CDCommand;
import bash.input.commands.Command;
import bash.input.commands.ExitCommand;
//#ifdef help
import bash.input.commands.HelpCommand;
//#endif
import bash.input.commands.LSCommand;
import bash.input.commands.MKDIRCommand;
import bash.input.commands.MKFileCommand;
import bash.input.commands.RMCommand;

public class CommandParser {

	List<Command> availableCommands = new ArrayList<>();

	Bash bash;

	public CommandParser(Bash bash) {
		this.bash = bash;
		availableCommands.add(new ExitCommand());
		availableCommands.add(new HelpCommand());
		availableCommands.add(new CDCommand());
		availableCommands.add(new LSCommand());
		availableCommands.add(new MKDIRCommand());
		availableCommands.add(new MKFileCommand());
		availableCommands.add(new RMCommand());
	}

	public String excecuteCommand(String input) {
		if (input == null || input.equals("")) {
			return "Invalid command. Type 'help' for information about all available commands.\n";
		}
		String[] inputAndParams = input.split(" ");
		if (inputAndParams.length == 0) {
			return "Invalid command. Type 'help' for information about all available commands.\n";
		}

		for (Command command : availableCommands) {
			if (command.getIdentifier().equals(inputAndParams[0].toLowerCase())) {
				return command.runCommand(bash, this, inputAndParams);
			}
		}

		// No known command
		return "Invalid command. Type 'help' for information about all available commands.\n";
	}

	public List<Command> getAvailableCommands() {
		return Collections.unmodifiableList(availableCommands);
	}

}
