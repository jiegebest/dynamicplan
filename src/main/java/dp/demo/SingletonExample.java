package dp.demo;

public class SingletonExample {

	private volatile static SingletonExample instance = null;

	public static SingletonExample getInstance() {
		if (instance == null) {
			synchronized (SingletonExample.class) {
				if (instance == null) {
					instance = new SingletonExample();
				}
			}
		}
		return instance;
	}

}
