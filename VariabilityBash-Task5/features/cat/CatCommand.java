import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class CatCommand extends Command {

	@Override
	public int getNumberOfArguments() {
		return 1;
	}

	@Override
	public String getIdentifier() {
		return "cat";
	}

	@Override
	public String getDescriptiopn() {
		return "Shows the content of a selected file.";
	}

	@Override
	public String getUsageExample() {
		if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
			return "cat C://User/Test/Desktop/File.txt";
		} else {
			return "cat /home/test/Desktop/File.txt";
		}
	}

	@Override
	public String runCommand(Bash bash, Object source, String... command) {
		if (command.length == getNumberOfArguments() + 1) {
			String path = bash.currentPath + "/" + command[1];
			File showContentFile = new File(path);
			if (showContentFile.exists()) {
				bash.oManager.print("Content of file: " + showContentFile.getAbsolutePath() + ":\n\n");
				try {
					List<String> lines = Files.readAllLines(showContentFile.toPath(), Charset.forName("ISO-8859-1"));

					for (String line : lines) {
						bash.oManager.print(line + "\n");
					}
				} catch (IOException e) {
					bash.oManager.print("File does not exist.");
				}
			} else {
				bash.oManager.print("File does not exist.");
			}
			return null;
		} else {
			bash.oManager.print("Invalid number of arguments.");
			bash.oManager.print("\nUsage: " + getUsageExample());
		}
		return null;
	}
}
