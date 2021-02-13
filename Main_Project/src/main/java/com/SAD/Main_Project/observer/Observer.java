package com.SAD.Main_Project.observer;

public interface Observer {
	
	//method to update the observer, used by subject
	public void updateObserver();
	
	//add product to observe
	public void setProduct(PostObserver post);

}
