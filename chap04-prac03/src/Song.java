
public class Song {
	private String title;
	private String artist;
	private int year;
	private String country;
	
	public Song() { }
	public Song(String title, String artist, int year, String country) {
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.country = country;
	}

	public void show() {
		System.out.print(year + "³â ");
		System.out.print(country + "±¹ÀûÀÇ ");
		System.out.print(artist + "°¡ ºÎ¸¥ ");
		System.out.println(title);
	}
	public static void main(String[] args) {
		Song myFavorite = new Song("Dancing Queen", "ABBA", 1978, "½º¿þµ§");
		myFavorite.show();
	}

}