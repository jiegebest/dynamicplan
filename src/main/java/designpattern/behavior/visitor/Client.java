package designpattern.behavior.visitor;

import designpattern.behavior.visitor.element.impl.Element1;
import designpattern.behavior.visitor.element.impl.Element2;
import designpattern.behavior.visitor.visitor.impl.Visitor1;
import designpattern.behavior.visitor.visitor.impl.Visitor2;

public class Client {
	public static void main(String[] args) {
		Visitor1 v1 = new Visitor1();
		Visitor2 v2 = new Visitor2();
		Element1 e1 = new Element1();
		Element2 e2 = new Element2();

		e1.accept(v1);
		e2.accept(v2);
		e1.accept(v2);
		e2.accept(v1);
	}
}
