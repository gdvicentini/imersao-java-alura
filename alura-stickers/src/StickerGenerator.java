import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
// import java.io.FileInputStream;
import java.io.InputStream;
// import java.net.URL;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;

public class StickerGenerator {
    
    public void create(InputStream inputStream, String archiveName) throws Exception {
        
        // leitura da imagem

        // InputStream inputStream = new FileInputStream(new File("img/film-large.jpg"));
        // InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@.jpg9.2").openStream();
        BufferedImage originalImage = ImageIO.read(inputStream);

        // cria nova imagem em memória com transparência e com tamanho novo
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 200;

        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        // configurar a fonte
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(font);

        // escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 100, newHeight - 100);


        // escrever a nova imagem em um arquivo
        ImageIO.write(newImage, "png", new File(archiveName));

    }
}
