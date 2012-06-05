package org.github.taksan.main;

import java.io.IOException;

import org.github.taksan.FileTransferArguments;
import org.github.taksan.FileTransferArgumentsFactory;

import com.skype.SkypeException;

public class FileTransfer {
	static {
		System.setProperty("skype.api.impl","dbus");
	}
	
	public static void main(String[] args) throws SkypeException, InterruptedException, IOException {
		FileTransferArguments transferArguments = getArgumentsOrExitOnError(args);
		new FileTransferExecution(transferArguments).execute();
	}

	private static FileTransferArguments getArgumentsOrExitOnError(String[] args) {
		try {
			return new FileTransferArgumentsFactory().parse(args);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		return null;
	}
}
