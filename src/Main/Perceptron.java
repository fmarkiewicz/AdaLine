/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Random;

/**
 *
 * @author Hayab_000
 */
public class Perceptron {
    public float sum;
    public float[] weights;

    public Perceptron(float[] weights) {
        this.weights = weights;
    }

    public Perceptron(int numOfWeights) {
        Random rand = new Random();
        float[] tmpWeights = new float[numOfWeights];
        
        for (int i = 0; i<numOfWeights; i++) {
            tmpWeights[i] = ((float)rand.nextInt(20000000) - 10000000)/10000000;
        }
        
        this.weights = tmpWeights;
    }
    
    
    
    
    
}
