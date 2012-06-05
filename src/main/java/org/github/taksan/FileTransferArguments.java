package org.github.taksan;

import java.io.File;

public class FileTransferArguments {

	public final String targetUserId;
	public final File[] filesToTransfer;
	
	public FileTransferArguments(String targetUserId, File [] validFiles) {
		super();
		this.targetUserId = targetUserId;
		this.filesToTransfer = validFiles;
	}

}
