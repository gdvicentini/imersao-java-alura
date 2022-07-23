import java.io.InputStream;
//import java.net.URI;
import java.net.URL;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
//import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer conexão HTTP na API do ImDB e buscar os TOP 250 filmes
        // String url = "https://imdb-api.com/en/API/Top250Movies/k_4y9n820p";
        // String url = "https://api.mocki.io/v2/549a5d8b";
        // ContentExtractor extractor = new ImdbContentExtractor();

        // fazer conexão HTTP na API da NASA e buscar imagens dos planetários
        // String url = "https://api.nasa.gov/planetary/apod?api_key=2Q6k0VDQOU7mjX4kwmk5kHxnLbKXSiZVwBDdUnXt"
        // ContentExtractor extractor = new NasaContentExtractor();

        // fazer conexão HTTP na API própria criada durante o curso
        String url = "http://localhost:8080/languages";
        ContentExtractor extractor = new LanguageApiContentExtractor();

        var http = new HttpClientConnection();
        String json = http.searchData(url);

        // exibir e manipular dados
        
        List<Content> contents = extractor.contentExtractor(json);

        var generator = new StickerGenerator();

        for (int i = 0; i < 3; i++) {

            Content content = contents.get(i);
            
            InputStream inputStream = new URL(content.getUrlImage()).openStream();
            String archiveName = "/output" + content.getTitle() + ".png";

            generator.create(inputStream, archiveName);

            System.out.println(content.getTitle());
            System.out.println();
        }
    }
}
