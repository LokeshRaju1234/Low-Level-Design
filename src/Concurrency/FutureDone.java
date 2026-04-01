package Concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDone {
    public static void main(String[] args) throws ExecutionException,InterruptedException
    {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> future  = service.submit(()-> 30 + 20);

        System.out.println(future.isDone());//checking if the task is completed or not
        future.get();//waits unitl task is completed
        System.out.println(future.isDone());
    }
}
