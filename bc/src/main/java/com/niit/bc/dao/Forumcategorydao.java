package com.niit.bc.dao;

import java.util.List;

import com.niit.bc.model.ForumCategory;

public interface Forumcategorydao {
	
	public List<ForumCategory> getAllForumCategory();
	
	public boolean forumCategoryUpdate(ForumCategory forumcategory);
		
	public ForumCategory getForumCategoryByID(int fcid);

}
