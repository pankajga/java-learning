package multithreading;

public class VolatileDemo {
    
    private volatile boolean flag1;

    public boolean isFlag1() {
        return flag1;
    }

    public void setFlag1(boolean flag1) {
        this.flag1 = flag1;
    }
    
    public static void main(String[] args) {
        VolatileDemo volatileDemo = new VolatileDemo();

        //Thread 1
        new Thread(() -> {
            System.out.println("Thread 1 started");
            try {
                System.out.println("Thread 1 logic started");
                Thread.sleep(1000);
                System.out.println("Thread 1 logic completed");
                volatileDemo.setFlag1(true);
                System.out.println("Flag set by Thread 1");
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }).start();

        //Thread 2
        new Thread(() -> {
            System.out.println("Thread 2 started");
            while (!volatileDemo.isFlag1()) {
                // It will run until flag value is true
                //System.out.println("running inside while");
            }
            System.out.println("Thread 2 logic completed");
        }).start();
    }

    // https://www.youtube.com/watch?v=wSPOlagY9dw
    // https://medium.com/codex/volatile-keyword-in-java-9e8792b4e6ba#:~:text=The%20volatile%20keyword%20in%20Java,value%20for%20the%20volatile%20variable.

    // When volatile not used:
    // Thread 1 started
    // Thread 1 logic started
    // Thread 2 started
    // Thread 1 logic completed
    // Flag set by Thread 1

    // When volatile used
    // Thread 1 started
    // Thread 1 logic started
    // Thread 2 started
    // Thread 1 logic completed
    // Flag set by Thread 1
    // Thread 2 logic completed

    // The volatile keyword in Java is used to mark a Java variable as “being stored in main memory”.

    // Every thread that accesses a volatile variable will read it from main memory, and not from the 
    // CPU cache. This way, all threads see the same value for the volatile variable.
}
