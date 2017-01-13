package Main;

import processing.core.PApplet;

public class Cell {

    // A cell object knows about its location in the grid 
    // as well as its size with the variables x,y,w,h
    public int active = -1;
    int activeColor = 0;
    int inactiveColor = 128;
    int x, y;   // x,y location
    int w, h;   // width and height
    double angle; // angle for oscillating brightness
    PApplet aplet;

    // Cell Constructor
    Cell(int tempX, int tempY, int tempW, int tempH, double tempAngle, PApplet aplet) {
        x = tempX;
        y = tempY;
        w = tempW;
        h = tempH;
        angle = tempAngle;
        this.aplet = aplet;
    }

    Cell() {
    }

    protected void setInactive() {
        active = -1;
        display(inactiveColor);
    }

    public void changeColor() {
        if (Sketch.draw) {
            active = 1;
            display(activeColor);
        } else {
            active = -1;
            display(inactiveColor);
        }
    }

//    public void changeActive() {
//        active = -active;
//    }

    // Oscillation means increase angle
    void display() {
        double angleColor;
                
        if (active == 1) {
            angleColor = activeColor;
        } else {
            angleColor = inactiveColor;
        }
        aplet.stroke(255);
        // Color calculated using sine wave
        aplet.fill((float) angleColor);
        aplet.rect(x, y, w, h);
    }

    public void display(double angle) {
        aplet.stroke(255);
        // Color calculated using sine wave
        aplet.fill((float) angle);
        aplet.rect(x, y, w, h);
    }

    public boolean cellClicked(int mouseX, int mouseY) {
        return Calculations.isOverRec(x, y, w, h, mouseX, mouseY);
    }
}
