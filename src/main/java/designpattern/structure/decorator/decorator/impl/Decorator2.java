package designpattern.structure.decorator.decorator.impl;

import designpattern.structure.decorator.component.Component;
import designpattern.structure.decorator.decorator.Decorator;

public class Decorator2 extends Decorator {
	public Decorator2(Component component) {
		super(component);
	}

	public void preDecorate() {
		System.out.println("执行前装饰2...");
	}

	public void postDecorate() {
		System.out.println("执行后装饰2...");
	}

	@Override
	public void operate() {
		preDecorate();
		super.component.operate();
		postDecorate();
	}
}
