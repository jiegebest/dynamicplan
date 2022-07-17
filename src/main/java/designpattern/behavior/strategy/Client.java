package designpattern.behavior.strategy;

import designpattern.behavior.strategy.impl.ConcreteStrategy1;
import designpattern.behavior.strategy.impl.ConcreteStrategy2;

public class Client {
	public static void main(String[] args) {
		Strategy strategy1 = new ConcreteStrategy1();
		Strategy strategy2 = new ConcreteStrategy2();
		Context context1 = new Context(strategy1);
		Context context2 = new Context(strategy2);
		context1.doAnything();
		context2.doAnything();
	}
}
