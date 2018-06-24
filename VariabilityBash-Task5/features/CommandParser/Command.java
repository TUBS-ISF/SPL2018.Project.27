public abstract class Command {

	private boolean showName = false;
	private boolean showDescription = false;
	private boolean showUsage = false;

	public abstract int getNumberOfArguments();

	public abstract String getIdentifier();

	public abstract String getDescriptiopn();

	public abstract String getUsageExample();

	public abstract String runCommand(Bash bash, Object source, String... command);

	public String getHelpString() {
		String output = "";
		if (showName) {
			output += getIdentifier() + " - ";
		}
		if (showDescription) {
			output += getDescriptiopn();
		}
		if (showUsage) {
			output += " Usage Example: " + getUsageExample();
		}
		return output;
	}

}
