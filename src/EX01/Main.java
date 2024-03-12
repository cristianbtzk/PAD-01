package EX01;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("Quantidade corredores: ");
		int qtdCorredores = s.nextInt();

		String[] nomes = new String[qtdCorredores];

		Classificacao c = new Classificacao(qtdCorredores);

		for (int i = 0; i < qtdCorredores; i++) {
			System.out.println("Nome: ");

			nomes[i] = s.next();
		}

		for (int i = 0; i < nomes.length; i++) {
			new Corredor(nomes[i], c);
		}
		s.close();
	}
}
