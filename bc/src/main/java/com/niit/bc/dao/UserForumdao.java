package com.niit.bc.dao;

import java.util.List;

import com.niit.bc.model.UserForum;
import com.niit.bc.model.UserForumcomments;

public interface UserForumdao {

	public List<UserForum> listAllForums();
	
	public boolean addForum(UserForum userforum);
	
	public List<UserForum> getForumByID(int forumid);
	
	public boolean getUpdateLike(int forumid);
	
	public boolean updateApprove(int forumid, char flag);

	public List<UserForumcomments> listAllForumComments(int forumid);
	
	public boolean addForumComment(UserForumcomments userforumcmt);
	
	public void updateForumCommentsCount(int forumid);
	
	public boolean deleteForum(int forumid);
}
