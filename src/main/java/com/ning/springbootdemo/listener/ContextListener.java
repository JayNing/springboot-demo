package com.ning.springbootdemo.listener;

import com.ning.springbootdemo.cache.UserCache;
import com.ning.springbootdemo.entity.User;
import com.ning.springbootdemo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    private static Logger logger = LoggerFactory.getLogger(ContextListener.class);

    @Autowired
    private UserCache userCache;
    @Autowired
    private IUserService userService;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("contextInitialized is called.");
        User user = userService.searchById(1);
        userCache.addUser(user.getUsername(),user);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("contextDestroyed is called.");
    }
}