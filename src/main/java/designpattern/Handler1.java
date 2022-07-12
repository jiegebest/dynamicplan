package designpattern;

public class Handler1 extends Handler {
	@Override
	protected int getLevel() {
		return 1;
	}

	@Override
	protected void echo() {
		System.out.println("Handler1正在处理...");
	}
}
