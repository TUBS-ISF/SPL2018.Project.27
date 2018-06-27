package bash.security;

import bash.Bash;

public aspect Verify {

	after() : execution(void Bash.init()){
		Bash.print("Verification required!\nPlease log in.");
		prompt();
	}	
	
	protected void prompt() {
		
	}
}
