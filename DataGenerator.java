import java.util.ArrayList;

public class DataGenerator {

    public ArrayList<Ecoute> genererDonneesDeTest() {
        ArrayList<Ecoute> listeEcoutes = new ArrayList<>();
            
        Artiste yv = new Artiste("Yvnnis");
        Musique m1 = new Musique("Bara", yv);
        Ecoute e1 = new Ecoute(m1);

        listeEcoutes.add(e1);
            
        return listeEcoutes;
    }
}