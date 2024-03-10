package EX03;

public class Main {
	public static void main(String[] args) {
		Semaforo s = new Semaforo();

		for (int i = 1; i < 5; i++) {
			Thread t = new Thread(new ThreadSemaforo(s, i), Integer.toString(i));
			t.start();
		}
	}
}
