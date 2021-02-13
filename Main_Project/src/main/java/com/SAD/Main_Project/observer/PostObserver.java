package com.SAD.Main_Project.observer;

public interface PostObserver {
	
	//methods to subscribe/unsubscribe the user 
	public void subscribeUser(Observer observe);
	public void unsubscriberUser(Observer observe);
	
	//method to notify observer of any modifications
	public void notifyObserver();
	
	//method to get updates from product
	public Object getUpdate(Observer observe);
}
