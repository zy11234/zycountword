package com.example.springmvc.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.springmvc.core.DatabaseCounterImpl;
import com.example.springmvc.core.INamedCounter;

@Controller
@RequestMapping(value = "/")
public class HomeController {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
	private static final String COUNTER_NAME = "webcounter";

	//private static final INamedCounter nc = new MemoryCounterImpl(); //Use RAM based counter.
	private static final INamedCounter nc = new DatabaseCounterImpl(); // Use DB based counter.

	private static synchronized long getNextCounterValue() {
		nc.increase(COUNTER_NAME);
		return nc.getValue(COUNTER_NAME);
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome() {
		final String VIEW_INDEX = "index";
		Long counterValue = HomeController.getNextCounterValue();
		logger.info("Request hander welcome() get called: {}", counterValue);
        
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Welcome");
        mv.addObject("date", SDF.format(new Date()));
        mv.addObject("counter", counterValue);
        mv.setViewName(VIEW_INDEX);

        return mv;
	}
	
	/*
	public String welcome(ModelMap model) {
		final String VIEW_INDEX = "index";
		long counterValue = HomeController.getNextCounterValue();

		model.addAttribute("message", "Welcome");
		model.addAttribute("date", SDF.format(new Date()));
		model.addAttribute("counter", counterValue);
		logger.info("[welcome] counter : {}", counterValue);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;
	}
	*/

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public ModelAndView welcomeName(@PathVariable String name) {
		final String VIEW_INDEX = "index";
		Long counterValue = HomeController.getNextCounterValue();
		logger.info("Request hander welcomeName() get called: {}", counterValue);
        
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Welcome " + name);
        mv.addObject("date", SDF.format(new Date()));
        mv.addObject("counter", counterValue);
        mv.setViewName(VIEW_INDEX);

        return mv;
	}
}
