package designpattern.behavior.observer;

import designpattern.behavior.observer.observer.Observer;
import designpattern.behavior.observer.observer.impl.Observer1;
import designpattern.behavior.observer.observer.impl.Observer2;
import designpattern.behavior.observer.subject.impl.Subject1;

public class Client {
	public static void main(String[] args) {
		Subject1 subject = new Subject1();
		Observer o1 = new Observer1();
		Observer o2 = new Observer2();

		subject.add(o1);
		subject.add(o2);
		subject.doSomething();
	}
}
