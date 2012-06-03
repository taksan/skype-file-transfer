package org.github.taksan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class FileTransferArgumentsFactory {
	private final SkypeBridge skypeBridge;
	private final FileSystem fileSystem;

	public FileTransferArgumentsFactory() {
		this(new SkypeBridgeImpl(), new FileSystemImpl());
	}
	
	FileTransferArgumentsFactory(SkypeBridge skypeBridge, FileSystem fileSystem) {
		this.skypeBridge = skypeBridge;
		this.fileSystem = fileSystem;
	}


	public FileTransferArguments parse(String... args) {
		exitIfWrongArguments(args);
		String targetUserId = findValidSkypeId(args[0]);
		File validFile = getExistingFileOrCry(args[1]);
		return new FileTransferArguments(targetUserId, validFile);
	}

	private File getExistingFileOrCry(String filepath) {
		try {
			File validFile = new File(filepath).getCanonicalFile();
			if (fileSystem.exists(validFile))
				return validFile;
			throw new FileNotFoundException("File " + validFile.getAbsolutePath() + " not found");
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	private String findValidSkypeId(String candidate) {
		String friend  = skypeBridge.getFriendById(candidate);
		if (friend != null) 
			return friend;

		List<FriendAdapter> friendsList = skypeBridge.getFriendsList();
		for (FriendAdapter friendAdapter : friendsList) {
			if (friendAdapter.fullname.equals(candidate))
				return friendAdapter.id;
		}

		throw new IllegalArgumentException("Contact " + candidate + " not found in your contact list");
	}

	private static void exitIfWrongArguments(String[] args) {
		if (args.length != 2) {
			System.err.println("Usage : <target user skypeid or fullname> <file to transfer>");
			throw new IllegalArgumentException();
		}
	}

}
