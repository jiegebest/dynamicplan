package designpattern.creation.singleton;

/**
 * 通用实现
 *
 * 饿汉式
 *
 * 都是 static 类变量，类方法
 * 都是 private 私有变量，私有构造，搭配公有获取方法
 */
public class LazySingleton {
	private static volatile LazySingleton instance = null;

	private LazySingleton() {
	}

	public static LazySingleton getInstance() {
		if (instance == null) {
			synchronized (LazySingleton.class) {
				if (instance == null) {
					instance = new LazySingleton();
				}
			}
		}
		return instance;
	}

	public static void doSomething() {
	}
}
