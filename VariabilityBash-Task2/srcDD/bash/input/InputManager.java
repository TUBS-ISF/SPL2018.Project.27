package bash.input;

import java.util.Scanner;

public class InputManager {

	private Scanner scanner;
	private boolean isOpen;
	
	public InputManager() {
		openScanner();
	}
	
	public String getNextInput() {
		return isOpen ? scanner.next() : "";
	}
	
	public void openScanner() {
		if(scanner != null && !isOpen) {
			scanner = new Scanner(System.in);
			isOpen = true;
		}
	}
	
	public void closeScanner() {
		if(scanner != null && !isOpen) {
			scanner.close();
			scanner = null;
			isOpen = false;
		}
	}

}
