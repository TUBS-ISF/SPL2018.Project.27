package bash.input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bash.Bash;
import bash.input.commands.Command;
import bash.input.commands.ExitCommand;
import bash.input.commands.HelpCommand;
import properties.PropertyManager;

public class CommandParser {

	List<Command> availableCommands = new ArrayList<>();
	
	Bash bash;
	
	public CommandParser(Bash bash) {
		this.bash = bash;
		availableCommands.add(new ExitCommand());
		if(PropertyManager.getProperty("help")) {
			availableCommands.add(new HelpCommand());
		}
	}
	
	public String excecuteCommand(String input) {
		if(input == null || input.equals("")) {
			if(PropertyManager.getProperty("help")) {
				return "Invalid command. Type 'help' for information about all available commands.\n";
			} else {
				return "Invalid command.\n";
			}
		}
		String [] inputAndParams = input.split(" ");
		if(inputAndParams.length == 0) {
			if(PropertyManager.getProperty("help")) {
				return "Invalid command. Type 'help' for information about all available commands.\n";
			} else {
				return "Invalid command.\n";
			}
		}
		
		for (Command command : availableCommands) {
			if(command.getIdentifier().equals(inputAndParams[0].toLowerCase())) {
				return command.runCommand(this, inputAndParams);
			}
		}

		//No known command
		if(PropertyManager.getProperty("help")) {
			return "Invalid command. Type 'help' for information about all available commands.\n";
		} else {
			return "Invalid command.\n";
		}
	}
	
	public List<Command> getAvailableCommands(){
		return Collections.unmodifiableList(availableCommands);
	}
	
}
