package com.adhamenaya.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // class level
public @interface TesterInfo{

	public enum Priority {
	   LOW, MEDIUM, HIGH
	}
	public Priority priority() default Priority.HIGH;
	public String createdBy() default "Adham Enaya";
	public String[] tags() default "";
	public String lastModified() default "09.07.2016";
}