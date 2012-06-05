package org.github.taksan.transfer;

import java.io.File;
import java.util.List;

public interface FileSystem {

	boolean exists(File validFile);

	boolean isDir(File validFile);

	List<File> listFiles(File validFile);

}
