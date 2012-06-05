package org.github.taksan.main;

import org.github.taksan.FileTransferArguments;

public class FileTransferExecution {

	private final FileTransferArguments transferArguments;
	private final TransferOperations operations;

	public FileTransferExecution(FileTransferArguments transferArguments) {
		this(transferArguments, new TransferOperationsImpl());
	}
	
	FileTransferExecution(FileTransferArguments transferArguments, TransferOperations operations) {
		this.transferArguments = transferArguments;
		this.operations = operations;
	}


	public void execute() {
		operations.openSkypeWindowOn(transferArguments.targetUserId, transferArguments.getBasePath());
		String filesToSend = new SkypeTransferListFormatter().format(transferArguments.filesToTransfer);
		operations.typeFilesOnWindow(transferArguments.targetUserId, filesToSend);
	}

}
