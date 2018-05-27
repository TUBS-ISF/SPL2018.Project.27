//#if ls
package bash.input.commands;

import java.io.File;
import java.util.ArrayList;

import bash.Bash;

public class LSCommand extends Command {

	@Override
	public int getNumberOfArguments() {
		return 0;
	}

	@Override
	public String getIdentifier() {
		return "ls";
	}

	// #if Description
	@Override
	public String getDescriptiopn() {
		return "Lists all files and directories of the current directory.";
	}
	// #endif

	// #if UsageExample
	@Override
	public String getUsageExample() {
		return "ls";
	}
	// #endif

	@Override
	public String runCommand(Bash bash, Object source, String... command) {
		File file = new File(bash.currentPath);
		File[] listOfFiles = file.listFiles();
		ArrayList<String> fileNames = new ArrayList<String>();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				fileNames.add(listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				fileNames.add(listOfFiles[i].getName() + "/");
			}
		}
		//Show Hidden Directories
		for (String string : fileNames) {
			if (string.startsWith(".") && string.endsWith("/")) {
				bash.oManager.print(string + "\n");
			}
		}
		//Show Hidden Files
		for (String string : fileNames) {
			if (string.startsWith(".") && !string.endsWith("/")) {
				bash.oManager.print(string + "\n");
			}
		}
		//Now Directories
		for (String string : fileNames) {
			if (string.endsWith("/") && !string.startsWith(".")) {
				bash.oManager.print(string + "\n");
			}
		}
		//Now Files
		for (String string : fileNames) {
			if (!string.endsWith("/") && !string.startsWith(".")) {
				bash.oManager.print(string + "\n");
			}
		}
		return null;
	}

}
// #endif
