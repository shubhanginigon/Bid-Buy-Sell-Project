package com.SAD.Main_Project.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PostSpringPrototype {
	private List<String> postList;
	
	public PostSpringPrototype() {
		postList = new ArrayList<String>();
	}
	
	public PostSpringPrototype(List<String> list) {
		this.postList=list;
	}
	
	public void loadData() {
		
	}
	
	public List<String> getPostList(){
		return postList;
	}
}
