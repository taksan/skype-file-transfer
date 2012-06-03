package org.github.taksan;

import java.util.List;


public interface SkypeBridge {

	String getFriendById(String candidate);

	List<FriendAdapter> getFriendsList();
}
