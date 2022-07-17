package designpattern.behavior.command.receiver.impl;

import designpattern.behavior.command.receiver.Receiver;

public class ConcreteReceiver2 extends Receiver {
	@Override
	public void doSomething() {
		System.out.println("执行接收者 2 的任务");
	}
}
