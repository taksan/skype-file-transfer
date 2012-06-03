package org.github.taksan.mocks;

import java.io.File;

import org.github.taksan.FileSystem;

public class FileSystemMock implements FileSystem {

	@Override
	public boolean exists(File validFile) {
		return true;
	}

}
