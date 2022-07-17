package designpattern.behavior.command;

import designpattern.behavior.command.command.Command;
import designpattern.behavior.command.command.ConcreteCommand;
import designpattern.behavior.command.receiver.Receiver;
import designpattern.behavior.command.receiver.impl.ConcreteReceiver1;
import designpattern.behavior.command.receiver.impl.ConcreteReceiver2;

public class Client {
	public static void main(String[] args) {
		Receiver receiver = new ConcreteReceiver1();
		Receiver receiver2 = new ConcreteReceiver2();
		Command command1 = new ConcreteCommand(receiver);
		Command command2 = new ConcreteCommand(receiver2);
		Invoker invoker = new Invoker();

		invoker.setCommand(command1);
		invoker.action();
		invoker.setCommand(command2);
		invoker.action();
	}
}
