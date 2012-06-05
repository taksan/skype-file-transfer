package org.github.taksan;

@SuppressWarnings("serial")
public class FileNotFoundRuntimeException extends RuntimeException {

	public FileNotFoundRuntimeException(String msg) {
		super(msg);
	}
}
