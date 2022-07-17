package designpattern.behavior.strategy.impl;

import designpattern.behavior.strategy.Strategy;

public class ConcreteStrategy1 implements Strategy {
	@Override
	public void doSomething() {
		System.out.println("执行 ConcreteStrategy1 算法逻辑");
	}
}
