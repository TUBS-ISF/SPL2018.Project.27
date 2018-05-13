package bash;

import bash.input.CommandParser;
import bash.input.InputManager;
import bash.output.OutputManager;
import properties.PropertyManager;

public class Bash {

	
	
	public static final String EXIT_CODE = "abort_mission";

	private InputManager iManager = null;
	private OutputManager oManager = null;
	private CommandParser parser;

	public String currentPath = System.getProperty("user.dir");

	public Bash() {
		if (PropertyManager.getProperty("Input")) {
			iManager = new InputManager(this);
		}
		if (PropertyManager.getProperty("Output")) {
			oManager = new OutputManager();
		}
		if(PropertyManager.getProperty("CommandParser")) {
			parser = new CommandParser(this);
		}


		if (PropertyManager.getProperty("Output")) {
			oManager.print("Welcome to the VariabilityBash!");
			oManager.nextLine();
		}
		
		while (processNextCommand()) {
			
		}

		if (PropertyManager.getProperty("Output")) {
			oManager.resetOutput();
		}
	}

	public static void main(String[] args) {
		Bash bash = new Bash();
	}
	
	private boolean processNextCommand() {
		if (PropertyManager.getProperty("Output")) {
			oManager.print(currentPath + " #");
		}
		if (PropertyManager.getProperty("Input")) {
			String input = iManager.getNextInput();

			//Process next command
			if (PropertyManager.getProperty("CommandParser")) {
				String result = parser.excecuteCommand(input);

				if (PropertyManager.getProperty("Output")) {
					oManager.nextLine();
					oManager.print(result);
				}
				if (result.equals(EXIT_CODE)) {
					return false;
				}
			}
			
		}
		return true;
	}
}
