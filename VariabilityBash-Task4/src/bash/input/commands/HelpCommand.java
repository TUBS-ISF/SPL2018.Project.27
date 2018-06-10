package bash.input.commands;

import bash.Bash;
import bash.input.CommandParser;

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
			output += "name";
			output += ", description";
			output += ", and usage example";
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
	String runCommand(Bash bash, Object commandParser, String ... command) {
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
