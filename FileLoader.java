import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileLoader {

    public ArrayList<Ecoute> chargerDepuisCSV(String cheminFichier) {
        ArrayList<Ecoute> liste = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            
            while ((ligne = br.readLine()) != null) {
                String[] segments = ligne.split(",");
                
                if (segments.length < 3) continue; 

                String nomArtiste = segments[0];
                String titreMusique = segments[2]; 

                Artiste unArtiste = new Artiste(nomArtiste);
                Musique uneMusique = new Musique(titreMusique, unArtiste);
                Ecoute uneEcoute = new Ecoute(uneMusique);

                liste.add(uneEcoute);
            }

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        return liste;
    }
}