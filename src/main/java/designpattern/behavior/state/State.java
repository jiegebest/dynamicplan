package designpattern.behavior.state;

/**
 * 调用 handle1，执行者是 state1，调用 handle2，执行者是 state2
 */
public abstract class State {
	protected Context context;
	protected abstract void handle1();
	protected abstract void handle2();
}
