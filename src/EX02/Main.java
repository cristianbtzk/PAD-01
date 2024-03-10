package EX02;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Número para contagem: ");
		int numero = s.nextInt();

		if (numero < 5000) {
			System.out.println("Número inválido!!!");
			System.exit(1);
		}

		System.out.println("Número de threads: ");
		int threads = s.nextInt();
		s.close();
		GlobalCounter gc = new GlobalCounter(numero);

		for (int i = 0; i < threads; i++) {
			Thread ct = new Thread(new CounterThread(i + 1, gc));
			ct.start();
		}
	}
}