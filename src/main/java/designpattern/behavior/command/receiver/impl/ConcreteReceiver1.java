package designpattern.behavior.command.receiver.impl;

import designpattern.behavior.command.receiver.Receiver;

public class ConcreteReceiver1 extends Receiver {
	@Override
	public void doSomething() {
		System.out.println("执行接收者 1 的任务");
	}
}
