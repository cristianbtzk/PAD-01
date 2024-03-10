package EX03;

public class ThreadSemaforo implements Runnable {
	int numeroSemaforo;
	Semaforo s;

	public ThreadSemaforo(Semaforo s, int numeroSemaforo) {
		this.s = s;
		this.numeroSemaforo = numeroSemaforo;
	}

	@Override
	public void run() {
		while (true) {
			s.semaforo(numeroSemaforo);
		}
	}
}