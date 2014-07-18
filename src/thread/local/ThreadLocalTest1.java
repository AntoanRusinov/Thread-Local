package thread.local;

import java.util.NoSuchElementException;

public class ThreadLocalTest1 {

    public static void main(String[] args) {

	RuntimeException re = new RuntimeException();
	NoSuchElementException noEx = new NoSuchElementException("bad file");
	NullPointerException nullEx = new NullPointerException("You are dummy");
	Error error = new Error("This is ERROR");

	ThreadLocal<String> tl2 = new ThreadLocal<String>();
	tl2.set("ayyy");
	System.out.println(tl2.get());

	ThreadLocal<Exception> tl3 = new ThreadLocal<Exception>();
	tl3.set(re);
	System.out.println(tl3.get());

	ThreadLocal<Exception> noSuchElementEx = new ThreadLocal<Exception>();
	noSuchElementEx.set(noEx);
	System.out.println(noSuchElementEx.get());

	ThreadLocal<Exception> nullException = new ThreadLocal<Exception>();
	try {
	    nullException.set(nullEx);
	} catch (Exception e) {
	    System.out.println("Got exception");
	} finally {
	    nullException.remove();
	}
	System.out.println("NullPointerException: " + nullException.get());

	ThreadLocal<Error> proxy = new ThreadLocal<Error>();
	proxy.set(error);
	System.out.println(proxy.get());

    }
}
