/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Yumis
 */
public class ButtonFunctions {

    public void learn() {
        float learnConst = 0.0001f;

        Random rand = new Random();
        List<float[][]> examples = new ArrayList<>();
        examples = ImageManager.loadImages();
        List<Example> vectorExamplesDFT = new ArrayList<>();

        // konwersja na vector z przeliczeniem transformaty fouriera
        for (float[][] example : examples) {
            vectorExamplesDFT.add(new Example(Calculations.computeDft(Calculations.matrixToVector(example))));
        }

        // iteracja po 10 perceptronach
        for (int i = 0; i < Sketch.perceptrons.size(); i++) {

            // podzial na dobre i zle przyklady dla danego perceptronu
            int it = 0;
            for (int j = 0; j < vectorExamplesDFT.size(); j += 3) {
                if (it == i) {
                    vectorExamplesDFT.get(j).setGoodOrBad(1);
                    vectorExamplesDFT.get(j + 1).setGoodOrBad(1);
                    vectorExamplesDFT.get(j + 2).setGoodOrBad(1);
                } else {
                    vectorExamplesDFT.get(j).setGoodOrBad(-1);
                    vectorExamplesDFT.get(j + 1).setGoodOrBad(-1);
                    vectorExamplesDFT.get(j + 2).setGoodOrBad(-1);
                }
                it++;
            }

            for (int j = 0; j < Sketch.T; j++) {
                //losowanie przykladu
                Example currentExample = vectorExamplesDFT.get(rand.nextInt(vectorExamplesDFT.size()));
                //liczenie sumy
                float sum = 0;
                for (int k = 0; k < currentExample.input.length; k++) {
                    sum += Sketch.perceptrons.get(i).weights[k] * currentExample.input[k];
                }

                //poprawianie wag
                for (int k = 0; k < Sketch.perceptrons.get(i).weights.length; k++) {
                    Sketch.perceptrons.get(i).weights[k] = Sketch.perceptrons.get(i).weights[k]
                            + learnConst * ((float) currentExample.goodOrBad - sum) * currentExample.input[k];
                }

            }
        }

        Sketch.buttonList.get(7).setVal("learned");
    }

    public void answer() {
        Sketch.buttonList.get(7).setVal("");
        HashMap<Integer, Float> map = new HashMap<>();
        boolean found = false;
        float[] input = Calculations.computeDft(Calculations.matrixToVector(Sketch.grid1));
        for (int i = 0; i < Sketch.perceptrons.size(); i++) {
            float sum = 0;
            for (int j = 0; j < input.length; j++) {
                sum += Sketch.perceptrons.get(i).weights[j] * input[j];
            }

            if (sum >= 0) {
                map.put(i, sum);
//                found = true;
//                Sketch.buttonList.get(7).setVal("Ans: " + Integer.toString(i));
            }
//            if(found)break;
        }
        if (!map.isEmpty()) {
            int key = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
            Sketch.buttonList.get(7).setVal("Ans: " + key);
        } else {
            Sketch.buttonList.get(7).setVal("Ans: -1");
        }
    }

    public void clear() {
        Sketch.buttonList.get(7).setVal("");
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
