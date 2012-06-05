package org.github.taksan;

@SuppressWarnings("serial")
public class FilesWithDifferentRootsNotAllowedException extends
		RuntimeException {

	public FilesWithDifferentRootsNotAllowedException(String msg) {
		super(msg);
	}

}
