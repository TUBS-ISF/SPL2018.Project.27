import java.util.Scanner;

public class InputManager {

	private Scanner scanner;
	private boolean isOpen;
	
	public InputManager(Bash bash) {
		openScanner();
	}
	
	public String getNextInput() {
		if(!isOpen) {
			return "NOT OPEN!";
		}
		return scanner.nextLine();
	}
	
	public void openScanner() {
		if(scanner == null && !isOpen) {
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
