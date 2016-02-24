package com.javap.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.javap")
public class ExceptionHandlerUtil {
	protected Log log = LogFactory.getLog(ExceptionHandlerUtil.class);
	
	@ExceptionHandler(Exception.class)
	public void exceptionHandler(Exception e){
		log.debug("exception");
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView runtimeExceptionHandler(RuntimeException e){
		ModelAndView mv = new ModelAndView("/exception/runtimeException");
		mv.addObject("ExceptionMessage", e.getMessage());
		return mv;
	}
	
}

