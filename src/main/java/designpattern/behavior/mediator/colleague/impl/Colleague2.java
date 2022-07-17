package designpattern.behavior.mediator.colleague.impl;

import designpattern.behavior.mediator.colleague.Colleague;
import designpattern.behavior.mediator.mediator.Mediator;

public class Colleague2 extends Colleague {
	public Colleague2(Mediator mediator) {
		super(mediator);
	}

	public void selfMethod() {
		System.out.println("Colleague2#selfMethod");
	}

	public void deepMethod() {
		System.out.println("Colleague2#deepMethod");
		super.mediator.doSomething1();
	}
}
