package EX02;

public class GlobalCounter {
	int count;
	int maxValue;

	public GlobalCounter(int maxValue) {
		this.maxValue = maxValue;
		this.count = 0;
	}

	public void incrementaContador() {
		this.count += 1;
	}
}
