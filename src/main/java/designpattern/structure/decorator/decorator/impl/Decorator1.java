package designpattern.structure.decorator.decorator.impl;

import designpattern.structure.decorator.component.Component;
import designpattern.structure.decorator.decorator.Decorator;

public class Decorator1 extends Decorator {
	public Decorator1(Component component) {
		super(component);
	}

	public void preDecorate() {
		System.out.println("执行前装饰1...");
	}

	public void postDecorate() {
		System.out.println("执行后装饰1...");
	}

	@Override
	public void operate() {
		preDecorate();
		super.component.operate();
		postDecorate();
	}
}
