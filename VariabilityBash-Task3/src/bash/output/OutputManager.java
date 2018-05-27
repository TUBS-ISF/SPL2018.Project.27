package bash.output;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Color;
import org.fusesource.jansi.AnsiConsole;

public class OutputManager {

	public OutputManager() {
		AnsiConsole.systemInstall();
		
		//Set Background
//#ifdef BackgroundBlack
//@			AnsiConsole.out.println(Ansi.ansi().bg(Color.BLACK));
//#else
			AnsiConsole.out.println(Ansi.ansi().bg(Color.WHITE));
//#endif		
			
		//Set Foreground
//#if Red
			AnsiConsole.out.println(Ansi.ansi().fg(Color.RED));
//#elif Green		
//@			AnsiConsole.out.println(Ansi.ansi().fg(Color.GREEN));
//#elif Blue		
//@			AnsiConsole.out.println(Ansi.ansi().fg(Color.BLUE));
//#else		
//@			AnsiConsole.out.println(Ansi.ansi().fg(Color.WHITE));
//#endif			
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
