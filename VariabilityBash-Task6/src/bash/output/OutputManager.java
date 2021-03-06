package bash.output;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

public class OutputManager {

	public OutputManager() {
		AnsiConsole.systemInstall();
		registerColor();
	}

	public void resetOutput() {
		AnsiConsole.out.println(Ansi.ansi().reset());
		AnsiConsole.systemUninstall();
	}

	public void print(String output) {
		AnsiConsole.out.print(generateASCIOutput(output));
	}

	public void nextLine() {
		AnsiConsole.out.println();
	}

	private Ansi generateASCIOutput(String output) {
		return Ansi.ansi().a(output);
	}
	
	public void registerColor() {
		
	}
}
