package designpattern.behavior.mediator;

import designpattern.behavior.mediator.colleague.impl.Colleague1;
import designpattern.behavior.mediator.colleague.impl.Colleague2;
import designpattern.behavior.mediator.mediator.Mediator;
import designpattern.behavior.mediator.mediator.impl.ConcreteMediator;

public class Client {
	public static void main(String[] args) {
		// 中介与同事之间形成紧密耦合
		Mediator mediator = new ConcreteMediator();
		Colleague1 c1 = new Colleague1(mediator);
		Colleague2 c2 = new Colleague2(mediator);
		mediator.setColleague1(c1);
		mediator.setColleague2(c2);

		c1.selfMethod();
		c1.deepMethod();
		System.out.println("-------------");
		c2.selfMethod();
		c2.deepMethod();
	}
}
