import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImdbContentExtractor implements ContentExtractor {
    public List<Content> contentExtractor(String json) {
        // extrair só os dados que são necessários (título, poster/imagem e classificação)
        var parser = new JsonParser();
        List<Map<String, String>> attributesList = parser.parse(json);

        List<Content> contents = new ArrayList<>();

        // popular lista de conteudos
        for (Map<String, String> attributes : attributesList) {
            String title = attributes.get("title");
            String urlImage = attributes.get("image");

            var content = new Content(title, urlImage);
            
            contents.add(content);
        }

        return contents;
    }
}
