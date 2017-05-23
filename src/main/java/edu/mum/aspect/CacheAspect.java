package edu.mum.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import net.sf.ehcache.Cache;

/**  As the cache key, we're using a combination of the class name and the method name
 **/
@Aspect
public class CacheAspect {
	
	    private Cache methodCache;
	    
	    @Before("execution(* edu.mum.service..*(..))")
	    public void executor(ProceedingJoinPoint point) throws Throwable {

	        System.out.println("Cutting before...");
	        
	        Object retVal;
	        
	      /*  String methodName = point.getTarget().getClass().toString() + "," + point.toShortString();

	        if (methodCache.isKeyInCache(methodName)) {
	            System.out.println("Returning from cache....");
	            return methodCache.get(methodName).getObjectValue();
	        } else {
	            retVal = point.proceed();
	            
	            if (retVal != null) {
	                System.out.println("returned object: " + retVal.toString());
	                System.out.println("Storing into cache...");
	                
	                methodCache.put(new Element(methodName, retVal));
	            }
	            
	        }

	        System.out.println("Cutting after...");*/
	        
	      //  return retVal;
	    }

	    public Cache getMethodCache() {
	        return methodCache;
	    }

	    public void setMethodCache(Cache methodCache) {
	        this.methodCache = methodCache;
	    }
}
