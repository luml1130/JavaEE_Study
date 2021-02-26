import com.luml.spring1.Car;
import com.luml.spring1.Employee;
import com.luml.spring1.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SpringTest {
	
	
	@Test
	public void test1(){
		//读取spring配置文件，初始化spring工厂
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans1.xml");
		//ApplicationContext ctx = new FileSystemXmlApplicationContext("D:\\JavaEE-study\\spring_A1\\src\\beans.xml");
		
		//从工厂中获取一个对象
		UserService userService = (UserService) ctx.getBean("userService");
		userService.saveUser();

		//使用BeanFactory创建对象
		/*BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
		UserService userService = (UserService) beanFactory.getBean("userService");
		userService.saveUser();*/
	}
	
	//实例化对象的三种方式
	@Test
	public void test2(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans1.xml");
		UserService userService2 = (UserService) ctx.getBean("userService");
		UserService userService3 = (UserService) ctx.getBean("userService");
		UserService userService4 = (UserService) ctx.getBean("userService");
	}
	
	//Bean的生命周期方法
	@Test
	public void test3(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans1.xml");
		UserService userService = (UserService) ctx.getBean("userService5");
		userService.saveUser();
		ctx.destroy();//销毁spring工厂
	}
	
	//DI
	@Test
	public void test4(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans1.xml");
		Car car = (Car) ctx.getBean("car1");
		
		System.out.println(car.getName() + " " + car.getPrice());
		
		Car car2 = (Car) ctx.getBean("car2");
		
		Employee emp = (Employee) ctx.getBean("employee");
		Car car3 = emp.getCar();
		System.out.println(car3.getName() + " " + car3.getPrice());
		
		Car car4 = (Car) ctx.getBean("car3");
	}
	
	//注入集合属性
	@Test
	public void test5(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans2.xml");
		
		Car car = (Car) ctx.getBean("car4");
		System.out.println(car);
	}
	
	//使用多个配置文件
	@Test
	public void test6(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans1.xml");
	}
}
