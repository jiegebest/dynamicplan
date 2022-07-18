package designpattern.structure.proxy;

import designpattern.structure.proxy.adaptee.Subject;

public class Proxy implements Subject {
	private Subject subject;

	public Proxy(Subject subject) {
		this.subject = subject;
	}

	public void prev() {
		System.out.println("do prev");
	}

	public void post() {
		System.out.println("do post");
	}

	@Override
	public void run() {
		prev();
		this.subject.run();
		post();
	}
}
