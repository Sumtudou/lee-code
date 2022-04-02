package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class LeeCode46 {
    public static void main(String[] args) {
        LeeCode46 it = new LeeCode46();
        int[] arr = {1, 2, 3, 4};
        List<List<Integer>> permute = it.permute(arr);

        permute.forEach(
                item -> {
                    System.out.println(item.stream().map(Object::toString).collect(Collectors.joining(" ")));
                });
    }


    int len;
    List<List<Integer>> res = new ArrayList<>();
    int[][] visit;
    int[] globalNums;
    List<Integer> singleRes = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        globalNums = nums;
        len = nums.length;
        visit = new int[len + 5][len + 5];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                visit[i][j] = -1000;
            }
        }
        find(0);
        return res;
    }


    public void find(int row) {
        if (row == len) {
            // print();
            res.add(new ArrayList<>(singleRes));
            return;
        }
        for (int j = 0; j < len; j++) {
            if (notHasNum(row, j)) {
                visit[row][j] = globalNums[j];
                singleRes.add(globalNums[j]);
                find(row + 1);
                visit[row][j] = -1000;
                singleRes.remove(singleRes.size() - 1);
            }
        }
    }


    boolean notHasNum(int row, int j) {
        for (int i = 0; i < len; i++) {
            if (-1000 != visit[row][i]) {
                return false;
            }
            if (-1000 != visit[i][j]) {
                return false;
            }
        }
        return true;
    }

    // void print() {
    //     for(int i = 0; i< len; i++) {
    //         for(int j = 0; j< len ;j++) {
    //             System.out.print(visit[i][j] + "  ");
    //         }
    //         System.out.print("\n");
    //     }
    //      System.out.print("===============\n");
    //      singleRes.forEach(item ->  System.out.print(item + "  "));
    //      System.out.print("\n---------------\n");
    // }
}
