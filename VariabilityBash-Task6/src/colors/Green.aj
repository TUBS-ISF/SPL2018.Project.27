package colors;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import bash.output.OutputManager;

public aspect Green {

	after() : execution(void OutputManager.registerColor()){
		AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.GREEN));
	}
}
