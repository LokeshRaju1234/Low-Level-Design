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

class ShuffledPlaylistIterator implements PlaylistIterator
{

    private ArrayList<String> shuffledSongs;//which stores songs of that particular playlist
    private int index;

    public ShuffledPlaylistIterator(Playlist playlist)
    {
        shuffledSongs = new ArrayList<>(playlist.getsongs());

        Collections.shuffle(shuffledSongs);

        index = 0;
    }

    //checking out of bounds if there is next song or not
    public boolean hasnext()
    {
        return index < shuffledSongs.size();
    }

    //printing the song
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

        //creating the playlist
        Playlist playlist = new Playlist();
        //adding the songs to the playlist
        playlist.addsong("Believer");
        playlist.addsong("Perfect");
        playlist.addsong("Shape of You");
        playlist.addsong("Closer");

        System.out.println("Simple Order:");

        //and i need a simple playlist
        PlaylistIterator simple =
                playlist.iterator("simple");

        //checking it has a next song or not -->checking bounds actually
        while(simple.hasnext()) {

            System.out.println(simple.next());//printing the song
        }


        System.out.println("\nShuffled Order:");

        //if you need a shuffled playlist
        PlaylistIterator shuffle =
                playlist.iterator("shuffled");

        //and printing the songs after shuffling the playlist
        while(shuffle.hasnext()) {

            System.out.println(shuffle.next());
        }
    }
}
