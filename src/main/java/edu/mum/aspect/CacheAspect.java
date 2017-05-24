package edu.mum.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

@Aspect
@Component
public class CacheAspect {
	
	@Autowired
	private  CacheManager cm;
	
	@Around("execution(* edu.mum.service.impl..findAll(..))")
    public Object cacheMethod(ProceedingJoinPoint point) throws Throwable 
    {       
		    Cache cache = cm.getCache("defaultCache");
	        Object retVal;	        
	        String methodName = point.getTarget().getClass().toString() + "," + point.toShortString();			

	        if (cache.isKeyInCache(methodName)) {
	            System.out.println("********** Returning from cache **********");
	            return cache.get(methodName).getObjectValue();
	        } else {
	            retVal = point.proceed();	            
	            if (retVal != null) {
	                //System.out.println("returned object: " + retVal.toString());
	                System.out.println("********** Storing into cache **********");                
	                cache.put(new Element(methodName, retVal));
	            }
	            
	        }
	        return retVal;
    }
	
}
