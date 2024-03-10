package EX01;

import java.util.Random;

public class Corredor implements Runnable{
	int distanciaPercorrida = 0;
	  String nome;
	  Classificacao c;

	  public Corredor(String nome, Classificacao c) {
	    this.nome = nome;
	    this.c = c;
	    System.out.println("Nome");
	    System.out.println(nome);
	    new Thread(this).start();
	  }

	  @Override
	  public void run() {
	    Random rand = new Random();

	    while (distanciaPercorrida < 10) {
	      try {
	        Thread.sleep(200 + rand.nextInt(50));
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	      distanciaPercorrida += 1;

	      c.chegada(nome);
	    }

	  }
}
