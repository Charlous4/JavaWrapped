import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FileLoader loader = new FileLoader();
        ArrayList<Ecoute> mesEcoutes = loader.chargerDepuisCSV("historique.csv");

        System.out.println("Données Last.fm chargées avec succès !");
        System.out.println("Nombre total de scrobbles : " + mesEcoutes.size());
        System.out.println("--------------------------------------------------");

    
        StatistiquesService statsService = new StatistiquesService();

        // On teste notre nouveau compteur sur "yvnnis"
        String cible = "yvnnis";
        int nbEcoutes = statsService.compterEcoutesArtiste(mesEcoutes, cible);

        System.out.println("Nombre d'écoutes pour " + cible + " : " + nbEcoutes);
    }
}