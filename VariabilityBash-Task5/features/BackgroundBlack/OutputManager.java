import java.awt.Color;
import java.util.List;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

public class OutputManager {

	private void backgroundInit() {
		AnsiConsole.out.println(Ansi.ansi().bg(Ansi.Color.BLACK));
	}
}
