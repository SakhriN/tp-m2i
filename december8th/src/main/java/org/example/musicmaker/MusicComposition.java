package org.example.musicmaker;

import java.util.List;

public class MusicComposition {
    private List<MusicInstrument> instruments;

    public MusicComposition(List<MusicInstrument> instruments) {
        this.instruments = instruments;
    }
    sout
    public void playComposition() {
        System.out.println("Musique de composition qui se lance");
        for (MusicInstrument instrument : instruments) {
            instrument.play();
        }
    }
}
