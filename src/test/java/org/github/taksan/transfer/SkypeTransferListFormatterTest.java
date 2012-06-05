package org.github.taksan.transfer;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.github.taksan.transfer.SkypeTransferListFormatter;
import org.junit.Test;

public class SkypeTransferListFormatterTest { 
	@Test
	public void onFormat_ShouldReturnAListOfFilesWithQuotes() {
		SkypeTransferListFormatter subject = new SkypeTransferListFormatter();
		String fileList = subject.format(new File[]{new File("/foorot/foo1"),new File("/foorot/foo2")});
		assertEquals("\"/foorot/foo1\" \"/foorot/foo2\"", fileList);
	}
}