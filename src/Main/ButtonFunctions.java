/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Random;

/**
 *
 * @author Yumis
 */
public class ButtonFunctions {

    public void learn() {
        System.out.println("uczy");
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
