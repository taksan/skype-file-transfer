package org.github.taksan.transfer.mocks;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.github.taksan.transfer.FileSystem;

public class FileSystemMock implements FileSystem {

	Map<String, List<File>> filesByDir = new LinkedHashMap<String, List<File>>();

	@Override
	public boolean exists(File validFile) {
		return true;
	}

	public void addDirAndFiles(String dirName, String[] dirFiles) {
		List<File> files = new ArrayList<File>();
		for (String fileName : dirFiles) {
			files.add(new File(dirName, fileName));
		}
		filesByDir.put(dirName, files);
	}

	@Override
	public boolean isDir(File validFile) {
		String absolutePath = validFile.getAbsolutePath();
		return filesByDir.containsKey(absolutePath);
	}

	@Override
	public List<File> listFiles(File validFile) {
		List<File> list = filesByDir.get(validFile.getAbsolutePath());
		if(list == null)
			return new ArrayList<File>();
		return list;
	}

}
