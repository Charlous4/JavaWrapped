import java.util.ArrayList;

public class DataGenerator {

    public ArrayList<Ecoute> genererDonneesDeTest() {
        ArrayList<Ecoute> listeEcoutes = new ArrayList<>();
            
        Artiste yv = new Artiste("Yvnnis");
        // On a enlevé le 187
        Musique m1 = new Musique("Bara", yv);
        // On a enlevé le 120000
        Ecoute e1 = new Ecoute(m1);

        listeEcoutes.add(e1);
            
        return listeEcoutes;
    }
}