package org.example.musicmaker;

public class Main {
    public static void main(String[] args) {
        MusicAppSettings appSettings = MusicAppSettings.getInstance();
        appSettings.setVolume(75);

        MusicInstrumentProxy instrumentProxy = new MusicInstrumentProxy();
        instrumentProxy.play();

        MusicComposition composition = new MusicCompositionBuilder()
                .addInstrument(new RealMusicInstrument())
                .addInstrument(instrumentProxy)
                .build();

        composition.playComposition();
        sout
    }
}
