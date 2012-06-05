package org.github.taksan.transfer.mocks;

import java.io.File;

import org.github.taksan.transfer.TransferOperations;

public class TransferOperationsMock implements
		TransferOperations {
	public final StringBuilder operationsResult = new StringBuilder();

	@Override
	public void openSkypeWindowOn(String targetUserId, File root) {
		operationsResult.append("openSkypeWindowOn: send '" + root.getAbsolutePath() + "' to "+targetUserId+"\n");
	}

	@Override
	public void typeFilesOnWindow(String targetUserId, String filesToSend) {
		operationsResult.append("activate window for user: "+targetUserId+" and typeFilesOnWindow:" + filesToSend);
	}

	public String getResult() {
		return operationsResult.toString();
	}
}