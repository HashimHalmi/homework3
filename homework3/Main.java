// Old VinylPlayer with incompatible interface
class VinylPlayer {
    public void playVinyl() {
        System.out.println("Playing music from a vinyl record");
    }
}

// Modern MP3Player with a different interface
class MP3Player {
    public void playMP3() {
        System.out.println("Playing music from an MP3 file");
    }
}

// Adapter class to make the VinylPlayer compatible with MP3Player
class VinylPlayerAdapter extends MP3Player {
    private VinylPlayer vinylPlayer;

    public VinylPlayerAdapter(VinylPlayer vinylPlayer) {
        this.vinylPlayer = vinylPlayer;
    }

    @Override
    public void playMP3() {
        // Use the VinylPlayer's method to play music
        vinylPlayer.playVinyl();
    }
}

public class Main {
    public static void playMusic(MP3Player player) {
        player.playMP3();
    }

    public static void main(String[] args) {
        VinylPlayer vinylPlayer = new VinylPlayer();
        MP3Player mp3Player = new MP3Player();
        VinylPlayerAdapter vinylAdapter = new VinylPlayerAdapter(vinylPlayer);

        System.out.println("Using MP3Player:");
        playMusic(mp3Player);

        System.out.println("\nUsing VinylPlayerAdapter:");
        playMusic(vinylAdapter);
    }
}
