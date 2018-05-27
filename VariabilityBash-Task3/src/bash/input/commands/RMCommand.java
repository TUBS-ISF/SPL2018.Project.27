//#if rm
package bash.input.commands;

import java.io.File;

import bash.Bash;

public class RMCommand extends Command {

	@Override
	public int getNumberOfArguments() {
		return 1;
	}

	@Override
	public String getIdentifier() {
		return "rm";
	}

	// #if Description
	@Override
	public String getDescriptiopn() {
		return "Removes a file in the current directory";
	}
	// #endif

	// #if UsageExample
	@Override
	public String getUsageExample() {
		return "rm deleteThisFile.txt";
	}
	// #endif

	@Override
	public String runCommand(Bash bash, Object source, String... command) {
		if(command.length == getNumberOfArguments()+1) {
			if(command.equals("*")) {
				//Delete all files of current directory
				File delFile = new File(bash.currentPath);
				File[] files = delFile.listFiles();
				for (File file : files) {
					file.delete();
				}
				return null;
			} else {
				String path = bash.currentPath + "/" + command[1];
				File delFile = new File(path);
				if(delFile.exists()) {
					delFile.delete();
				} else {
					bash.oManager.print("File does not exist.");
				}
				return null;
			}
		} else {
			bash.oManager.print("Invalid number of arguments.");
			// #if UsageExample
			bash.oManager.print("\nUsage: " + getUsageExample());
			// #endif
		}
		return null;
	}

}
// #endif
