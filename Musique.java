public class Musique {
    private String titre;
    private Artiste unArtiste;

    public Musique(String titre, Artiste unArtiste) {
        this.titre = titre;
        this.unArtiste = unArtiste;
    }

    public String getTitre() {
        return titre;
    }

    public Artiste getUnArtiste() {
        return unArtiste;
    }
}
