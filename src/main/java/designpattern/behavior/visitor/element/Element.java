package designpattern.behavior.visitor.element;

import designpattern.behavior.visitor.visitor.Visitor;

public abstract class Element {
	public abstract void doSomething();
	public abstract void accept(Visitor visitor);
}