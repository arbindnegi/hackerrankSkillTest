/**
 * 
 */
package com.java.examples.thread;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Arbind Negi 04-Jul-2020
 *
 */
public class CyclicBarrierExample {

    public static void main(String[] args) {
	// 3 threads are part of the barrier devTeam1Thread, devTeam2Thread and main thread
	// thread calling them.
	final CyclicBarrier barrier = new CyclicBarrier(3);

	Thread devTeam1Thread = new Thread(new DevelopmentTeam1(barrier));
	Thread devTeam2Thread = new Thread(new DevelopmentTeam2(barrier));

	System.out.println("Starting development at" + new Date());

	devTeam1Thread.start();
	devTeam2Thread.start();
	
	try {
	    barrier.await();
	    
	} catch (InterruptedException  | BrokenBarrierException e) {
	    e.printStackTrace();
	} 
	System.out.println("Development is completed from all the Dev teams at "+new Date() + " and Handover successfully for the Testing to QA team");
	
    }
}

/**
 * development team 1 task
 **/

class DevelopmentTeam1 implements Runnable {

    private final CyclicBarrier cyclicBarrier;

    public DevelopmentTeam1(CyclicBarrier cyclicBarrier) {
	this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
	System.out.println("Development team 1 Starting the work...");
	try {
	    Thread.sleep(3000);
	} catch (InterruptedException e1) {
	    e1.printStackTrace();
	}
	System.out.println("Development team 1 has finished its work... waiting for others dev team to be complete...");
	try {
	    cyclicBarrier.await();

	} catch (InterruptedException | BrokenBarrierException e) {
	    System.out.println("Service one interrupted!");
	    e.printStackTrace();
	}
	System.out.println("The wait is over, lets handsover DevelopmentTeam1 task to QA team !");

    }
}

class DevelopmentTeam2 implements Runnable {

    private final CyclicBarrier cyclicBarrier;

    public DevelopmentTeam2(CyclicBarrier cyclicBarrier) {
	this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
	System.out.println("Development team 2 Starting the work...");
	try {
	    Thread.sleep(3000);
	} catch (InterruptedException e1) {
	    e1.printStackTrace();
	}
	System.out.println("Development team 2 has finished its work... waiting for others dev team to be complete...");
	try {
	    cyclicBarrier.await();

	} catch (InterruptedException | BrokenBarrierException e) {
	    System.out.println("Service one interrupted!");
	    e.printStackTrace();
	}
	System.out.println("The wait is over, lets handsover DevelopmentTeam2 task to QA team !");

    }
}
