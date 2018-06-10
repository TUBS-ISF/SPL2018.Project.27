package bash.output;

import java.awt.Color;
import java.util.List;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import bash.interfaces.IBackgroundColor;
import bash.interfaces.IColor;
import loader.PluginLoader;

public class OutputManager {

	public OutputManager() {
		AnsiConsole.systemInstall();

		List<IColor> foregroundPlugins = PluginLoader.load(IColor.class);
		IColor color = foregroundPlugins.get(0);
		if (color.getColor() == Color.WHITE) {
			AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.WHITE));
		} else if (color.getColor() == Color.GREEN) {
			AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.GREEN));
		} else if (color.getColor() == Color.RED) {
			AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.RED));
		} else {
			AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.BLUE));
		}

		List<IBackgroundColor> backgroundBlugins = PluginLoader.load(IBackgroundColor.class);
		IBackgroundColor bgColor = backgroundBlugins.get(0);
		if (bgColor.getColor() == Color.WHITE) {
			AnsiConsole.out.println(Ansi.ansi().bg(Ansi.Color.WHITE));
		} else {
			AnsiConsole.out.println(Ansi.ansi().bg(Ansi.Color.BLACK));
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
