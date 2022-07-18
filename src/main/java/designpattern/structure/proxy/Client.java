package designpattern.structure.proxy;

import designpattern.structure.proxy.adaptee.Subject;
import designpattern.structure.proxy.adaptee.impl.RealSubject;

public class Client {
	public static void main(String[] args) {
		Subject subject = new RealSubject();
		Proxy proxy = new Proxy(subject);
		proxy.run();
	}
}
