package designpattern.behavior.mediator.colleague.impl;

import designpattern.behavior.mediator.colleague.Colleague;
import designpattern.behavior.mediator.mediator.Mediator;

public class Colleague1 extends Colleague {
	public Colleague1(Mediator mediator) {
		super(mediator);
	}

	public void selfMethod() {
		System.out.println("Colleague1#selfMethod");
	}

	public void deepMethod() {
		// 处理自己的业务逻辑
		System.out.println("Colleague1#deepMethod");
		// 自己不能处理的业务逻辑，委托给中介者处理
		super.mediator.doSomething2();
	}
}
