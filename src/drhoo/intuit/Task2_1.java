package drhoo.intuit;

public class Task2_1 {

	public static void main(String[] args) throws Exception {
		int size = 10;
		ThreadPool tPool = new ThreadPoolImpl(size);
		Thread t;
		for (int i=0; i<size; i++) {
			t = tPool.getThread();
			if (t != null) {
				t.start();
			}
		}
	}

}
