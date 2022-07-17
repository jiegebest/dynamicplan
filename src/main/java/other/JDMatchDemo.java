package other;

/**
 * 仅做参考，满分 135
 *
 * <60      不匹配
 * 60~80  较匹配
 * >80      特别匹配
 */
public class JDMatchDemo {

	static int grade = 0;

	public static void main(String[] args) {
		String s = "大厂,40w";
		s += "";

		matches(s);
		interest(s);
		lightspot(s);
		benefit(s);

		System.out.println("岗位匹配度达到" + grade + "%");
	}

	// 60
	public static void matches(String s) {
		// 工作年限
		if (contains(s,"本科") || contains(s,"计算机相关专业") || contains(s,"985") || contains(s,"211")) {
			grade += 5;
		}
		if (contains(s,"2年") || contains(s,"3年") || contains(s, "三年") || contains(s,"4年") || contains(s,"3~5年") || contains(s,"3-5年")) {
			grade += 5;
		}
		if (contains(s,"5年") || contains(s,"1年")) {
			grade -= 5;
		}

		// 职级
		if (contains(s,"高级")) {
			grade += 5;
		}
		if (contains(s,"资深") || contains(s,"专家") || contains(s,"Leader") || contains(s,"架构师")) {
			grade -= 5;
		}

		// 能力
		if (contains(s,"操作系统") || contains(s,"网络") || contains(s,"计算机科学")) {
			grade += 5;
		}
		if (contains(s,"系统设计")) {
			grade += 5;
		}
		if (contains(s,"spring") || contains(s,"springboot") || contains(s,"spring boot")) {
			grade += 5;
		}
		if (contains(s,"微服务") || contains(s,"springcloud") ||  contains(s,"spring cloud") || contains(s,"框架")) {
			grade += 5;
		}
		if (contains(s,"数据结构和算法") || contains(s,"数据结构算法")) {
			grade += 15;
		}
		if (contains(s,"mysql")) {
			grade += 10;
		}
		if (contains(s,"后台") || contains(s,"java") || contains(s,"转go")) {
			grade += 10;
		}
		if (contains(s,"多线程") || contains(s,"并发")) {
			grade += 5;
		}
		if (contains(s,"jvm")) {
			grade += 5;
		}
		if (contains(s,"设计模式")) {
			grade += 5;
		}
		if (contains(s,"redis") || contains(s,"Nosql") || contains(s,"缓存")) {
			grade += 5;
		}
		if (contains(s,"kafka") || contains(s,"mq")  || contains(s,"消息队列")) {
			grade += 5;
		}
		if (contains(s,"分布式") || contains(s,"zookeeper") || contains(s,"zk")) {
			grade += 5;
		}
		if (contains(s,"Netty") || contains(s,"netty")) {
			grade += 5;
		}

	}

	// 10
	public static void interest(String s) {
		// 核心业务
		if (contains(s,"大厂") || contains(s,"阿里") || contains(s,"美团") || contains(s,"滴滴") || contains(s,"快手") || contains(s,"字节") || contains(s,"腾讯") || contains(s,"microsoft") || contains(s,"amazon") || contains(s,"shopee")) {
			grade += 5;
		}
		if (contains(s,"核心")) {
			grade += 5;
		}

		// 兴趣偏好
		if (contains(s,"中间件") || contains(s,"引擎") || contains(s,"基础组件") || contains(s,"中台")) {
			grade += 5;
		}
	}

	// 5
	public static void lightspot(String s) {
		if (contains(s, "高并发") || contains(s, "大流量")) {
			grade += 5;
		}
	}

	// 5
	public static void benefit(String s) {
		if (contains(s, "租房补贴") || contains(s, "租房津贴")) {
			grade += 5;
		}
		if (contains(s, "40w")) {
			grade += 5;
		}
	}
	
	public static boolean contains(String s1, String s2) {
		String s3 = s1.toLowerCase();
		String s4 = s2.toLowerCase();
		return s3.contains(s4);
	}

}
