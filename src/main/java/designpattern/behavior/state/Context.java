package designpattern.behavior.state;

import designpattern.behavior.state.impl.State1;
import designpattern.behavior.state.impl.State2;

/**
 * 上下文
 * 谁的状态谁处理，context 只是来协调处理的
 */
public class Context {
	// 包含所有状态：可以在委托不同状态执行
	public final static State STATE1 = new State1();
	public final static State STATE2 = new State2();
	// 包含当前状态：可以在这里切换当前状态
	private State currentState;

	// 切换状态
	public void setCurrentState(State currentState) {
		this.currentState = currentState;
		// 为状态设置上下文
		this.currentState.context = this;
	}

	// 调用对应的状态处理逻辑
	public void handle1() {
		this.currentState.handle1();
	}

	public void handle2() {
		this.currentState.handle2();
	}
}
