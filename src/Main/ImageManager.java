/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Color;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Yumis
 */
public class ImageManager {

    static public void saveImage(Cell[][] grid) {
        try {
            BufferedImage image = new BufferedImage(grid.length, grid[0].length, BufferedImage.TYPE_BYTE_BINARY);
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {

                    int a = grid[i][j].active == 1 ? 255 : 0;
                    Color newColor = new Color(a, a, a);

                    image.setRGB(i, j, newColor.getRGB());
                }
            }
            File folder = new File("img");
            int filesNum = folder.listFiles().length;
            File output = new File("img/" + filesNum + ".png");
            ImageIO.write(image, "png", output);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static public List<float[][]> loadImages() {
        List<float[][]> gridList = new ArrayList<>();
        File folder = new File("img");
        for (File img : folder.listFiles()) {
            try {
                float[][] grid = new float[Sketch.GRID_COLS][Sketch.GRID_ROWS];
                BufferedImage bufferedImage = ImageIO.read(img);
                for (int i = 0; i < bufferedImage.getWidth(); i++) {
                    for (int j = 0; j < bufferedImage.getHeight(); j++) {
                        float a = (float)bufferedImage.getRGB(i, j);
                        a = a == -1 ? 1 : -1;
                        grid[i][j] = a;
                    }
                }
//                Printer.printMatrix(grid);
                gridList.add(grid);
            } catch (IOException ex) {
                Logger.getLogger(ImageManager.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return gridList;
    }

    static public float[][] loadImage(int x) {
        float[][] image = new float[Sketch.GRID_COLS][Sketch.GRID_ROWS];
//        System.out.println(x);
        File folder = new File("img");
        File[] files = folder.listFiles();
        File file = null;
        try {
            file = files[x];
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("BRAK TAKIEGO PLIKU");

        }
        try {
            BufferedImage bfImg = ImageIO.read(file);
            for (int i = 0; i < bfImg.getWidth(); i++) {
                for (int j = 0; j < bfImg.getHeight(); j++) {
                    float a = (float)bfImg.getRGB(i, j);
                    a = a == -1 ? 1 : -1;
                    image[i][j] = a;
                }
            }
        } catch (IOException | IllegalArgumentException ex) {
//            System.out.println("tutaj sie cos sypnelo");
        }
        return image;
    }
}
