package org.example.musicmaker;

public class MusicInstrumentProxy implements MusicInstrument {
    private RealMusicInstrument realInstrument;

    @Override
    public void play() {
        if (realInstrument == null) {
            realInstrument = new RealMusicInstrument();
        }
        realInstrument.play();
        sout
    }
}
