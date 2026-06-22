import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileLoader {

    // Cette méthode prend le nom de ton fichier en paramètre et renvoie la liste d'écoutes
    public ArrayList<Ecoute> chargerDepuisCSV(String cheminFichier) {
        ArrayList<Ecoute> liste = new ArrayList<>();

        // Le "try-with-resources" ouvre le fichier proprement
        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            
            // On lit le fichier ligne par ligne jusqu'à la fin
            while ((ligne = br.readLine()) != null) {
            // On découpe la ligne du CSV Last.fm
            String[] segments = ligne.split(",");
            
            // Sécurité au cas où une ligne serait mal formée
            if (segments.length < 3) continue; 

            String nomArtiste = segments[0];
            // segments[1] c'est l'Album, on s'en fiche pour l'instant
            String titreMusique = segments[2]; 
            // segments[3] c'est la Date, on la stockera plus tard si besoin

            // On assemble nos objets sans les durées/ms
            Artiste unArtiste = new Artiste(nomArtiste);
            Musique uneMusique = new Musique(titreMusique, unArtiste);
            Ecoute uneEcoute = new Ecoute(uneMusique);

            liste.add(uneEcoute);
        }

        } catch (IOException e) {
            // Si le fichier n'existe pas ou est illisible, on gère l'erreur sans faire crasher l'appli
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        // On renvoie la liste (remplie ou vide si erreur)
        return liste;
    }
}