package designpattern;

public class Client {
	public static void main(String[] args) {
		Handler1 h1 = new Handler1();
		Handler2 h2 = new Handler2();
		h1.setNext(h2);

		h1.handle(2);
	}
}
