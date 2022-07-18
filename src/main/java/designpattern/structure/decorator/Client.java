package designpattern.structure.decorator;

import designpattern.structure.decorator.component.Component;
import designpattern.structure.decorator.component.impl.Component1;
import designpattern.structure.decorator.decorator.impl.Decorator1;
import designpattern.structure.decorator.decorator.impl.Decorator2;

public class Client {
	public static void main(String[] args) {
		Component component = new Component1();
		component = new Decorator1(component);
		component = new Decorator2(component);
		component.operate();
	}
}
