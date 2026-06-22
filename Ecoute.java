public class Ecoute {
    private Musique uneMusique;

    public Ecoute(Musique uneMusique) {
        this.uneMusique = uneMusique;
    }

    public Musique getUneMusique() {
        return uneMusique;
    }

    @Override
    public String toString() {
        return "Vous avez écouté " + this.uneMusique.getTitre() + " de " + this.uneMusique.getUnArtiste().getNom();
    }
}