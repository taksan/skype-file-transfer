package org.github.taksan.main;

import java.io.File;

public class SkypeTransferListFormatter {

	public String format(File[] filesToTransfer) {
		StringBuffer sb = new StringBuffer();
		for (File file : filesToTransfer) {
			sb.append("\"");
			sb.append(file.getAbsolutePath());
			sb.append("\" ");
		}
		return sb.toString().trim();
	}

}
