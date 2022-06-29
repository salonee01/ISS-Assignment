
public class Song {

	String trackName;
	double duration;
	
	Song(){
		trackName = null;
		duration = 0.0;
	}
	
	Song(String trackName, double duration){
		this.trackName = trackName;
		this.duration = duration;
	}
	
	protected String getTrackName() {
		return trackName;
	}

	protected double getDuration() {
		return duration;
	}

	void printDetails() {
		System.out.println("The track \"" + trackName + "\" is " + duration +" minutes"
				+ " long.");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Song songInstance = new Song();
		songInstance.printDetails();

	}

}
