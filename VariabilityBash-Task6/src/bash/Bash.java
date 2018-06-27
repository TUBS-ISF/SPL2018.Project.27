package bash;

import bash.input.CommandParser;
import bash.input.InputManager;
import bash.output.OutputManager;

public class Bash {

	public static final String EXIT_CODE = "abort_mission";

	public InputManager iManager = null;
	public OutputManager oManager = null;
	private CommandParser parser;
	public static Bash instance;

	public String currentPath = System.getProperty("user.dir");

	public boolean shutdown = false;

	public Bash() {
		if (instance == null) {
			instance = this;
			iManager = new InputManager(this);
			oManager = new OutputManager();
			parser = new CommandParser(this);
			oManager.print("Welcome to the VariabilityBash!");
			oManager.nextLine();
			init();
			if (!shutdown) {
				while (processNextCommand()) {
					if(shutdown) {
						break;
					}
				}
			}
			oManager.resetOutput();
		} else {

		}
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Bash bash = new Bash();
	}

	private boolean processNextCommand() {
		if (!currentPath.equals("/")) {
			oManager.print(currentPath + "/#");
		} else {
			oManager.print(currentPath + "#");
		}
		String input = iManager.getNextInput();
		// Process next command
		String result = parser.excecuteCommand(input);

		if (result != null) {
			if (result.equals(EXIT_CODE)) {
				return false;
			}
			oManager.print(result);
		}
		return true;
	}

	protected void init() {

	}

	public static void print(String line) {
		if (instance != null) {
			instance.oManager.print(line);
		}
	}

}
