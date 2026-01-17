package com.nt.beans;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("cktr")
public abstract class Cricketer {
	//no HAS-A property of dependent class
	
	public Cricketer() {

		System.out.println("Cricketer:: 0 param constr");
	}
	
	public void bowling() {
		System.out.println("cricketer is bowlinng");
	}
	
	// In this method will be implemented in the 
	// inMemory proxy class of this classs having 
	// Dependency lookup logic
	
	@Lookup
	public abstract Bat createBat();
	
	public void batting() {
		System.out.println("cricketer is batting");
		
		//get dependent class object
		Bat bat=createBat();
		
		//invoke methods
		int score =bat.scoreRuns();
		System.out.println("criecter batting score is ::"+score);
		
	}
	public void fielding() {
		System.out.println("cricketer is fielding");
	}
	
	public void wicketKeeping() {
		System.out.println("cricketer is keeping the wicketes");
		
	}

}
