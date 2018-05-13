package bash.output;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Color;
import org.fusesource.jansi.AnsiConsole;

import properties.PropertyManager;

public class OutputManager {

	public OutputManager() {
		AnsiConsole.systemInstall();
		
		//Set Background
		if(PropertyManager.getProperty("BackgroundBlack")) {
			AnsiConsole.out.println(Ansi.ansi().bg(Color.BLACK));
		} else if (PropertyManager.getProperty("BackgroundWhite")) {
			AnsiConsole.out.println(Ansi.ansi().bg(Color.WHITE));
		}
		
		//Set Foreground
		if(PropertyManager.getProperty("Red")) {
			AnsiConsole.out.println(Ansi.ansi().fg(Color.RED));
		} else if (PropertyManager.getProperty("Green")) {
			AnsiConsole.out.println(Ansi.ansi().fg(Color.GREEN));
		} else if (PropertyManager.getProperty("Blue")) {
			AnsiConsole.out.println(Ansi.ansi().fg(Color.BLUE));
		} else if (PropertyManager.getProperty("White")) {
			AnsiConsole.out.println(Ansi.ansi().fg(Color.WHITE));
		}
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
}
