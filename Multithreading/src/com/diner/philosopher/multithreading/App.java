package com.diner.philosopher.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = null;
        Philosopher [] philosophers = null;
        
        try {
            philosophers = new Philosopher[Constants.NUMBER_OF_PHILOSOPHER];
            Chopstick [] chopsticks = new Chopstick[Constants.NUMBER_OF_CHOPSTICKS];
            for(int i =0; i < Constants.NUMBER_OF_CHOPSTICKS;i++) {
                chopsticks[i] = new Chopstick(i);
            }
            executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHER);
            
            for(int i =0; i < Constants.NUMBER_OF_PHILOSOPHER;i++) {
                philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[ (i+1) % Constants.NUMBER_OF_CHOPSTICKS] );
                executorService.execute(philosophers[i]);
            }
            
            Thread.sleep(Constants.SIMILUATION_RUNNING_TIME);
            
            for(Philosopher p : philosophers) {
                p.setIsFull(true);
            }
            
        }finally {
            executorService.shutdown();
            while(!executorService.isTerminated()) {
                Thread.sleep(100);
            }
            
            for(Philosopher p : philosophers) {
                System.out.println(p+" eats "+p.getEatingCounter());
            }
        }
    }
}
