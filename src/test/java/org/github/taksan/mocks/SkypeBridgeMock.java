package org.github.taksan.mocks;

import java.util.List;

import org.github.taksan.FriendAdapter;
import org.github.taksan.SkypeBridge;

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
