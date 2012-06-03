package org.github.taksan;

import java.io.File;

public class FileSystemImpl implements FileSystem {

	@Override
	public boolean exists(File validFile) {
		return validFile.exists();
	}

}
