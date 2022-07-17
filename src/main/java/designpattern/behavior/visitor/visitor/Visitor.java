package designpattern.behavior.visitor.visitor;

import designpattern.behavior.visitor.element.impl.Element1;
import designpattern.behavior.visitor.element.impl.Element2;

public interface Visitor {
	void visit(Element1 e);
	void visit(Element2 e);
}