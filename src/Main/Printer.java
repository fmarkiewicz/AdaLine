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
public class Printer {

    static void printMatrix(Cell[][] cell) {
        int cols = cell.length;
        int rows = cell[0].length;
        int[][] matrix = new int[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                matrix[i][j] = cell[i][j].active;
            }
        }
        printMatrix(matrix);
    }

    static public void printMatrix(double[][] m) {
        try {
            int cols = m.length;
            int rows = m[0].length;
            String str = "|";
            System.out.println("Print Matrix");
            for (int i = 0; i < cols; i++) {
                System.out.print(str);
                for (int j = 0; j < rows; j++) {
                    int a = m[i][j] == 1 ? 1 : 0;
                    System.out.print(a);
                }
                System.out.println("|");
            }

        } catch (Exception e) {
            System.out.println("Matrix is empty!!");
        }
        System.out.println("------------------------------------------");

    }
    
    static public void printMatrix(int[][] m) {
        try {
            int cols = m.length;
            int rows = m[0].length;
            String str = "|";
            System.out.println("Print Matrix");
            for (int i = 0; i < cols; i++) {
                System.out.print(str);
                for (int j = 0; j < rows; j++) {
                    int a = m[i][j] == 1 ? 1 : 0;
                    System.out.print(a);
                }
                System.out.println("|");
            }

        } catch (Exception e) {
            System.out.println("Matrix is empty!!");
        }
        System.out.println("------------------------------------------");

    }

    static void printVector(double[] vector) {
        System.out.println("Print Vector as Matrix");
        for (int i = 0; i < vector.length; i++) {
            if (i % 40 == 0 && i != 0) {
                System.out.println("");
            }
            System.out.print(vector[i]);
        }
        System.out.println("");
        System.out.println("------------------------------------------");
    }

    static void printVector(int[] vector) {
        System.out.println("Print Vector as Matrix");
        for (int i = 0; i < vector.length; i++) {
            int a = vector[i] == 1 ? 1 : 0;
//            int a = vector[i];
            if (i % 40 == 0 && i != 0) {
                System.out.println("");
            }
            System.out.print(a);
        }
        System.out.println("");
        System.out.println("------------------------------------------");
    }
}
