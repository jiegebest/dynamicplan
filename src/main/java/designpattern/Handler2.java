package designpattern;

public class Handler2 extends Handler {
	@Override
	protected int getLevel() {
		return 2;
	}

	@Override
	protected void echo() {
		System.out.println("Handler2正在处理...");
	}
}
