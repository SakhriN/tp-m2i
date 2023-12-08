package org.example.musicmaker;

import java.util.ArrayList;
import java.util.List;

public class MusicCompositionBuilder {
    private List<MusicInstrument> instruments;

    public MusicCompositionBuilder() {
        this.instruments = new ArrayList<>();
    }

    public MusicCompositionBuilder addInstrument(MusicInstrument instrument) {
        this.instruments.add(instrument);
        return this;
    }

    public MusicComposition build() {
        return new MusicComposition(instruments);
    }

}
