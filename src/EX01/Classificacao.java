package EX01;

public class Classificacao {
	  String[] participantes;
	  int count = 0;

	  public Classificacao(int quantidadeParticipantes) {
	    this.participantes = new String[quantidadeParticipantes];
	  }

	  public synchronized void chegada(String nome) {
	    participantes[count] = nome;

	    if(count == participantes.length - 1) {
	      for (int i = 0; i < participantes.length; i++) {
	        System.out.println((i + 1) + "o lugar: " + participantes[i]);
	      }

	      this.participantes = new String[participantes.length];
	      System.out.println("Fim da volta!");
	      count = 0;
	    } else {
	      count++;
	    }

	  }
}
