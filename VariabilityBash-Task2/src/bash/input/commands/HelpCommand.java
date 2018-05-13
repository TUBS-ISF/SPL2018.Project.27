package bash.input.commands;

import bash.input.CommandParser;
import properties.PropertyManager;

public class HelpCommand extends Command{
	
	@Override
	public
	String getIdentifier() {
		return "help";
	}

	@Override
	public
	String getDescriptiopn() {
		String output = "Lists the ";
		if(PropertyManager.getProperty("Name")) {
			output += "name";
		}
		if(PropertyManager.getProperty("Description")) {
			output += ", description";
		}
		if(PropertyManager.getProperty("UsageExample")) {
			output += ", and usage example";
		}
		output += " of every available command.";
		return output;
	}

	@Override
	public
	String getUsageExample() {
		return "'help'";
	}

	@Override
	public
	String runCommand(Object commandParser, String ... command) {
		if(commandParser instanceof CommandParser) {
			CommandParser parser = (CommandParser) commandParser;
			String output = "List of all available commands:\n";
			for (Command string : parser.getAvailableCommands()) {
				output += string.getHelpString() + "\n";
			}
			return output + "\n";
		} else {
			return "";
		}
	}

	@Override
	public
	int getNumberOfArguments() {
		return 0;
	}
}
