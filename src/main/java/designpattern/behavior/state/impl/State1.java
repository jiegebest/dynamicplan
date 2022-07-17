package designpattern.behavior.state.impl;

import designpattern.behavior.state.Context;
import designpattern.behavior.state.State;

public class State1 extends State {
	@Override
	public void handle1() {
		System.out.println("State1正在处理...");
	}

	@Override
	public void handle2() {
		System.out.println("由 state1 切换 state2");
		super.context.setCurrentState(Context.STATE2);
		super.context.handle2();
	}
}
