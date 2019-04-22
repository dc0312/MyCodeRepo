package Programs.src.threads.executors.returningValues;

import Programs.src.threads.executors.common.*;

import java.util.concurrent.*;

public class ReturningValueUsingExecutorsSecondWay {

    public static void main(String[] args) {
        String currentThread = Thread.currentThread().getName();

        System.out.println("["+currentThread+"] Starting Main Thread");

        ExecutorService service = Executors.newCachedThreadPool(new NamedThreadsFactory());

        CompletionService<TaskResult<String,Integer>> tasks  = new ExecutorCompletionService<TaskResult<String,Integer>>(service);

        tasks.submit(new CalculationTaskB(50,20,1000));
        tasks.submit(new CalculationTaskB(10,40,500));
        tasks.submit(new CalculationTaskB(25,20,300));

        //Future result4 = service.submit(new LoopTaskA());
        tasks.submit(new LoopTaskA(), new TaskResult<String,Integer>("LoopTaskA-1",99));

        for(int i =0; i< 4;i++){
            try {
                System.out.println("Result = "+tasks.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
        System.out.println("["+currentThread+"] Ending Main Thread");
    }
}
