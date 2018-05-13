package bash.input.commands;

import properties.PropertyManager;

public abstract class Command {

	public abstract int getNumberOfArguments();

	public abstract String getIdentifier();

	public abstract String getDescriptiopn();
	
	public abstract String getUsageExample();
	
	public abstract String runCommand(Object source, String ... command);
	
	public String getHelpString() {
		String output = "";
		if(PropertyManager.getProperty("Name")) {
			output += getIdentifier() + " - ";
		}
		if(PropertyManager.getProperty("Description")) {
			output += getDescriptiopn();
		}
		if(PropertyManager.getProperty("UsageExample")) {
			output += " Usage Example: " + getUsageExample();
		}
		return output;
	}
	
}
