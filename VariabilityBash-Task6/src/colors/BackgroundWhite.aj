package colors;

import org.fusesource.jansi.Ansi;
import bash.output.OutputManager;
import org.fusesource.jansi.AnsiConsole;

public aspect BackgroundWhite {

	after() : execution(void OutputManager.registerColor()){
		AnsiConsole.out.println(Ansi.ansi().bg(Ansi.Color.WHITE));
	}
}
