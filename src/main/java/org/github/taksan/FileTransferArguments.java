package org.github.taksan;

import java.io.File;

public class FileTransferArguments {

	public final String targetUserId;
	public final File fileToTransfer;
	
	public FileTransferArguments(String targetUserId, File validFile) {
		super();
		this.targetUserId = targetUserId;
		this.fileToTransfer = validFile;
	}

}
