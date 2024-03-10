package EX07;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
	    // Cria um array com números de 0 a 100
	    int[] array = IntStream.range(1, 100 + 1).toArray();

	    int numThreads = 5;

	    // Número para buscar
	    System.out.println("Informe o número para buscar: ");
	    Scanner s = new Scanner(System.in);
	    int numeroBusca = s.nextInt();
	    s.close();

	    EstadoGlobal e = new EstadoGlobal();

	    Thread[] threads = new Thread[numThreads];

	    int indexInicial = 0;
	    int numerosPorThread = array.length / numThreads;
	    for (int i = 0; i < numThreads; i++) {
	      int indexFinal = indexInicial + numerosPorThread - 1;
	      if (indexFinal > array.length - 1) {
	        indexFinal = array.length - 1;
	      }

	      threads[i] = new Thread(new Buscador(numeroBusca, indexInicial, indexFinal, array, e), Integer.toString(i + 1));
	      indexInicial = indexFinal + 1;

	      threads[i].start();
	    }
	    try {
	      for (Thread thread : threads) {
	        thread.join();
	      }
	      System.out.println("Resultado - " + e.index);
	      if(e.index >= 0) {
	        System.out.println("Thread que achou: " + e.nomeThread);
	      }
	    } catch (InterruptedException e1) {
	      e1.printStackTrace();
	    }
	  }
}
