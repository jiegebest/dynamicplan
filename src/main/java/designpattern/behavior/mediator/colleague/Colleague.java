package designpattern.behavior.mediator.colleague;

import designpattern.behavior.mediator.mediator.Mediator;

public abstract class Colleague {
	protected Mediator mediator;

	public Colleague(Mediator mediator) {
		this.mediator = mediator;
	}
}
