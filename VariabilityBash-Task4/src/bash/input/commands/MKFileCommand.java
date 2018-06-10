package bash.input.commands;

import java.io.File;
import java.io.IOException;

import bash.Bash;

public class MKFileCommand extends Command {

	@Override
	public int getNumberOfArguments() {
		return 1;
	}

	@Override
	public String getIdentifier() {
		return "touch";
	}

	@Override
	public String getDescriptiopn() {
		return "Creates a new file with the given name at the current directory";
	}

	@Override
	public String getUsageExample() {
		return "touch newFile.txt";
	}

	@Override
	public String runCommand(Bash bash, Object source, String... command) {
		if (command.length == getNumberOfArguments() + 1) {
			String path = bash.currentPath + "/" + command[1];
			File newFile = new File(path);
			if (newFile.exists()) {
				bash.oManager.print("File already exists.");
			} else {
				try {
					newFile.createNewFile();
				} catch (IOException e) {
					bash.oManager.print("Cloud not create the file!");
				}
			}
		} else {
			bash.oManager.print("Invalid number of arguments.");
			bash.oManager.print("\nUsage: " + getUsageExample());
		}
		return null;
	}

}
