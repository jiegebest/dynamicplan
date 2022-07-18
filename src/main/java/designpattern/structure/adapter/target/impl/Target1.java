package designpattern.structure.adapter.target.impl;

import designpattern.structure.adapter.target.Target;

public class Target1 implements Target {
	@Override
	public void run() {
		System.out.println("Target1 方法执行");
	}
}
