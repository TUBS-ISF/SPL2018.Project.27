package bash.input.commands;

import bash.Bash;

public abstract class Command {
	
	public abstract int getNumberOfArguments();

	public abstract String getIdentifier();

	public abstract String getDescriptiopn();
	
	public abstract String getUsageExample();
	
	public abstract String runCommand(Bash bash, Object source, String... command);

	public String getHelpString() {
		String output = "";
		output += getIdentifier() + " - ";
			output += getDescriptiopn();
			output += " Usage Example: " + getUsageExample();
		return output;
	}

}
