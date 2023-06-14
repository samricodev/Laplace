
package laplaciano;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Laplace {

    public Laplace() {}
    
    //Laplace filter matrix
    int[][] laplacianKernel = {{1, 1, 1},{1, -8, 1},{1, 1, 1}};
        
    //Convert image to matrix
    public void imageConvert(String url) throws IOException{
        //Charge image
        BufferedImage image = ImageIO.read(new File(url));
        BufferedImage filteredImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        
        for (int y = 1; y < image.getHeight() - 1; y++) {
            for (int x = 1; x < image.getWidth() - 1; x++) {
                // Multiplicar cada píxel vecino y el píxel actual por el valor correspondiente en la matriz del filtro Laplaciano
                int sum = 0;
                for (int dy = -1; dy <= 1; dy++) {
                    for (int dx = -1; dx <= 1; dx++) {
                        Color color = new Color(image.getRGB(x + dx, y + dy));
                        int intensity = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                        sum += intensity * laplacianKernel[dy + 1][dx + 1];
                    }
                }

                // Establecer el valor del píxel actual en el resultado de la suma
                int filteredIntensity = Math.max(0, Math.min(255, sum));
                Color filteredColor = new Color(filteredIntensity, filteredIntensity, filteredIntensity);
                filteredImage.setRGB(x, y, filteredColor.getRGB());
            }
        }
        
        File archivoSalida = new File("src/dualimages/newImage.jpg");
        ImageIO.write(filteredImage, "jpg", archivoSalida);
    }
}
