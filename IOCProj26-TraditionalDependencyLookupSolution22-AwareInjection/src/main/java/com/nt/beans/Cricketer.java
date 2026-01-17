package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("cktr")
//@LazyInit("true")
public class Cricketer implements ApplicationContextAware {
	
	//no HAS-A property of dependent class
	private ApplicationContext ctx;
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("Cricketer.setApplicationContext(-)");
		this.ctx=ctx;
		
	}
	
	
	public Cricketer() {

		System.out.println("Cricketer:: 0 param constructor Cricketer()");
	}
	
	public void bowling() {
		System.out.println("cricketer is bowlinng");
	}
	 
	public void batting() {
		System.out.println("cricketer is batting");
		
		//creates additional IOC container
		//ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		//perform dependency lookup method to get dependent class object
		Bat bat=ctx.getBean("bat",Bat.class);  //DEpendency lookup code
		int score =bat.scoreRuns();
		System.out.println("criecter batting score is ::"+score);
		
	}
	public void fielding() {
		System.out.println("cricketer is fielding");
	}
	
	public void wicketKeeping() {
		System.out.println("cricketer si keeping the wicketes");
		
	}

	

}
