package com.SAD.Main_Project.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PostPrototype {
	private List<String> postList;

	public PostPrototype() {
		postList = new ArrayList<String>();
	}

	public PostPrototype(List<String> list) {
		this.postList = list;
	}

	public void loadData() {

	}

	public List<String> getPostList() {
		return postList;
	}
}
