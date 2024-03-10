package EX03;

public class Semaforo {
	int semaforoAtual = 1;
	boolean flag = true;

	synchronized void semaforo(int numeroSemaforo) {
		if (!flag)
			return;

		while (semaforoAtual != numeroSemaforo) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Semaforo " + numeroSemaforo + " aberto - Thread " + Thread.currentThread().getName());
		flag = false;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Semaforo " + numeroSemaforo + " fechado.");

		// Passa para o próximo semáforo
		if (semaforoAtual == 4) {
			semaforoAtual = 1;
		} else {
			semaforoAtual += 1;
		}
		flag = true;
		notifyAll();

	}
}