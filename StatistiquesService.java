import java.util.ArrayList;

public class StatistiquesService {

    // Compte combien de fois un artiste apparaît dans ton historique
    public int compterEcoutesArtiste(ArrayList<Ecoute> listeEcoutes, String nomArtisteRecherche) {
        int compteur = 0;

        for (Ecoute ecoute : listeEcoutes) {
            // On récupère le nom de l'artiste de l'écoute actuelle
            String nomArtiste = ecoute.getUneMusique().getUnArtiste().getNom();
            
            // Si ça correspond (sans faire attention aux majuscules/minuscules)
            if (nomArtiste.equalsIgnoreCase(nomArtisteRecherche)) {
                compteur++;
            }
        }

        return compteur;
    }

    public ArrayList<Ecoute> AfficherTop(int limite, ArrayList<Ecoute> listeEcoutes) {
        ArrayList<String> artistesUniques = new ArrayList<>();

        for (Ecoute ecoute : listeEcoutes) {
            String nomArtiste = ecoute.getUneMusique().getUnArtiste().getNom();
            if (!artistesUniques.contains(nomArtiste)) {
                artistesUniques.add(nomArtiste);
            }
        }

        return artistesUniques;
    }
}