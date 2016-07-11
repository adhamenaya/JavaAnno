package com.adhamenaya.annotations;

import com.adhamenaya.annotations.Test;
import com.adhamenaya.annotations.TesterInfo;
import com.adhamenaya.annotations.TesterInfo.Priority;

@TesterInfo(
	//priority = Priority.HIGH, 
	createdBy = "mkyong.com",  
	tags = {"sales","test" }
)
public class TestExample {

	@Test
	void testA(){
		if(true){
			throw new RuntimeException("Test always fails!");
		}
	}
	
	
	@Test(enabled = false)
	void testB(){
		if(false){
			throw new RuntimeException("Test always passes!");
		}
	}
	
	@Test(enabled = true)
	void testC(){
		if(10>1){
			// do nothing. This test always passes!
		}
	}

}