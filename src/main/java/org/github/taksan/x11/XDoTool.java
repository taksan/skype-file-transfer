package org.github.taksan.x11;

import java.io.IOException;


public class XDoTool {

	public static void activateWindowGivenPatterns(
			String... patterns) {
		String activateWindow = buildSearchQuery(patterns) + " windowactivate";
		runOrCry(activateWindow);
	}

	public static void writeln(String textToType)
			throws InterruptedException, IOException {
		runOrCry("xdotool type --delay 1ms '" + textToType + "'");
		runOrCry("xdotool key Return");
	}
	
	public static String quoteToType(String textToType) {
		return textToType.replace("\"","\\\"");
	}

	private static String buildSearchQuery(String... patterns) {
		return "xdotool " + new SearchPatternBuilder(patterns).build();
	}
	
	private static void runOrCry(String cmd) {
		try {
			System.out.println(cmd);
			Runtime.getRuntime().exec(cmd).waitFor();
		} catch (Exception e) {
			throw new XDoToolException(e);
		}
	}
}
