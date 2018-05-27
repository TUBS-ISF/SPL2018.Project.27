//#if cd
package bash.input.commands;

import java.io.File;
import bash.Bash;

public class CDCommand extends Command {

	@Override
	public int getNumberOfArguments() {
		return 1;
	}

	@Override
	public String getIdentifier() {
		return "cd";
	}

	// #if Description
	@Override
	public String getDescriptiopn() {
		return "Changes the current working directory.";
	}
	// #endif

	// #if UsageExample
	@Override
	public String getUsageExample() {
		if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
			return "cd C://User/Test/Desktop/NewFolder";
		} else {
			return "cd /home/test/Desktop/NewFolder";
		}
	}
	// #endif

	@Override
	public String runCommand(Bash bash, Object source, String... command) {
		if (command.length == getNumberOfArguments() + 1) {
			String appendPath = command[1];

			if (appendPath.equals("..")) {
				// Go one directory back
				File currentDir = new File(bash.currentPath);
				String parentDir = currentDir.getParent();
				if (parentDir != null) {
					bash.currentPath = parentDir;
					return null;
				}
			}

			if (appendPath.startsWith("C://") || appendPath.startsWith("/")) {
				File f = new File(appendPath);
				if (f.exists()) {
					if (f.isDirectory()) {
						bash.currentPath = appendPath;
						return null;
					} else {
						bash.oManager.print("Path is not a directory\n");
						return null;
					}
				} else {
					bash.oManager.print("Path not found\n");
					return null;
				}
			} else {
				String newPath = "";
				if (bash.currentPath.equals("/")) {
					newPath = bash.currentPath + appendPath;
				} else {
					newPath = bash.currentPath + "/" + appendPath;
				}
				File f = new File(newPath);
				if (f.exists()) {
					if (f.isDirectory()) {
						bash.currentPath = newPath;
						return null;
					} else {
						bash.oManager.print("Path is not a directory\n");
						return null;
					}
				} else {
					bash.oManager.print("Path not found\n");
					return null;
				}
			}

		} else {
			bash.oManager.print("Invalid parameters.\n");
			// #ifdef UsageExample
			bash.oManager.print("Usage Example: " + getUsageExample());
			// #endif
		}
		return null;
	}
}
// #endif
