package designpattern.structure.decorator.decorator;

import designpattern.structure.decorator.component.Component;

public abstract class Decorator extends Component {
	public Component component;

	public Decorator(Component component) {
		this.component = component;
	}

	@Override
	public void operate() {
		component.operate();
	}
}
