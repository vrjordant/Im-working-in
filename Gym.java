package Assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Gym implements Runnable{
	private Map<ApparatusType,Semaphore> apparati;
	private Map<WeightPlateSize,Semaphore> weights;
	private Semaphore weightMutex;
	public Gym() {
		
		// Declares semaphores for apparati
		apparati = new HashMap<ApparatusType, Semaphore>();
		for(ApparatusType apparatus: ApparatusType.values()) {
			apparati.put(apparatus, new Semaphore(5));
		}
		
		// Declares semaphores for weights
		weights = new HashMap< WeightPlateSize, Semaphore>();
		weights.put(WeightPlateSize.values()[0], new Semaphore(110));
		weights.put(WeightPlateSize.values()[1], new Semaphore(90));
		weights.put(WeightPlateSize.values()[2], new Semaphore(75));
		
		// Mutex for weights, so only 1 person can grab weights at a time
		weightMutex = new Semaphore(1);
		
		// Initializes clients
		clients = new HashSet<Integer>();
		// Only one client can be created at a time
		newClientId = new Semaphore(1);
	}
	
	// Defines a bunch of data structures
	private static final int GYM_SIZE = 30;
	private static final int GYM_REGISTERED_CLIENTS = 10000;
	private Map<WeightPlateSize,Integer> noOfWeightPlates;

	// For generating fresh client ids
	private Set<Integer> clients;
	private Semaphore newClientId;
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
		for (int i = 0; i < GYM_REGISTERED_CLIENTS; i++) {
			executor.execute(new Runnable () {
				public void run() {
					
					// Creates hella clients
					try {
						newClientId.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Random clientId = new Random();
					int id;
					do {
						id = clientId.nextInt();
					}
					while(clients.contains(id) || id < 0);
					Client newGuy = Client.generateRandom(id);
					clients.add(id);
					newClientId.release();
					//System.out.println(newGuy);
					
					// Performs exercises
					List<Exercise> routine = newGuy.getRoutine();
					for (int i = 0; i < routine.size(); i++) {
						// Goes to machine
						Exercise exercise = routine.get(i);
						
						try {
							apparati.get(exercise.getAt()).acquire();
							Map<WeightPlateSize, Integer> weightsForExercise = exercise.getWeight();
							// Ready to load weights
							weightMutex.acquire();
							for (WeightPlateSize weight: WeightPlateSize.values()) {
								int noOfPlates = weightsForExercise.get(weight);
								for (int j = 0; j < noOfPlates; j++) {
									// Acquires the weights
									weights.get(weight).acquire();
								}
							}
							// Someone else can grab weights
							weightMutex.release();
							// Do the exercise
							System.out.println("Client number " + newGuy.getId() + " has started using the " + exercise.getAt() + 
									" with the weights " + exercise.getWeight());
							Thread.sleep(exercise.getDuration());
							System.out.println("Client number " + newGuy.getId() + " has finished using the " + exercise.getAt() + 
									" with the weights " + exercise.getWeight());
							// Done with exercise, release the weights!
							for (WeightPlateSize weight: WeightPlateSize.values()) {
								int noOfPlates = weightsForExercise.get(weight);
								for (int j = 0; j < noOfPlates; j++) {
									// Acquires the weights
									weights.get(weight).release();
								}
							}
							// Leave apparatus
							apparati.get(exercise.getAt()).release();
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
			});
		}
	
		executor.shutdown();
	}

}
