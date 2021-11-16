package com.dbs.employeemngt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dbs.employeemngt.config.Config;

public class Main {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new 
				AnnotationConfigApplicationContext(Config.class);
	}
}
