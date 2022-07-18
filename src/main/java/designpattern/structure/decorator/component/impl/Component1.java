package designpattern.structure.decorator.component.impl;

import designpattern.structure.decorator.component.Component;

public class Component1 extends Component {
	@Override
	public void operate() {
		System.out.println("本职工作正在执行...");
	}
}
