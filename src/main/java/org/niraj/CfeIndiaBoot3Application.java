package org.niraj;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//This is Starter Program. 
//No need for @ComponentScan | auto scan all sub folder of org.niraj


//@ComponentScan("org.niraj")
//@EnableTransactionManagement
@SpringBootApplication
public class CfeIndiaBoot3Application{
	private static final Logger logger = LoggerFactory.getLogger(CfeIndiaBoot3Application.class);

	public static void main(String[] args) {
		ApplicationContext appCtx = SpringApplication.run(CfeIndiaBoot3Application.class, args);
		int i = 1;
		for (String name : appCtx.getBeanDefinitionNames()) {
			logger.info("BEAN CONFIGURED  ==>[" + i + "]=> " + name);
			i++;
		}
	}
}

