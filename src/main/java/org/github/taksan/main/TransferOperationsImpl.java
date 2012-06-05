package org.github.taksan.main;

import java.io.File;

import org.apache.commons.lang.UnhandledException;
import org.github.taksan.x11.XDoTool;

import com.skype.SkypeClient;

public class TransferOperationsImpl implements TransferOperations {

	@Override
	public void openSkypeWindowOn(String targetUserId, File root) {
		try {
			SkypeClient.showFileTransferWindow(targetUserId, root);
			Thread.sleep(100);
		}catch(Exception e) {
			throw new UnhandledException(e);
		}
	}

	@Override
	public void typeFilesOnWindow(String targetUserId, String filesToSend) {
		XDoTool.activateWindowGivenPatterns(targetUserId, "send");
		XDoTool.writeln(filesToSend);
	}

}
