import java.util.Random;

public class MusicPlayerControl {
	boolean shuffle = true, start = true;
	int currentTrack;
	
	//Print current track details
	void playTrack(String trackName) {
		System.out.println("Currently playing: " + trackName);
	}
	
	//Play next track
	void playNextTrack(int nextTrack) {
		//Select next track using switch case
		switch(nextTrack) {
		case 1:
			playTrack("Home");
			break;
		case 2:
			playTrack("Friends");
			break;
		case 3:
			playTrack("Magic");
			break;
		case 4:
			playTrack("Moon");
			break;
		default:
			playTrack("Wings");
			
		}
	
	}
	
	//Play tracks
	void startPlaying() {
		while(start) {
			
			//Play tracks on shuffle
			if (shuffle) {
				int i=0;
				System.out.println("Playing on shuffle...");
				do {
					int randomNumber;
					//Choose a random track to play
					Random random = new Random();
					randomNumber = random.nextInt(6);
					currentTrack = randomNumber;
					playNextTrack(currentTrack);
					i++;
				}
				while(i<7);	
				shuffle = false;
			}
			//Play tracks in order
			else {
				System.out.println("Playing in order...");
				for (int i = 1; i<6; i++) {
					//Skip third track
					if (i==3)
						continue;
					playNextTrack(i);
				}
				start = false;
			}
			
		}
	}
	
	public static void main(String args[]) {
		MusicPlayerControl instance = new MusicPlayerControl();
		instance.startPlaying();
	}
	
}

