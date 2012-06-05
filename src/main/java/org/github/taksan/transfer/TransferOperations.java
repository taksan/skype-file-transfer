package org.github.taksan.transfer;

import java.io.File;

public interface TransferOperations {
	public void openSkypeWindowOn(String targetUserId, File root);
	public void typeFilesOnWindow(String targetUserId, String filesToSend);
}
