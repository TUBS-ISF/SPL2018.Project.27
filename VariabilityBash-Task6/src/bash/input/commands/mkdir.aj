package bash.input.commands;

import java.io.File;
import bash.input.CommandParser;
import bash.Bash;

public aspect mkdir extends Command {

	@Override
	public int getNumberOfArguments() {
		return 1;
	}

	@Override
	public String getIdentifier() {
		return "mkdir";
	}

	@Override
	public String getDescriptiopn() {
		return "Creates a new directory.";
	}
	@Override
	public String getUsageExample() {
		return "mkdir newFolder";
	}
	
	@Override
	public String runCommand(Bash bash, Object source, String... command) {
		if(command.length == getNumberOfArguments()+1) {
			String path = bash.currentPath + "/" + command[1];
			File newDirectory = new File(path);
			if(newDirectory.exists()) {
				bash.oManager.print("Directory already exists.");
			} else {
				newDirectory.mkdir();
			}
		} else {
			bash.oManager.print("Invalid number of arguments.");
			bash.oManager.print("\nUsage: " + getUsageExample());
		}
		return null;
	}

	
	after() : execution(void CommandParser.addCommands()){
		CommandParser.availableCommands.add(this);
	}

}
