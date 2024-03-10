package EX07;

public class Buscador implements Runnable{
	  int numeroBusca;
	  int indexInicial;
	  int indexFinal;
	  int[] arrayBusca;

	  EstadoGlobal e;

	  public Buscador(int numeroBusca, int indexInicial, int indexFinal, int[] arrayBusca, EstadoGlobal e) {
	    this.numeroBusca = numeroBusca;
	    this.indexInicial = indexInicial;
	    this.indexFinal = indexFinal;
	    this.arrayBusca = arrayBusca;
	    this.e = e;
	  }


	  @Override
	  public void run() {
	    for (int i = indexInicial; i <= indexFinal; i++) {
	      if (!e.continuaBusca)
	        return;

	      if(arrayBusca[i] == numeroBusca) {
	        e.index = i;
	        e.continuaBusca = false;
	        e.nomeThread = Thread.currentThread().getName();
	        return;
	      }
	    }
	  }
	}
