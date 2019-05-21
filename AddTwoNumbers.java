package problem_issue12;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AddTwoNumbers implements Callable <Integer>{

    private int a;
    private int b;
    private long sleepTime;
    private int sum;

    public AddTwoNumbers(int a, int b, long sleepTime) {
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;
    }
    
    public Integer call() throws Exception {
        // TODO Auto-generated method stub
    	System.out.println(Thread.currentThread().getName() + " start running ...");

        try {
            System.out.println(Thread.currentThread().getName() + " sleeping for " + sleepTime + " millis");
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        sum = a+b;
        System.out.println(Thread.currentThread().getName() + " done ...");
	return sum;
	}  
}