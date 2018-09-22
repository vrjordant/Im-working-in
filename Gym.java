package Assignment2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Gym implements Runnable{
	private Map<ApparatusType,Semaphore> apparati;
	private Map<WeightPlateSize,Semaphore> weights;
	private Semaphore weightMutex;
	public Gym() {
		apparati = new HashMap<ApparatusType, Semaphore>();
		for(ApparatusType apparatus: ApparatusType.values()) {
			apparati.put(apparatus, new Semaphore(5));
		}
		weights = new HashMap< WeightPlateSize, Semaphore>();
		weights.put(WeightPlateSize.values()[0], new Semaphore(110));
		weights.put(WeightPlateSize.values()[1], new Semaphore(90));
		weights.put(WeightPlateSize.values()[2], new Semaphore(75));
		weightMutex = new Semaphore(1);
	}
	
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
	
	/**
	 * In charge of the simulation itself
	 * Threads for clients should be spawned using a thread pool
	 */
	public void run() {
		// TODO: Implement me!
		executor = Executors.newFixedThreadPool(GYM_SIZE); 
		executor.execute(new Runnable () {
			public void run() {
				Client newGuy = Client.generateRandom(id)
				System.out.println("I am an asynchronous task!");
			}
		});
		executor.shutdown();
	}

}
