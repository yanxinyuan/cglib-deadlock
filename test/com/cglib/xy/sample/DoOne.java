package com.cglib.xy.sample;

public class DoOne {

	static {
		init();
	}
  
	public void complete() {
		System.out.println("Do One.");
	}
	
	public static void init() {
		System.out.println("start init");
		
		Thread t1 = new Thread(new Runnable() {
	        @Override
	        public void run() {
	        	try {
	        		System.out.println("thread in");
					DoOne.class.getClassLoader().loadClass("com.cglib.for.fun");
					System.out.println("thread out");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
	        }
	    }, "Test-1");
	    
		try {
			t1.start();
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end init");
	}
}
