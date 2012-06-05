package org.github.taksan.transfer.mocks;

import java.util.List;

import org.github.taksan.transfer.FriendAdapter;
import org.github.taksan.transfer.SkypeBridge;

public class SkypeBridgeMock implements SkypeBridge {

	@Override
	public String getFriendById(String candidate) {
		return candidate;
	}

	@Override
	public List<FriendAdapter> getFriendsList() {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

}
