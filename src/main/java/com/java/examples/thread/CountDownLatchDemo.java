package com.java.examples.thread;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Java Program to demonstrate how to use CountDownLatch, Its used when a main thread needs to wait for 
 * other threads before starting its work.
 * useful if you want to start main processing thread once its dependency is completed
 * * @author Arbind Negi  04-Jul-2020 */

public class CountDownLatchDemo {
    public static void main(String args[]) throws InterruptedException { 
	CountDownLatch latch = new CountDownLatch(4);
	
	Thread cacheService = new Thread(new Service(1000, latch, "Cache Service"));
	Thread databaseService = new Thread(new Service(1000, latch, "Database Service"));
	Thread resourcesInitilizerService = new Thread(new Service(1000, latch, "ResourcesInitilizer Service")); 
	Thread validationService = new Thread(new Service(1000, latch, "Validation Service")); 
	
	cacheService.start();
	databaseService.start(); 
	resourcesInitilizerService.start(); 
	validationService.start();
	
	// Main thread will wait until all thread finished 

	latch.await(); 
	System.out.println("All services are up, Application is starting now");
	
    }

}

/**
 * Service class which will be executed by Thread using CountDownLatch synchronizer.
 */

class Service  extends Thread {
    private final String name;
    private int timeToStart; 
    private CountDownLatch latch;
    
    public Service (int timeToStart, CountDownLatch latch, String name) { 
	this.name = name;
	this.timeToStart = timeToStart; 
	this.latch = latch; 
	}
    
    @Override public void run() { 
	try { 
	    Thread.sleep(timeToStart); 
	    System.out.println(name + " is Up and running now");
	    latch.countDown(); 
	  } 
	catch (InterruptedException e) { 
	    e.printStackTrace();
	    Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, e);
	    } 
	} 
    }
