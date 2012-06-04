package org.github.taksan.main;

import java.io.File;
import java.io.IOException;

import org.github.taksan.FileTransferArguments;
import org.github.taksan.FileTransferArgumentsFactory;
import org.github.taksan.x11.XDoTool;

import com.skype.SkypeClient;
import com.skype.SkypeException;

public class FileTransfer {
	static {
		System.setProperty("skype.api.impl","dbus");
	}
	
	public static void main(String[] args) throws SkypeException, InterruptedException, IOException {
		FileTransferArguments transferArguments = new FileTransferArgumentsFactory().parse(args);
		
		openSkypeFileTransferWindow(transferArguments);
		executeFileTransfer(transferArguments);
	}

	private static void openSkypeFileTransferWindow(
			FileTransferArguments transferArguments) throws SkypeException,
			InterruptedException {
		File cwd = transferArguments.fileToTransfer.getParentFile();
		SkypeClient.showFileTransferWindow(transferArguments.targetUserId, cwd);
		Thread.sleep(100);
	}

	private static void executeFileTransfer(
			FileTransferArguments transferArguments)
			throws InterruptedException, IOException {
		XDoTool.activateWindowGivenPatterns(transferArguments.targetUserId, "send");
		XDoTool.writeln(transferArguments.fileToTransfer.getName());
	}
}
