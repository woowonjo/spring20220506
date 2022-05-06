package lecture.c04core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		String path = "lecture/c04core/context.xml";
		
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		Servlet s = context.getBean(Servlet.class);
		
		System.out.println(s);
		
		
		
	}
}
