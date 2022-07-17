package designpattern.behavior.state;

import designpattern.behavior.state.impl.State1;

public class Client {
	public static void main(String[] args) {
		Context context = new Context();
		context.setCurrentState(new State1());
		context.handle2();
		context.handle1();
	}
}
