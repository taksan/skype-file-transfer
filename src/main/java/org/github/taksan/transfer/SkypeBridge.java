package org.github.taksan.transfer;

import java.util.List;


public interface SkypeBridge {

	String getFriendById(String candidate);

	List<FriendAdapter> getFriendsList();
}
