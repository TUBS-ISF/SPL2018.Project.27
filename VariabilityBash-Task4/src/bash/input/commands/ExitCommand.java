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

	@Override
	public String getDescriptiopn() {
		return "Terminates the VariabilityBash.";
	}

	@Override
	public String getUsageExample() {
		return "'exit'";
	}

	@Override
	public String runCommand(Bash bash, Object source, String... command) {
		return Bash.EXIT_CODE;
	}
}
