package application;

public class ArrayStack {
	private double[] array;

	public ArrayStack() {
		this.array = new double[4];

	}

	/**
	 * Retunerar array av typen int med alla befintiliga tal i den.
	 * 
	 * @return array med alla tal.
	 */
	public double[] get() {
		return array;
	}

	/**
	 * Lägger in talet x i sista platsen.
	 * 
	 * @param input
	 *            talet som skickas in i sista platsen
	 */
	public void push(double input) {
		array[3] = input;

	}

	/**
	 * Retunerar den sist inskickade talet i stacken utan att ta bort den.
	 * 
	 * @return sist inskickade talet
	 */
	public double peek() {
		return array[3];
	}

	/**
	 * Retunerar den sist inskickade talet och tar bort den.
	 * 
	 * @return Retunerar den sist inskickade talet
	 */
	public double pop() {
		double last = array[3];
		for (int i = array.length - 1; i >= 1; i--) {
			array[i] = array[i - 1];
		}
		array[0] = array[1];
		return last;
	}

	/**
	 * Flyttar alla talen ett steg uppåt i array och dublicerar den sist inlagda.
	 */

	public void moveUp() {
		for (int i = 0; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
	}

	/**
	 * Nollställer hela arrayn.
	 */
	public void clearAll() {
		for (int i = 0; i <= 3; i++) {
			array[i] = 0;
		}
	}
	
	public void clearLast(){
		array[3]= 0;
	}

}
