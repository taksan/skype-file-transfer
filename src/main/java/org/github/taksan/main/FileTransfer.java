package org.github.taksan.main;

import java.io.File;
import java.io.IOException;

import org.github.taksan.FileTransferArguments;
import org.github.taksan.FileTransferArgumentsFactory;

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
		activateFileTransferWindow();
		typeFileNameInFileTransfer(transferArguments.fileToTransfer.getName());
	}

	private static void typeFileNameInFileTransfer(String fileName)
			throws InterruptedException, IOException {
		String typeFileNameAndPressEnter = "type " + fileName;		
		Runtime.getRuntime().exec("xdotool " + typeFileNameAndPressEnter).waitFor();
		Runtime.getRuntime().exec("xdotool key Return");
	}

	private static void activateFileTransferWindow()
			throws InterruptedException, IOException {
		String activateWindow = "xdotool search --onlyvisible gabriel-take search --onlyvisible send windowactivate ";
		Runtime.getRuntime().exec(activateWindow).waitFor();
	}
}
