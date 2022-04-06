package main;

import java.util.Arrays;

public class LeeCode48 {


    public static void main(String[] args) {
        LeeCode48 le = new LeeCode48();
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        le.rotate(arr);

        Arrays.stream(arr).forEach(row -> {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i] + "  ");
            }
            System.out.println("\n");
        });
    }


    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i < j) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= (len - 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = tmp;
            }
        }
    }
}
