package application;

import java.util.Arrays;

public class Controller {
	private ArrayStack arrayStack;
	private double lastSaved;
	private boolean pressedOperation;

	public Controller() {
		this.arrayStack = new ArrayStack();
		this.lastSaved = 0;

	}

	/**
	 * Lägger in tal i stacken
	 * 
	 * @param input
	 *            talet som ska läggas in i stacken
	 */
	public void push(double input) {
		double a = lastSaved;
		if (pressedOperation) {
			enter();
			lastSaved = input;
			arrayStack.push(lastSaved);
			pressedOperation = false;
		} else {
			lastSaved = input + (a * 10);
			arrayStack.push(lastSaved);
		}

	}

	/**
	 * Flyttar alla tal upp ett steg och dublicerar den sist inskickade talet.
	 */
	public void enter() {
		arrayStack.moveUp();
		lastSaved = 0;
	}
	
	/**
	 * Tar bort sista elementet.
	 */

	public void clearLast() {
		lastSaved = 0;
		arrayStack.clearLast();
		pressedOperation = false;

	}

	/**
	 * Aderar de två sist inskickade talen och sparar den på sista platsen.
	 */
	public void plus() {
		double plats4 = arrayStack.pop();
		double plats3 = arrayStack.pop();
		enter();
		push((plats4 + plats3));
		pressedOperation = true;

	}

	/**
	 * Subtraherar den sista talet från det nänstsist inskickade talet och
	 * sparar den i sista platsen
	 */
	public void minus() {
		double plats4 = arrayStack.pop();
		double plats3 = arrayStack.pop();
		enter();
		push(plats3 - plats4);
		pressedOperation = true;

	}

	/**
	 * Multiplicerar de två sist inskickade talen sparar den på sista platsen.
	 */
	public void multi() {
		double plats4 = arrayStack.pop();
		double plats3 = arrayStack.pop();
		enter();
		push(plats3 * plats4);
		pressedOperation = true;
	}

	/**
	 * Dividerar den nästsista talet från det sist inskickade talet och sparar
	 * den i sista platsen
	 */
	public void div() {
		double plats4 = arrayStack.pop();
		double plats3 = arrayStack.pop();
		enter();
		push(plats3 / plats4);
		pressedOperation = true;
	}

	/**
	 * Byter täcken på det sist sparade talet.
	 */
	public void CHS() {
		arrayStack.push((-1) * arrayStack.peek());

	}

	/**
	 * Nollställer hela stacken
	 */
	public void clearStack() {
		arrayStack.clearAll();
		lastSaved = 0;

	}
	
	/**
	 * Retunerar talet som finns på platsen plats i arrayStack.
	 * @param plats beskriver platsen i arrayStack.
	 * @return talet som finns på platsen plats.
	 */


	public double getFrom(int plats) {
		double[] temp = arrayStack.get();
		double inPosition = temp[plats];
		return inPosition;
	}

}
