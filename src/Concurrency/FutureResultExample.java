package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureResultExample
{
    public static void main(String[] args) throws Exception
    {
        //only single thread will be created
        //-->actually we are creating a thread pool which has only one worker thread to execute tasks
        //reuse same thread again and again by avoiding creating the thread again and again
        ExecutorService executor = Executors.newSingleThreadExecutor();

        //future -->the res will not be ready immediately,but you can retrieve it later when the computation finishes
        Future<Integer> future = executor.submit(() -> 10 + 20);
        //->we can later get that result but using future.get()

        Integer result = future.get(); //waits until the result is ready (blocking call)
        System.out.println(result);

        //stops accepting new tasks
        executor.shutdown();
    }
}
