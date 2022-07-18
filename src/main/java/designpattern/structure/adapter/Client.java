package designpattern.structure.adapter;

import designpattern.structure.adapter.target.Target;
import designpattern.structure.adapter.target.impl.Target1;

public class Client {
	public static void main(String[] args) {
		Target t1 = new Target1();
		t1.run();

		Adapter t2 = new Adapter();
		t2.run();
	}
}
