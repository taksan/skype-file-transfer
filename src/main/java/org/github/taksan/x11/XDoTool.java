package org.github.taksan.x11;

import java.io.IOException;


public class XDoTool {

	public static void activateWindowGivenPatterns(
			String... patterns) {
		String activateWindow = buildSearchQuery(patterns) + " windowactivate";
		runOrCry(activateWindow);
	}

	public static void writeln(String fileName)
			throws InterruptedException, IOException {
		runOrCry("xdotool type " + fileName);
		runOrCry("xdotool key Return");
	}
	
	private static String buildSearchQuery(String... patterns) {
		return "xdotool " + new SearchPatternBuilder(patterns).build();
	}
	
	private static void runOrCry(String cmd) {
		try {
			Runtime.getRuntime().exec(cmd).waitFor();
		} catch (Exception e) {
			throw new XDoToolException(e);
		}
	}
}
