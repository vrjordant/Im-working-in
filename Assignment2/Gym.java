package Assignment2;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class Gym implements Runnable{
	
	// Defines a bunch of data structures
	private static final int GYM_SIZE = 30;
	private static final int GYM_REGISTERED_CLIENTS = 10000;
	private Map<WeightPlateSize,Integer> noOfWeightPlates;
	
	// For generating fresh client ids
	private Set<Integer> clients;
	private ExecutorService executor;
	
	// TODO: Create various semaphores for the apparatus
	// How do you make semaphores in Java?
	
	// List of semaphores:
	// Apparatus: must wait for it to be free
	// Weight plates: must wait for all required weight plates to be available, can only use acquire(), not acquire(int)
	
	// The gym is also a shared resource, but instead of using semaphores, use GYM_SIZE
	// Gym should generate clients randomly
	// Clients should be assigned unique IDs and should have between 15 and 20 exercises
	// Duration should be reasonable
	// Number of plates for each exercise should be between 0 and 10 per weight size
	// Make sure there's at least one plate
	// Simulation should print when a person starts exercising, including apparatus number and the weight plates, and when it finishes
	
	// Does the gym need a constructor?
	
	/**
	 * In charge of the simulation itself
	 * Threads for clients should be spawned using a thread pool
	 */
	public void run() {
		// TODO: Implement me!
	}
	
}
