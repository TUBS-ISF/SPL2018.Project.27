package bash.input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bash.Bash;
import bash.input.commands.Command;
import bash.input.commands.ExitCommand;
public class CommandParser {

	public static List<Command> availableCommands = new ArrayList<>();

	Bash bash;

	public CommandParser(Bash bash) {
		this.bash = bash;
		addCommands();
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

	public void addCommands() {
		availableCommands.add(new ExitCommand());
	}
}
