/**
 * Jordan Tantuico and Jared Hobbie
 * I pledge my honor that I have abided by the Stevens Honor System.
 */
package Assignment2;

/** start the simulation */
public class Assignment2 {
	
	public static void main(String[] args) {
		Thread thread = new Thread(new Gym());
		thread.start();
		try {
			thread.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
