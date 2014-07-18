package thread.local;

import java.text.SimpleDateFormat;

public class ThreadLocalTest2 implements Runnable {

    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {

	@Override
	protected SimpleDateFormat initialValue() {
	    System.out.println("create SDF for each thread: " + Thread.currentThread().getName());
	    return new SimpleDateFormat("dd/MM/yyyy");
	}
    };

    public static void main(String[] args) throws InterruptedException {
	ThreadLocalTest2 obj = new ThreadLocalTest2();
	for (int i = 1; i <= 5; i++) {
	    Thread t = new Thread(obj, "" + i);
	    Thread.sleep(500);
	    t.start();
	}
    }

    @Override
    public void run() {
	System.out.println("Thread Name: " + Thread.currentThread().getName() + " | Formatter: " + formatter.get().toPattern());
	try {
	    Thread.sleep(500);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

    }

}