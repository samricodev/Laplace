package laplaciano;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class LaplaceExecutor implements Runnable {

    private BufferedImage image;
    private BufferedImage filteredImage;
    private int[][] laplacianKernel;
    private int xStart;
    private int xEnd;
    private int yStart;
    private int yEnd;
    private int [][] kernel = {{-1, -1, -1}, {-1, 8, -1}, {-1, -1, -1}};

    public LaplaceExecutor(BufferedImage image, BufferedImage filteredImage, int xStart, int xEnd, int yStart, int yEnd) {
        this.image = image;
        this.filteredImage = filteredImage;
        this.laplacianKernel = kernel;
        this.xStart = xStart;
        this.xEnd = xEnd;
        this.yStart = yStart;
        this.yEnd = yEnd;
    }

    @Override
    public void run() {
        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                int sum = 0;
                for (int dy = -1; dy <= 1; dy++) {
                    for (int dx = -1; dx <= 1; dx++) {
                        Color color = new Color(image.getRGB(x + dx, y + dy));
                        int intensity = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                        sum += intensity * laplacianKernel[dy + 1][dx + 1];
                    }
                }
                int filteredIntensity = Math.max(0, Math.min(255, sum));
                Color filteredColor = new Color(filteredIntensity, filteredIntensity, filteredIntensity);
                filteredImage.setRGB(x, y, filteredColor.getRGB());
            }
        }
    }
}

