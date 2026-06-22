import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiClient {

    private final String apiKey = "PUT_YOUR_API_KEY_HERE"; // Remplacez par votre clé API Last.fm

    public String recupererScrobblesEnDirect(String pseudoLastFm) {
        String url = "http://ws.audioscrobbler.com/2.0/?method=user.getrecenttracks&user=" 
                     + pseudoLastFm + "&api_key=" + apiKey + "&format=json&limit=50";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Ecoute> convertirJsonEnEcoutes(String json) {
        ArrayList<Ecoute> liste = new ArrayList<>();
        
        if (json == null || json.isEmpty()) return liste;

        Pattern pattern = Pattern.compile("\"artist\":\\{[^\\}]*\"#text\":\"([^\"]+)\".*?\"name\":\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(json);

        while (matcher.find()) {
            String nomArtiste = matcher.group(1);
            String titreMusique = matcher.group(2);

            Artiste artiste = new Artiste(nomArtiste);
            Musique musique = new Musique(titreMusique, artiste);
            Ecoute ecoute = new Ecoute(musique);

            liste.add(ecoute);
        }

        return liste;
    }
}