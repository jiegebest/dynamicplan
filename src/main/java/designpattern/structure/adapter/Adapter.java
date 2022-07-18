package designpattern.structure.adapter;

import designpattern.structure.adapter.target.Target;

public class Adapter extends Adaptee implements Target {
	@Override
	public void run() {
		super.doSomething();
	}
}
