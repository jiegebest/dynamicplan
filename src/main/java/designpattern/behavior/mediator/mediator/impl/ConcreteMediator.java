package designpattern.behavior.mediator.mediator.impl;

import designpattern.behavior.mediator.mediator.Mediator;

public class ConcreteMediator extends Mediator {
	@Override
	public void doSomething1() {
		c1.selfMethod();
	}

	@Override
	public void doSomething2() {
		c2.selfMethod();
	}
}
