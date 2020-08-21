package org.zerock.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
public class MyListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	String location = sce.getServletContext().getInitParameter("contextConfigLocation");
    	String path = sce.getServletContext().getRealPath(location);
    	ApplicationContext context = new FileSystemXmlApplicationContext(path);
    	System.out.println(context.getBean("chef"));
    	System.out.println(context.getBean("restaurant"));
    	System.out.println("done");
    	((AbstractApplicationContext) context).close();
    }
	
}
