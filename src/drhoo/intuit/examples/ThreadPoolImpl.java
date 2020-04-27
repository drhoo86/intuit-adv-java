package drhoo.intuit.examples;

import java.util.ArrayList;
import java.util.List;

public class ThreadPoolImpl implements ThreadPool {
	
	private List<Thread> pool;
	private static int currentId = 0;
	private final static int DEFAULT_POOL_SIZE = 5;
	
	public ThreadPoolImpl() {
		this(DEFAULT_POOL_SIZE);
	}

	public ThreadPoolImpl(int size) {
		if (size < DEFAULT_POOL_SIZE) {
			size = DEFAULT_POOL_SIZE;
		}
		pool = new ArrayList<Thread>();
		for (int i=0; i<size; i++) {
			pool.add(null);		//All idle threads are nulls
		}
	}

	@Override
	public Thread getThread() {
		if (pool == null || pool.isEmpty()) {
			return null;
		}
		Thread result = null;
		for (int i=0; i<pool.size(); i++) {
			if (pool.get(i) == null) {
				pool.set(i, new TestThread(currentId++));
				if (result == null) {
					result = pool.get(i);
					break;
				}
			} else {
				if (!pool.get(i).isAlive()) {
					pool.set(i, null);
					i--;
					continue;
				}
			}
		}
		return result;
	}

}
