import  java.util.*;

//iterator interface
interface  PlaylistIterator
{
    boolean hasnext();
    String next();//for getting the next song
}

class SimplePlaylistIterator implements PlaylistIterator
{
    private Playlist playlist;
    private int index;

    public SimplePlaylistIterator(Playlist playlist) {
        this.playlist = playlist;
        this.index = index;
    }

    @Override
    public boolean hasnext() {
        return index < playlist.getsongs().size();//checking if there is next song or not
    }

    @Override
    public String next()
    {
        return playlist.getsongs().get(index++);//returning the song
    }
}

class ShuffledPlaylistIterator implements PlaylistIterator {

    private ArrayList<String> shuffledSongs;
    private int index;

    public ShuffledPlaylistIterator(Playlist playlist) {

        shuffledSongs = new ArrayList<>(playlist.getsongs());

        Collections.shuffle(shuffledSongs);

        index = 0;
    }

    public boolean hasnext() {

        return index < shuffledSongs.size();
    }

    public String next() {

        return shuffledSongs.get(index++);
    }
}

class Playlist
{
    private  ArrayList<String> songs;

    public Playlist()
    {
       songs = new ArrayList<>();
    }

    public void addsong(String song)
    {
        songs.add(song);
    }

    public ArrayList<String> getsongs()
    {
        return songs;
    }

    public PlaylistIterator iterator(String type)
    {
        switch(type) {

            case "simple":
                return new SimplePlaylistIterator(this);//this refers to the curr class object which holds all the songs

            case "shuffled":
                return new ShuffledPlaylistIterator(this);

            default:
                return null;
        }
    }
}
public class Iterator
{
    public static void main(String[] args) {

        Playlist playlist = new Playlist();

        playlist.addsong("Believer");
        playlist.addsong("Perfect");
        playlist.addsong("Shape of You");
        playlist.addsong("Closer");

        System.out.println("Simple Order:");

        PlaylistIterator simple =
                playlist.iterator("simple");

        while(simple.hasnext()) {

            System.out.println(simple.next());
        }


        System.out.println("\nShuffled Order:");

        PlaylistIterator shuffle =
                playlist.iterator("shuffled");

        while(shuffle.hasnext()) {

            System.out.println(shuffle.next());
        }
    }
}
