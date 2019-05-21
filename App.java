package problem_issue12;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
    	ExecutorService executor = Executors.newFixedThreadPool(500);
    	
        System.out.println(Thread.currentThread().getName() + " Main thread starts here...");

        AddTwoNumbers task1 = new AddTwoNumbers(2, 3, 100);
        Future <Integer> future1 = executor.submit(task1);

        AddTwoNumbers task2 = new AddTwoNumbers(4, 5, 1000);
        Future <Integer> future2 = executor.submit(task2);

        AddTwoNumbers task3 = new AddTwoNumbers(6, 7, 500);
        Future <Integer> future3 = executor.submit(task3);
        
        try {
        	System.out.println("Result-1 = " + future1.get());
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
        try {
        	System.out.println("Result-2 = " + future2.get());
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
        try {
        	System.out.println("Result-3 = " + future3.get());
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
        System.out.println(Thread.currentThread().getName() + " Main thread ends here...");  
    }
}