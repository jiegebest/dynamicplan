package designpattern.structure.proxy.adaptee.impl;

import designpattern.structure.proxy.adaptee.Subject;

public class RealSubject implements Subject {
	@Override
	public void run() {
		System.out.println("真正对象执行");
	}
}
