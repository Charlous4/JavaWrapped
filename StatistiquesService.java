import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatistiquesService {

    public void afficherTopArtistes(ArrayList<Ecoute> listeEcoutes, int limite) {
        HashMap<String, Integer> compteurArtistes = new HashMap<>();

        for (Ecoute ecoute : listeEcoutes) {
            String nomArtiste = ecoute.getUneMusique().getUnArtiste().getNom();
            compteurArtistes.put(nomArtiste, compteurArtistes.getOrDefault(nomArtiste, 0) + 1);
        }

        System.out.println("🏆 --- MON TOP " + limite + " ARTISTES ---");
        
        compteurArtistes.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(limite)
                .forEach(entree -> System.out.println("• " + entree.getKey() + " : " + entree.getValue() + " écoutes"));
        
        System.out.println("-------------------------------------\n");
    }

    public void afficherTopMusiques(ArrayList<Ecoute> listeEcoutes, int limite) {
        HashMap<String, Integer> compteurMusiques = new HashMap<>();

        for (Ecoute ecoute : listeEcoutes) {
            String cleMusique = ecoute.getUneMusique().getTitre() + " (de " + ecoute.getUneMusique().getUnArtiste().getNom() + ")";
            compteurMusiques.put(cleMusique, compteurMusiques.getOrDefault(cleMusique, 0) + 1);
        }

        System.out.println("🔥 --- MON TOP " + limite + " MUSIQUES ---");

        compteurMusiques.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(limite)
                .forEach(entree -> System.out.println("• " + entree.getKey() + " : " + entree.getValue() + " fois"));
        
        System.out.println("-------------------------------------\n");
    }

    public String genererTexteWrapped(ArrayList<Ecoute> listeEcoutes, int limite) {
        StringBuilder sb = new StringBuilder();
        sb.append("=========================================\n");
        sb.append("         🎵 MON SPOTIFY WRAPPED 🎵       \n");
        sb.append("=========================================\n\n");

        HashMap<String, Integer> compteurArtistes = new HashMap<>();
        for (Ecoute ecoute : listeEcoutes) {
            String nomArtiste = ecoute.getUneMusique().getUnArtiste().getNom();
            compteurArtistes.put(nomArtiste, compteurArtistes.getOrDefault(nomArtiste, 0) + 1);
        }

        sb.append("🏆 --- TOP ").append(limite).append(" ARTISTES ---\n");
        compteurArtistes.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(limite)
                .forEach(e -> sb.append("• ").append(e.getKey()).append(" : ").append(e.getValue()).append(" écoutes\n"));
        
        sb.append("\n-----------------------------------------\n\n");

        HashMap<String, Integer> compteurMusiques = new HashMap<>();
        for (Ecoute ecoute : listeEcoutes) {
            String cleMusique = ecoute.getUneMusique().getTitre() + " (de " + ecoute.getUneMusique().getUnArtiste().getNom() + ")";
            compteurMusiques.put(cleMusique, compteurMusiques.getOrDefault(cleMusique, 0) + 1);
        }

        sb.append("🔥 --- TOP ").append(limite).append(" MUSIQUES ---\n");
        compteurMusiques.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(limite)
                .forEach(e -> sb.append("• ").append(e.getKey()).append(" : ").append(e.getValue()).append(" fois\n"));

        return sb.toString();
    }
}