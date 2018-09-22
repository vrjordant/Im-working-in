package Assignment2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Exercise {

	// Data structures
	private ApparatusType at;
	private Map<WeightPlateSize, Integer> weight;
	private int duration;

	public Exercise(ApparatusType at, Map<WeightPlateSize, Integer> weight, int duration) {
		// TODO: Implement me!
		this.at = at;
		this.weight=weight;
		this.duration=duration;
	}

	/**
	 * Generates a random exercise using the plates in the argument
	 */
	public static Exercise generateRandom() {
		// TODO: Implement me!
		//Generates a random apparatus generator and makes an array out of apparatus
		ApparatusType[] apparati = ApparatusType.values();
		Random appType = new Random();
		//Generates a random number generator for duration
		Random durType = new Random();
		//Generates weights used 
		Random weightType = new Random();
		//Selects random weight plates and apply it to a hashmap
		Map< WeightPlateSize,Integer> plates =  
				new HashMap< WeightPlateSize,Integer>(); 
		do {
		plates.put(WeightPlateSize.values()[0], weightType.nextInt(11));
		plates.put(WeightPlateSize.values()[1], weightType.nextInt(11));
		plates.put(WeightPlateSize.values()[2], weightType.nextInt(11));
		}while(plates.get(WeightPlateSize.SMALL_3KG)+plates.get(WeightPlateSize.MEDIUM_5KG)+plates.get(WeightPlateSize.LARGE_10KG)==0);
		
		return new Exercise(apparati[appType.nextInt(apparati.length)],plates, durType.nextInt(5)+1 );
	}
	 @Override
	    public String toString() { 
	        return String.format(at.toString() + ": " + weight.toString() + " : " + duration); 
	    } 
	// Exercises must be performed in the order of the routine
	// A routine may include the repeating use of an apparatus

	// To perform an exercise
	// 1. the required apparatus must be available and
	// 2. the required weight plates must be available (you can't sub 2 medium weights for 1 large weight)

	// Once a client finishes using an apparatus, she must unload all weights and release them for others to use.
	// They probably have to get out of the apparatus too

	public static void main(String[] args){
		System.out.println(generateRandom());
	}
}
