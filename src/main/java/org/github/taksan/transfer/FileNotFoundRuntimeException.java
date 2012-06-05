package org.github.taksan.transfer;

@SuppressWarnings("serial")
public class FileNotFoundRuntimeException extends RuntimeException {

	public FileNotFoundRuntimeException(String msg) {
		super(msg);
	}
}
