package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Cricketer;

public class DependencyLookupTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get target class object
		Cricketer palyer=ctx.getBean("cktr",Cricketer.class);
		
		//invoke methods 
		palyer.batting();
		palyer.bowling();
		palyer.fielding();

	}
	
	/* TO solve majoriy problems of Dependency lookup take the support
	 * Aware injection +Dependency lookup which avoids 
	 * the creationn of additional IOC container.
	 * */
	
	
	/*Advantages of dependency lookup:
	 * 1.The restrict the visibility and accessibility of dependent class object
	 * only to certain method of target class  
	 * 
	 * Limitations of Traditional dependency lookup:
	 * ==========================================
	 * 1.taking extra IOC container in specific method of target class improves burden of the programmer 
	 * and also kills the performance.
	 * Note: Two IOC container with Two inMemoryMetaData kills the performancee of the applicationn and uses more memory and cpu time.
	 * note:infact if batting() method is called for more times. then more additional IOC container will be created which causes more damage.
	 * 
	 *  2. Because of these multiple additional IOC container creation . the singleton scope spring bean will pre-instantiated for multiple times.
	 *  ie. more object will be create for singleton scope spring beans which are again unnecessary.
	 *  
	 *  This problem can be solved in two wasy:
	 *  1.take additional container as BeanFactory container.
	 *  2.use additional IOC container as ApplicationnContext container but enable lazy-init="true" on singleton scope bean.
	*/
	

}
