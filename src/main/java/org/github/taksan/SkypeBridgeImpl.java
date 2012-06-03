package org.github.taksan;

import java.util.ArrayList;
import java.util.List;

import com.skype.ContactList;
import com.skype.Friend;
import com.skype.Skype;
import com.skype.SkypeException;


public class SkypeBridgeImpl implements SkypeBridge {

	@Override
	public String getFriendById(String candidate) {
		try {
			Friend friend = Skype.getContactList().getFriend(candidate);
			if (friend != null)
				return friend.getId();
			return null;
		} catch (SkypeException e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	public List<FriendAdapter> getFriendsList() {
		try {
			ContactList contactList = Skype.getContactList();
			Friend[] allFriends = contactList.getAllFriends();
			ArrayList<FriendAdapter> friends = new ArrayList<FriendAdapter>();
			for (Friend friend : allFriends) {
				friends.add(new FriendAdapter(friend.getId(), friend.getFullName()));
			}
			return friends;
			
		} catch (SkypeException e) {
			throw new IllegalStateException(e);
		}
	}

}
