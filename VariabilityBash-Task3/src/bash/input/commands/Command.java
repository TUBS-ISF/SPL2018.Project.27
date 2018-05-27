package bash.input.commands;

import bash.Bash;

public abstract class Command {
	
	public abstract int getNumberOfArguments();

	public abstract String getIdentifier();

	//#if Description
	public abstract String getDescriptiopn();
//#endif
	
	//#if UsageExample
	public abstract String getUsageExample();
	//#endif
	
	public abstract String runCommand(Bash bash, Object source, String... command);

	public String getHelpString() {
		String output = "";
		output += getIdentifier() + " - ";
//#if Description
			output += getDescriptiopn();
//#endif
//#if UsageExample
			output += " Usage Example: " + getUsageExample();
//#endif
		return output;
	}

}
