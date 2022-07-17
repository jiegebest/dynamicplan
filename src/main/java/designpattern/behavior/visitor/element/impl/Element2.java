package designpattern.behavior.visitor.element.impl;

import designpattern.behavior.visitor.element.Element;
import designpattern.behavior.visitor.visitor.Visitor;

public class Element2 extends Element {
	@Override
	public void doSomething() {
		System.out.println("Element2 正在执行逻辑...");
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
