package org.github.taksan.main;

import java.io.File;

class TransferOperationsMock implements
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