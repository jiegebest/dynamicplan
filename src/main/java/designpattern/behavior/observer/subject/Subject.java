package designpattern.behavior.observer.subject;

import designpattern.behavior.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	private List<Observer> list = new ArrayList<>();

	public void add(Observer o) {
		this.list.add(o);
	}

	public void delete(Observer o) {
		this.list.remove(o);
	}

	public void notifyObservers() {
		for (Observer o : this.list) {
			o.update();
		}
	}
}
