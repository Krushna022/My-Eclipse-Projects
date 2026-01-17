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
	

	/*
	 * Advantages aware injection + dependency lookup:
	 * ==============================================
	 * 1.No need of taking   Ioc container in specific method of target class.
	 * because of awareinjection based underlying ioc container object ref injection.
	 * 2.No need of taking lazy-Init for singleton scope spring beans because here no extra ioc conatainer is required.
	 * 
	 * 
	 * disadvantages:
	 * ==============
	 * 1.taarget class becomes invasive class because it is implementating XxxAware interfaces.
	 * 2.The aware injection based injected ApplicationContext obj ref is visible throug out 
	 * target classs multiple methods though it is required only one 1 specific method because 
	 * (private applicagtionContext ctx is taken as teh HAS_A property in the target class level global visibility.
	 * 
	 * in order to solve thease problem..go for lookup method injection which says perform dependency lookup u do not write the code .
	 * let the ioc container write code internally by generating one inMemory proxy class dynamicallly at runtime.
	 * 
	 * 
	 */
	

}
