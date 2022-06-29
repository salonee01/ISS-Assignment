import java.util.Comparator;

public class SongNameComparator implements Comparator<Song> {

	@Override
	public int compare(Song o1, Song o2) {

		return o1.getTrackName().compareTo(o2.getTrackName());
	}
	
}
