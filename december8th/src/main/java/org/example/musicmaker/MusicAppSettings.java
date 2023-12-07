package org.example.musicmaker;

public class MusicAppSettings {
    private static MusicAppSettings instance;
    private int volume;

    private MusicAppSettings() {
        this.volume = 50;
    }

    public static MusicAppSettings getInstance() {
        if (instance == null) {
            instance = new MusicAppSettings();
        }
        return instance;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Volume set to: " + volume);
    }
}
