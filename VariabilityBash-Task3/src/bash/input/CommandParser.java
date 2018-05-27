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
		// #ifdef help
		availableCommands.add(new HelpCommand());
		// #endif
		// #ifdef cd
		availableCommands.add(new CDCommand());
		// #endif
		// #ifdef ls
		availableCommands.add(new LSCommand());
		// #endif
		// #ifdef mkdir
		availableCommands.add(new MKDIRCommand());
		// #endif
		// #ifdef mkfile
		availableCommands.add(new MKFileCommand());
		// #endif
		// #ifdef rm
		availableCommands.add(new RMCommand());
		// #endif
	}

	public String excecuteCommand(String input) {
		if (input == null || input.equals("")) {
			// #ifdef help
			return "Invalid command. Type 'help' for information about all available commands.\n";
			// #else
			// @ return "Invalid command.\n";
			// #endif
		}
		String[] inputAndParams = input.split(" ");
		if (inputAndParams.length == 0) {
			// #ifdef help
			return "Invalid command. Type 'help' for information about all available commands.\n";
			// #else
			// @ return "Invalid command.\n";
			// #endif
		}

		for (Command command : availableCommands) {
			if (command.getIdentifier().equals(inputAndParams[0].toLowerCase())) {
				return command.runCommand(bash, this, inputAndParams);
			}
		}

		// No known command
		// #ifdef help
		return "Invalid command. Type 'help' for information about all available commands.\n";
		// #else
		// @ return "Invalid command.\n";
		// #endif
	}

	public List<Command> getAvailableCommands() {
		return Collections.unmodifiableList(availableCommands);
	}

}
