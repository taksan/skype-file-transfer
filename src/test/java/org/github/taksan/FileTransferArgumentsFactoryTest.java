package org.github.taksan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.github.taksan.mocks.FileSystemMock;
import org.github.taksan.mocks.SkypeBridgeMock;
import org.junit.Assert;
import org.junit.Test;

public class FileTransferArgumentsFactoryTest { 
	FileSystem fileSystem = new FileSystemMock();
	
	@Test
	public void onSkypeId_ShouldProduceValidSkypeId() {
		SkypeBridgeMock skypeBridge = new SkypeBridgeMock();
		FileTransferArgumentsFactory subject = new FileTransferArgumentsFactory(skypeBridge, fileSystem);
		
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
		FileTransferArgumentsFactory subject = new FileTransferArgumentsFactory(skypeBridge, fileSystem);
		
		FileTransferArguments args = subject.parse("full name", "relative/path");
		Assert.assertEquals("full name's id", args.targetUserId);
	}
	
	@Test
	public void onNonExistingFile_ShouldThrowException() {
		SkypeBridgeMock skypeBridge = new SkypeBridgeMock();
		FileSystem mockFs = new FileSystem() {
			@Override
			public boolean exists(File validFile) {
				return false;
			}
		};
		FileTransferArgumentsFactory subject = new FileTransferArgumentsFactory(skypeBridge, mockFs);
		
		try {
			subject.parse("foo_id", "relative/path");
			Assert.fail("Should have thrown exception");
		}catch(IllegalArgumentException e) {
			Assert.assertTrue(e.getCause() instanceof FileNotFoundException);
		}
	}
}