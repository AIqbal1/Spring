package com.spring.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class VirgoTraceAspect implements TraceBean
{

	private Logger LOGGER = LoggerFactory.getLogger( getClass() );
	
	private int callDepth;
	private boolean trace = false;
	
	@Override
	public void setTrace(boolean trace) {
		this.trace = trace;
	}
	
	@Before("execution(* com.spring.aspectj.*.*(..)) && !execution(* com.spring.aspectj.VirgoTraceAspect.*(..))")
	public void traceBefore(JoinPoint joinPoint) {
		callDepth++;
		trace("before", joinPoint);
	}

	@After("execution(* com.spring.aspectj.*.*(..)) && !execution(* com.spring.aspectj.VirgoTraceAspect.*(..))")
	public void traceAfter(JoinPoint joinPoint) {
		callDepth--;
		trace("after", joinPoint);
	}	

	private void trace(String prefix, Object message) {
		if(this.trace) {
			StringBuilder traceMessage = new StringBuilder();
			for(int i = 0; i < callDepth; i++) {
				traceMessage.append( " " );				
			}
			traceMessage.append(prefix + ": " + message);
			LOGGER.trace( traceMessage.toString() );
		}
	}
	
	
}
