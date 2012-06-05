package org.github.taksan.transfer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSystemImpl implements FileSystem {

	@Override
	public boolean exists(File validFile) {
		return validFile.exists();
	}

	@Override
	public boolean isDir(File validFile) {
		return validFile.isDirectory();
	}

	@Override
	public List<File> listFiles(File validFile) {
		List<File> files = new ArrayList<File>();
		File[] listFiles = validFile.listFiles();
		for (File file : listFiles) {
			files.add(file);
		}
		return files;
	}

}
