package designpattern.behavior.state.impl;

import designpattern.behavior.state.Context;
import designpattern.behavior.state.State;

public class State2 extends State {
	@Override
	public void handle1() {
		System.out.println("由 state2 切换 state1");
		super.context.setCurrentState(Context.STATE1);
		super.context.handle1();
	}

	@Override
	public void handle2() {
		System.out.println("State2正在处理...");
	}
}