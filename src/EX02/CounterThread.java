package EX02;

public class CounterThread implements Runnable {
	int numeroThread;
	GlobalCounter gc;

	public CounterThread(int numeroThread, GlobalCounter gc) {
		this.numeroThread = numeroThread;
		this.gc = gc;
	}

	@Override
	public void run() {
		while (gc.count <= gc.maxValue) {
			gc.incrementaContador();
			int numeroAtual = gc.count;
			System.out.println(numeroAtual + " - Thread " + numeroThread);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}