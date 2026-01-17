package com.nt.test;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Cricketer;

public class LookupMethodInjection {

	public static void main(String[] args) {
		//create ioc container 
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		//get target class object
		Cricketer palyer=ctx.getBean("cktr",Cricketer.class);
		
		//check classes ( extra knowledge)
	     System.out.println(palyer.getClass()+" ");
	     System.out.println(palyer.getClass().getSuperclass()+" ");
		 System.out.println(Arrays.toString(palyer.getClass().getDeclaredMethods())+" ");
		//invoke methods 
		palyer.batting();
		palyer.batting();
		palyer.bowling();
		palyer.fielding();

	}
	/*advantages of lookup method injection:
	 * ======================================
	 * 1.no need of taking extra IOC container.
	 * 2.no need of enabling lazy-init on singletone scope spring beans.
	 * 3.Target spring bean class remains as non-invasive class
	 * 4.Every thing is done by IOC container.. so by generating inMemory proxy class 
	 * as a subclass of target class. so programmer gets advantages dependency lookup with 
	 * out any code for it.
	 * 4.it is indusry standary to perform dependency lookup operation.
	 * 
	 * Que: can i configure abstract class as spring bean .give me one examples??
	 * Que: 
	 *  */
	
	

}
