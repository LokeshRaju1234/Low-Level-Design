package Concurrency;

import java.util.concurrent.*;

public class Completablefeature
{
    public static void main(String [] args) throws ExecutionException,InterruptedException
    {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(()->10 + 20);
        Integer res = future.get();
        CompletableFuture.supplyAsync(() ->
        {
            try
            {
                Thread.sleep(2000);
                System.out.println("Computation completed");
                return "completed";
            }
            catch(InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }).thenAccept(result -> {
            if(result.equals("completed"))
            {
                System.out.println("Perform Task1");
            }
            else{
                System.out.println("Task Failed");
            }
        });
    }
}
