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
		s += "高级Java工程师\n" +
				"美团 已上市\n" +
				"北京·3-5年·本科\n" +
				"25-50K·15薪\n" +
				"职位详情\n" +
				"\n" +
				"部门介绍：\n" +
				"外卖技术部承担外卖业务的技术开发工作，包括用户洞察、智能交互及交易引导、商家经营、平台运营等方面的系统、数据和策略实现，目标是为平台各参与角色提供高效易用的系统，持续迭代架构，保证稳定、安全、可扩展。\n" +
				"配餐业务是为企业提供综合用餐解决方案，其中包括外卖、配餐、到店用餐等，目标是用优质的供给链接企业客户，为企业员工带来更好的用餐体验。\n" +
				"\n" +
				"岗位职责：\n" +
				"1、负责配餐业务系统的建设，关键技术方案设计，核心功能开发，细化拆解业务需求并推动落地实施\n" +
				"2、理解配餐业务形态和目标，针对具体业务场景，分析业务需求、建立业务模型，撰写设计文档，与PM、QA、FE等一起协作，保障项目的落地\n" +
				"3、能够快速处理线上问题，对故障进行排查和处理，保证系统的安全、稳定、快速运行\n" +
				"4、积极参与技术学习和分享，能指导公司初、中级研发工作\n" +
				"\n" +
				"岗位基本要求：\n" +
				"1、三年及以上系统或后台开发经验，本科及以上学历；具备扎实的Java基础，优秀的编程能力和问题解决能力，具备核心业务系统或复杂业务系统开发经验\n" +
				"2、熟练掌握Java及面向对象设计开发，熟悉设计模式，熟练掌握linux命令\n" +
				"3、熟悉RPC协议、Spring、MyBatis、缓存、MQ、MySQL等常用中间件，熟悉JVM调优以及相关工具\n" +
				"4、有较强的逻辑思维能力，善于分析、归纳、解决问题；责任心强，荣誉感强；自我驱动，乐于学习与分享；能承受必要的工作压力\n" +
				"5、具备良好的团队合作精神和韧性，执行力和战斗力强，善于学习和思考，能独立分析和解决问题\n" +
				"\n" +
				"具备以下优先：\n" +
				"1、阅读过开源代码者优先\n" +
				"2、熟悉领域驱动设计，有一些相关心得者优先\n" +
				"3、有大型互联网公司或大型电商系统开发经验者优先\n" +
				"\n" +
				"岗位亮点：\n" +
				"配餐业务是到家BG重点发展方向，未来发展空间很大；有机会了解配餐业务用户侧、企业侧、供给侧等全流程业务；与运营、产品专家通力配合，深度参与业务策略的讨论和制定，拓宽自身能力边界，收获足够的成长；团队人际简单，求真务实的工作氛围。";

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
