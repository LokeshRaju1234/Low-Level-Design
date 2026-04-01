package Concurrency;

public class SequenceGenerator
{
    int counter;//current number to print
    int N; //maximum limit

    public SequenceGenerator(int counter, int n) {
        this.counter = counter;
        this.N = n;
    }

    public void sequence(int index)
    {
        //only one thread can enter this block -->prevents race condition
        //Without this → multiple threads modify counter simultaneously → wrong order.
        synchronized (this)
        {
            //checking the limit
            while(counter < N)
            {
                //if it is not equal to its index then  the thread goes to waiting stage
                while (counter % 4 != index) {
                    try
                    {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

//                if(counter >= N)
//                {
//                    notifyAll();
//                    break;
//                }

                System.out.println("Counter: " + counter + ", Thread: " + Thread.currentThread().getName());
                counter++;//after printing it will inc to print next number
                notifyAll();//wakes all waiting threads and this all threads will recheck condition again
            }

        }
    }
}

class OddEven
{
    public  static  void main(String [] args) throws  InterruptedException
    {
        SequenceGenerator sequenceGenerator = new SequenceGenerator(0,30);//initializes the values

        //Thread A = new Thread(() -> sequenceGenerator.sequence(0),"A"); and A.start();
        //This creates and starts a new thread that runs the method: -->sequenceGenerator.sequence(0)
        Thread A = new Thread(() -> sequenceGenerator.sequence(0),"A");//Here A is thread name
        Thread B = new Thread(() -> sequenceGenerator.sequence(1),"B");
        Thread C = new Thread(() -> sequenceGenerator.sequence(2),"C");
        Thread D = new Thread(() -> sequenceGenerator.sequence(3),"D");

        A.start();
        B.start();
        C.start();
        D.start();
    }
}
