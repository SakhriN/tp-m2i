package org.example.musicmaker;

import java.util.List;

public class MusicComposition {
    private List<MusicInstrument> instruments;

    public MusicComposition(List<MusicInstrument> instruments) {
        this.instruments = instruments;
    }

    public void playComposition() {
        System.out.println("Playing music composition");
        for (MusicInstrument instrument : instruments) {
            instrument.play();
        }
    }
}
