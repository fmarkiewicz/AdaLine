
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.List;
import processing.core.PApplet;

public class Sketch extends PApplet {

    static int T = 1000000;

    static boolean draw = true;

    int buttonsX = 10;
    int buttonsY = 310;
    int buttonsHeight = 30;
    int buttonsWidth = 120;

    static final int GRID1_X = 0;
    static final int GRID1_Y = 0;
    static final int CELL_SIZE = 50;
    static final int GRID_COLS = 5;
    static final int GRID_ROWS = 6;

    static final int GRID2_X = CELL_SIZE * GRID_COLS;
    static final int GRID2_Y = CELL_SIZE * GRID_ROWS;

    static Cell[][] grid1 = new Cell[GRID_COLS][GRID_ROWS];
    static Cell[][] grid2 = new Cell[GRID_COLS][GRID_ROWS];

    ButtonFunctions btn = new ButtonFunctions();
    List<MyButton> buttonList = new ArrayList<>();
    public static List<Perceptron> perceptrons = new ArrayList<>();

    static public void main(String args[]) {
        PApplet.main(new String[]{"Main.Sketch"});
    }

    @Override
    public void setup() {
        textSize(25);

        for (int i = 0; i < GRID_COLS; i++) {
            for (int j = 0; j < GRID_ROWS; j++) {

                grid1[i][j] = new Cell(GRID1_X + i * CELL_SIZE, GRID1_Y + j * CELL_SIZE, CELL_SIZE, CELL_SIZE, 128, this);
                grid2[i][j] = new Cell(GRID2_X + i * CELL_SIZE, GRID2_Y + j * CELL_SIZE, CELL_SIZE, CELL_SIZE, 128, this);

                grid1[i][j].display();
                grid2[i][j].display();
            }
        }

        buttonList.add(new MyButton("learn", this));
        buttonList.add(new MyButton("answer", this));
        buttonList.add(new MyButton("clear", this));
        buttonList.add(new MyButton("draw", this));
        buttonList.add(new MyButton("erease", this));
        buttonList.add(new MyButton("printInput", this));
        buttonList.add(new MyButton("saveImg", this));

        for (int i = 0; i < buttonList.size(); i++) {
            MyButton but = buttonList.get(i);
            but.setCoordinates(buttonsX, buttonsY + buttonsHeight * i, buttonsHeight, buttonsWidth);
            but.display();
        }
        
        for (int i = 0; i<10; i++) {
            perceptrons.add(new Perceptron(GRID_COLS * GRID_ROWS));
        }

    }

    @Override
    public void settings() {
        size(1000, 700);  // size always goes first!
//  surface.setResizable(true);
    }

    @Override
    public void draw() {

    }

    @Override
    public void mousePressed() {
        update(mouseX, mouseY);
    }

    @Override
    public void mouseDragged() {
        update(mouseX, mouseY);
    }

    void update(int x, int y) {
        if (Calculations.isOverRec(GRID1_X, GRID1_Y, GRID_COLS*CELL_SIZE, GRID_ROWS * CELL_SIZE, x, y)) {
            switchColorOfCell(x, y);
        } else {
            for (MyButton b : buttonList) {
                b.display();
                if (b.clicked(x, y)) {
                    b.func();
                    b.displayClicked();
                }
            }
        }
    }

    @Override
    //klawiatura
    public void keyPressed() {
    if ((int) key > 47 && (int) key < 57) {
            int a = (int) key - 48;
            System.out.println(a);
            btn.clear();
            float[][] tmpGrid = ImageManager.loadImage(a);
            
            for (int i = 0; i < tmpGrid.length; i++) {
                for (int j = 0; j < tmpGrid[0].length; j++){
                    grid1[i][j].active = (int)tmpGrid[i][j];
                    grid1[i][j].display();
                }
            }
        }
    }

    public void switchColorOfCell(int x, int y) {
        boolean foundCell = false;
        for (int i = 0; i < GRID_COLS; i++) {
            for (int j = 0; j < GRID_ROWS; j++) {
                if (grid1[i][j].cellClicked(x, y)) {
                    grid1[i][j].changeColor();
                }
            }
        }
    }

}
