package bash.input.commands;

import bash.Bash;

public class ExitCommand extends Command{

	@Override
	public int getNumberOfArguments() {
		return 0;
	}

	@Override
	public String getIdentifier() {
		return "exit";
	}

	//#if Description
	@Override
	public String getDescriptiopn() {
		return "Terminates the VariabilityBash.";
	}
	//#endif

	//#if Description
	@Override
	public String getUsageExample() {
		return "'exit'";
	}
	//#endif

	@Override
	public String runCommand(Bash bash, Object source, String... command) {
		return Bash.EXIT_CODE;
	}
}
