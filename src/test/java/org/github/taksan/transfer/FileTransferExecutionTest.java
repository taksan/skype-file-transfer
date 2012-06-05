package org.github.taksan.transfer;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.github.taksan.transfer.mocks.TransferOperationsMock;
import org.junit.Test;

public class FileTransferExecutionTest { 
	@Test
	public void onExecuteWithSingleFile_ShouldOpenWindowOnceAndTypeFiles()
	{
		FileTransferArguments transferArguments =
				new FileTransferArguments("foouser", new File[]{new File("/fakeroot/f1")});
		
		TransferOperationsMock operations = new TransferOperationsMock();
		FileTransferExecution subject = new FileTransferExecution(
				transferArguments,
				operations
				);
		
		subject.execute();
		String expected=
				"openSkypeWindowOn: send '/fakeroot' to foouser\n" + 
				"activate window for user: foouser and typeFilesOnWindow:\"/fakeroot/f1\"";
		assertEquals(expected, operations.getResult());
	}
}