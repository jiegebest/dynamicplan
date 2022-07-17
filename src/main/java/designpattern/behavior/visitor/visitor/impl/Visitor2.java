package designpattern.behavior.visitor.visitor.impl;

import designpattern.behavior.visitor.element.impl.Element1;
import designpattern.behavior.visitor.element.impl.Element2;
import designpattern.behavior.visitor.visitor.Visitor;

public class Visitor2 implements Visitor {
	@Override
	public void visit(Element1 e1) {
		System.out.println("Visitor2 开始访问 Element1");
		e1.doSomething();
	}
	@Override
	public void visit(Element2 e2) {
		System.out.println("Visitor2 开始访问 Element2");
		e2.doSomething();
	}
}
