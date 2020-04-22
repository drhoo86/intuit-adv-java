package drhoo.intuit;

import java.util.logging.Logger;

public class TestThread extends Thread {
	private static Logger log = Logger.getLogger("qq");
	private static int currentId = 0;
	private int id;
	private static Object waitObj = new Object();
	
	public TestThread(int id) {
		super();
		this.id = id;
	}

	@Override
	public void run() {

		try {
			synchronized (waitObj) {
				while (id > currentId) {
					waitObj.wait();
				}
				currentId++;
				//log.info(this.getName() + "(id=" + id + ")");
				System.out.println(this.getName() + "(id=" + id + ")");
				waitObj.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
