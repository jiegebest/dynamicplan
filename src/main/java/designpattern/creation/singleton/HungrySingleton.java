package designpattern.creation.singleton;

/**
 * 类初始化时完成单例实例的创建
 */
public class HungrySingleton {
	private static final HungrySingleton instance = new HungrySingleton();

	private HungrySingleton() {
	}

	public static HungrySingleton getInstance() {
		return instance;
	}

	public static void doSomeThing() {
		System.out.println("...");
	}
}
