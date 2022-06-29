
public class Song {

	String trackName;
	double duration;
		
	Song(String trackName, double duration){
		System.out.println("Initializing object");
		this.trackName = trackName;
		this.duration = duration;
	}
	
	protected String getTrackName() {
		return trackName;
	}

	protected double getDuration() {
		return duration;
	}
	
	// Method to print song details
	void printDetails() {
		System.out.println("The track \"" + trackName + "\" is " + duration +" minutes"
				+ " long.");
	}
	
	public static void main(String[] args) {
		// Create an instance of Song class
		Song songInstance = new Song("DNA", 3.42);
		System.out.println("Created an instance");
		
		//Call method
		System.out.println("Calling method");
		songInstance.printDetails();

	}

}
