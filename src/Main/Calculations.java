/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Hayab_000
 */
public class Calculations {

//------------------------------------------------------------------------------    
    public static boolean isOverRec(int x, int y, int width, int height, int mouseX, int mouseY) {
        return mouseX > x && mouseX < x + width
                && mouseY > y && mouseY < y + height;
    }
//------------------------------------------------------------------------------

    public static float alpha(float t, float T) {
        return 1 - ((t - 1) / T);
    }
//------------------------------------------------------------------------------

    public static float[] matrixToVector(float[][] matrix) {
        float[] vector = new float[matrix.length * matrix[0].length];
        int it = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                vector[it] = matrix[i][j];
                it++;
            }
        }

        return vector;
    }
//------------------------------------------------------------------------------

    public static float[] computeDft(float[] inreal) {
        int n = inreal.length;
        int m = n;
        float[] real = new float[n];
        float[] imag = new float[n];
        float[] result = new float[m];
        float pi_div = 2.0f * (float)(Math.PI) / n;
        for (int w = 0; w < m; w++) {
            float a = w * pi_div;
            for (int t = 0; t < n; t++) {
                real[w] += inreal[t] * Math.cos(a * t);
                imag[w] += inreal[t] * Math.sin(a * t);
            }
            result[w] = (float)Math.sqrt(real[w] * real[w] + imag[w] * imag[w]) / (float)Math.sqrt(n);
        }
        return result;
    }

}
