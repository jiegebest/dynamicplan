package designpattern.behavior.mediator.mediator;

import designpattern.behavior.mediator.colleague.impl.Colleague1;
import designpattern.behavior.mediator.colleague.impl.Colleague2;

public abstract class Mediator {
	protected Colleague1 c1;
	protected Colleague2 c2;

	public void setColleague1(Colleague1 c1) {
		this.c1 = c1;
	}

	public void setColleague2(Colleague2 c2) {
		this.c2 = c2;
	}

	// 执行同事 1 的方法
	public abstract void doSomething1();
	// 执行同事 2 的方法
	public abstract void doSomething2();
}