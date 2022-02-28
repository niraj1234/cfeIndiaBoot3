package org.niraj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProductAspect {

	private static final Logger logger = LoggerFactory.getLogger(ProductAspect.class);
	
	@Before(value="execution(* org.niraj.controller.ProductController.getProductById(..)) ")
	public void getProductRecordBeforeAdvice(JoinPoint jp){
//		logger.info("[Aspect] ProductID-"+jp.getArgs()[0]);
		System.out.println("[Aspect] ProductID-"+jp.getArgs()[0]);
		int productId = (int) jp.getArgs()[0];
		if(productId < 5 && productId > 2){
//			logger.info("[Aspect] Sending email ==> GMail for ProductID-"+jp.getArgs()[0]);
			System.out.println("[Aspect] Sending email ==> GMail for ProductID-"+jp.getArgs()[0]);
		}
	}

	
	@After(value="execution(* org.niraj.controller.ProductController.getProductById(..)) " )
	public void getProductRecordAfterAdvice(JoinPoint jp){
		int productId = (int) jp.getArgs()[0];
		if(productId < 5 && productId > 2){
//			logger.info("[Aspect] GMail sent for ProductID-"+jp.getArgs()[0]);
			System.out.println("[Aspect] GMail sent for ProductID-"+jp.getArgs()[0]);
		}
	}

	
	@AfterReturning(value="execution( * org.niraj.controller.ProductController.getAllProducts(..))")
	public void productInfoAfterReturningAdvice(JoinPoint jp){
//		logger.info("[Aspect AfterReturning ] for method - "+jp.getSignature());
		System.out.println("[Aspect AfterReturning ] for method - "+jp.getSignature());
	}

	
	@AfterThrowing(value="execution( * org.niraj.controller.ProductController.getProductById(..))" , throwing = "ex")
	public void productInfoAfterThrowingAdvice(JoinPoint jp , Exception ex){
//		logger.info("[Aspect AfterThrowing ] for method - "+jp.getSignature());
//		logger.error("Exception in Aspect "+ ex.getMessage());
		System.out.println("[Aspect AfterThrowing ] for method - "+jp.getSignature());
		System.out.println("Exception in Aspect "+ ex.getMessage());
	}
	

}
