package bash;

import bash.input.InputManager;
import properties.PropertyManager;

public class Bash {
	
	public static final String INPUT = "Input";

	InputManager manager = null;
	
	public Bash() {
		if(PropertyManager.getProperty(INPUT)) {
			manager = new InputManager();
		}
	}
	
	
	public static void main(String[] args) {
		Bash bash = new Bash();
	}
}
