package com.example.springmvc.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.springmvc.service.INamedCounter;
import com.example.springmvc.service.impl.NamedCounterFactory;

@Controller
@RequestMapping(value = "/")
public class HomeController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(HomeController.class);
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    private static final String COUNTER_NAME = "webcounter";

    //public static final INamedCounter namedCounter = NamedCounterFactory.getCounterImpl("MemoryCounter");
    public static final INamedCounter namedCounter = NamedCounterFactory.getCounterImpl("DatabaseCounter");

    private static long getNextCounterValue() {
        return namedCounter.increase(COUNTER_NAME);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcome() {
        final String VIEW_INDEX = "index";
        Long counterValue = getNextCounterValue();
        logger.info("Request hander welcome() get called: {}", counterValue);

        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Welcome");
        mv.addObject("date", SDF.format(new Date()));
        mv.addObject("counter", counterValue);
        mv.setViewName(VIEW_INDEX);

        return mv;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ModelAndView welcomeName(@PathVariable String name) {
        final String VIEW_INDEX = "index";
        Long counterValue = getNextCounterValue();
        logger.info("Request hander welcomeName() get called: {}", counterValue);

        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Welcome " + name);
        mv.addObject("date", SDF.format(new Date()));
        mv.addObject("counter", counterValue);
        mv.setViewName(VIEW_INDEX);

        return mv;
    }
}
