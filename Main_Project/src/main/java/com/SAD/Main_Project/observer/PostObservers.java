package com.SAD.Main_Project.observer;

import java.util.ArrayList;
import java.util.List;

public class PostObservers implements PostObserver {

	private List<Observer> observers;
	private String message;
	private boolean ischanged;
	private final Object MUTEX = new Object();

	public PostObservers() {
		this.observers = new ArrayList<>();
	}

	@Override
	// subscribe user to observer list
	public void subscribeUser(Observer observe) {
		if (observe == null)
			throw new NullPointerException("Null Observer");
		synchronized (MUTEX) {// This is to make sure the notification
			// is sent only to subscribed observers
			if (!observers.contains(observe))
				observers.add(observe);
		}
	}

	@Override
	// un-subscribe user from observer list
	public void unsubscriberUser(Observer observe) {
		synchronized (MUTEX) {
			observers.remove(observe);
		}
	}

	@Override
	// Notify the observer
	public void notifyObserver() {
		List<Observer> observer = null;

		synchronized (MUTEX) {
			if (!ischanged)
				return;
			observer = new ArrayList<>(this.observers);
			this.ischanged = false;
		}
		for (Observer observe : observers) {
			observe.updateObserver();
		}

	}

	@Override
	public Object getUpdate(Observer observe) {
		return this.message;
	}

	// method to post message to the product
	public void updateMessage(String msg) {
		System.out.println();
		this.message = msg;
		this.ischanged = true;
		notifyObserver();
	}

}
