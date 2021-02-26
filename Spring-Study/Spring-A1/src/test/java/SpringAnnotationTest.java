import com.luml.spring1.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 测试spring注解
 * @author LuMengliang
 */
public class SpringAnnotationTest {
	
	@Test
	public void test1(){
		//读取spring配置文件，初始化spring工厂
		//ClassPathXmlApplicationContext
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		UserService userService = (UserService) ctx.getBean("userService");
		userService.save();
		
		ctx.destroy();
	}
}
