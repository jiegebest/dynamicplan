package designpattern.behavior.observer.subject.impl;

import designpattern.behavior.observer.subject.Subject;

public class Subject1 extends Subject {
	public void doSomething() {
		super.notifyObservers();
	}
}
