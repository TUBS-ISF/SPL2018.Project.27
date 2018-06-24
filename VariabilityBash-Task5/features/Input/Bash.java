public class Bash {

	public static final String EXIT_CODE = "abort_mission";

	private InputManager iManager = null;
	public OutputManager oManager = null;
	private CommandParser parser;

	public String currentPath = System.getProperty("user.dir");

	public Bash() {
		iManager = new InputManager(this);
		oManager = new OutputManager();
		parser = new CommandParser(this);
		oManager.print("Welcome to the VariabilityBash!");
		oManager.nextLine();
		while (processNextCommand()) {
		}
		oManager.resetOutput();
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
	
}
