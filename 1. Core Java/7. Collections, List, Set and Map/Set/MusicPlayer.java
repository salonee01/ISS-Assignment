import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;



public class MusicPlayer {

	public static void main(String[] args) {
		LinkedHashSet<Song> playlist = new LinkedHashSet<>();
		Song song1 = new Song("As it Was", 4.32);
		Song song2 = new Song("Home", 3.23);
		Song song3 = new Song("Clouds", 4.41);
		Song song4 = new Song("Magic Shop", 3.57);
		Song song5 = new Song("Friends", 5.54);
		
		//Add elements
		playlist.add(song1);
		playlist.add(song2);
		playlist.add(song3);
		playlist.add(song4);
		playlist.add(song5);
		
		// Size of linked hash set
		System.out.println("Number of songs in the playlist: " + playlist.size());
		
		Iterator<Song> iterator = playlist.iterator();
		System.out.print("PLaylist order: ");
		while (iterator.hasNext()) {
		   Song song = iterator.next();
		   System.out.print(song.trackName + ", ");
		  }
		
		playlist.remove(song1);
		Iterator<Song> iterator1 = playlist.iterator();
		System.out.print("\nPLaylist order after removing the first song: ");
		while (iterator1.hasNext()) {
		   Song song = iterator1.next();
		   System.out.print(song.getTrackName() + ", ");
		  }
		
		TreeSet<Song> playlistTree = new TreeSet<>(new DurationComparator());
		playlistTree.addAll(playlist);
		
		Iterator<Song> iterator2 = playlistTree.iterator();
		System.out.print("\nSorting on the basis of duration: ");
		while (iterator2.hasNext()) {
		   Song song = iterator2.next();
		   System.out.print(song.getTrackName() + ": " + song.getDuration() + ", ");
		  }
		
		TreeSet<Song> playlistName = new TreeSet<>(new SongNameComparator());
		playlistName.addAll(playlist);
		
		Iterator<Song> iterator3 = playlistName.iterator();
		System.out.print("\nSorting on the basis of song name: ");
		while (iterator3.hasNext()) {
		   Song song = iterator3.next();
		   System.out.print(song.getTrackName() + ", ");
		  }
		
		
		

	}

}
