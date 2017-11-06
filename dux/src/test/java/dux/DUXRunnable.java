package dux;

public abstract class DUXRunnable implements Runnable {

	@Override
	public void run() {
		try {
			walk();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	protected abstract void walk() throws Exception;
}
