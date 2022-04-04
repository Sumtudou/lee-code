package main;

public class LeeCode11 {


    public static void main(String[] args) {
        LeeCode11 leeCode11 = new LeeCode11();
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(leeCode11.maxArea(arr));
    }


    int maxArea(int[] height) {
        int len = height.length;

        int i = 0, j = len - 1;
        int max = 0;
        while (i < j) {
            int tep = Math.min(height[i], height[j]) * (j - i);
            if (tep > max) max = tep;
            if (height[i] < height[j]) {
                i++;
            } else if (height[i] == height[j]) {
                /*这里很有趣，如果 两个 柱子高度相等。那么 以 他俩 任意一个为边来看。这个时候已经是最大了，所以两边都可以往里面缩。*/
                /*如果 两个 柱子高度相等 这时，只移动任何一个，min(height[i], height[j])不变，j-i减小，总值肯定减小了。*/
                i++;
                j--;
            } else {
                j--;
            }
        }
        return max;
    }
}
