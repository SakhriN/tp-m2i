package org.example.musicmaker;

public class Main {
    public static void main(String[] args) {
        // Utilisation du Singleton pour gérer les paramètres globaux
        MusicAppSettings appSettings = MusicAppSettings.getInstance();
        appSettings.setVolume(75);

        // Utilisation du Proxy pour contrôler l'accès aux instruments
        MusicInstrumentProxy instrumentProxy = new MusicInstrumentProxy();
        instrumentProxy.play();

        // Utilisation du Builder pour construire une composition complexe
        MusicComposition composition = new MusicCompositionBuilder()
                .addInstrument(new RealMusicInstrument())
                .addInstrument(instrumentProxy)
                .build();

        // Jouer la composition
        composition.playComposition();
    }
}
