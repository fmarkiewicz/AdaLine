/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Yumis
 */
public class ButtonFunctions {

    public void learn() {
        System.out.println("uczy");
        Random rand = new Random();
        List<float[][]> examples = new ArrayList<>();
        examples = ImageManager.loadImages();
        List<Example> vectorExamplesDFT = new ArrayList<>();
        
        // konwersja na vector z przeliczeniem transformaty fouriera
        for (float[][] example : examples ) {
            vectorExamplesDFT.add(new Example(Calculations.computeDft(Calculations.matrixToVector(example))));
        }
        
        
        float learnConst = 0.0001f;
        
        // iteracja po 10 perceptronach
        for (int i = 0; i < Sketch.perceptrons.size(); i++) {
            
            // podzial na dobre i zle przyklady dla danego perceptronu
            for (int j = 0; j < vectorExamplesDFT.size(); j++) {
                if (j%3 == i) {
                    vectorExamplesDFT.get(j).setGoodOrBad(1);
                } else {
                    vectorExamplesDFT.get(j).setGoodOrBad(-1);
                }
            }
            
            for (int j = 0; j < Sketch.T; j++) {
                Example currentExample = vectorExamplesDFT.get(rand.nextInt(vectorExamplesDFT.size()));
                
            }
            
        }
    }

    public void answer() {
        System.out.println("odpowiedz");
    }

    public void clear() {
        System.out.println("czysci");
        for (int i = 0; i < Sketch.grid1.length; i++) {
            for (int j = 0; j < Sketch.grid1[0].length; j++) {
                Sketch.grid1[i][j].setInactive();
            }
        }
    }

    public void printInput() {
        Printer.printMatrix(Sketch.grid1);
    }

    public void draw() {
        Sketch.draw = true;
    }

    public void erease() {
        Sketch.draw = false;
    }

    public void saveImg() {
        ImageManager.saveImage(Sketch.grid1);
    }
}
