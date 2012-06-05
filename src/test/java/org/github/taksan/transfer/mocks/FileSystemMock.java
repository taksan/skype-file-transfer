package org.github.taksan.transfer.mocks;

import java.io.File;

import org.github.taksan.transfer.FileSystem;

public class FileSystemMock implements FileSystem {

	@Override
	public boolean exists(File validFile) {
		return true;
	}

}
