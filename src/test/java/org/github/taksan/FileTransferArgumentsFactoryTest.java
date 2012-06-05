package org.github.taksan;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.github.taksan.mocks.FileSystemMock;
import org.github.taksan.mocks.SkypeBridgeMock;
import org.junit.Assert;
import org.junit.Test;

public class FileTransferArgumentsFactoryTest { 
	FileSystem fileSystem = new FileSystemMock();
	SkypeBridgeMock skypeBridge = new SkypeBridgeMock();
	FileTransferArgumentsFactory subject = new FileTransferArgumentsFactory(skypeBridge, fileSystem);
	
	@Test
	public void onSkypeId_ShouldProduceValidSkypeId() {
		FileTransferArguments args = subject.parse("foo_id", "relative/path");
		Assert.assertEquals("foo_id", args.targetUserId);
	}
	
	@Test
	public void onSkypeFullName_ShouldReturnSkypeId(){
		SkypeBridge skypeBridge = new SkypeBridge() {
			@Override
			public String getFriendById(String candidate) {
				return null;
			}
			
			@Override
			public List<FriendAdapter> getFriendsList() {
				return Arrays.asList(new FriendAdapter("full name's id","full name"));
			}
		};
		FileTransferArgumentsFactory newSubject = new FileTransferArgumentsFactory(skypeBridge, fileSystem);
		
		FileTransferArguments args = newSubject.parse("full name", "relative/path");
		Assert.assertEquals("full name's id", args.targetUserId);
	}
	
	@Test
	public void onSeveralFiles_ShouldGenerateAListOfFiles(){
		FileTransferArguments args = subject.parse("full name", "/fakeroot/relative/1","/fakeroot/relative/2");
		String actual = StringUtils.join(args.filesToTransfer,"\n");
		Assert.assertEquals(
				"/fakeroot/relative/1\n" +
				"/fakeroot/relative/2", 
				actual);
	}
	
	@Test
	public void onFilesWithDifferentRoots_ShouldThrowException()
	{
		try {
			subject.parse("full name", "/root1/relative/1","/root2/relative/2");
			Assert.fail("Should throw exception");
		}catch(FilesWithDifferentRootsNotAllowedException ex) {
			assertEquals("/root1/relative/1 and /root2/relative/2 have different roots.", 
					ex.getMessage());
		}
	}
	
	@Test
	public void onNonExistingFile_ShouldThrowException() {
		FileSystem mockFs = new FileSystem() {
			@Override
			public boolean exists(File validFile) {
				return false;
			}
		};
		FileTransferArgumentsFactory subject = new FileTransferArgumentsFactory(skypeBridge, mockFs);
		
		try {
			subject.parse("foo_id", "/relative/path");
			Assert.fail("Should have thrown exception");
		}catch(FileNotFoundRuntimeException e) {
			assertEquals("File /relative/path not found", e.getMessage());
		}
	}
}