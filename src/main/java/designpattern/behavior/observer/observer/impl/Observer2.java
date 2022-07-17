package designpattern.behavior.observer.observer.impl;

import designpattern.behavior.observer.observer.Observer;

public class Observer2 implements Observer {
	@Override
	public void update() {
		System.out.println("update Observer2");
	}
}
