package main;

import java.util.*;
import java.util.stream.Collectors;

public class LeeCode15 {


    public static void main(String[] args) {
        LeeCode15 le = new LeeCode15();
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = le.threeSum(arr);
        System.out.println("ggg");
    }

    static class ThreeNumber {
        private Integer n1;
        private Integer n2;
        private Integer n3;

        public ThreeNumber(Integer n1, Integer n2, Integer n3) {
            this.n1 = n1;
            this.n2 = n2;
            this.n3 = n3;
        }

        public Integer getN1() {
            return n1;
        }

        public void setN1(Integer n1) {
            this.n1 = n1;
        }

        public Integer getN2() {
            return n2;
        }

        public void setN2(Integer n2) {
            this.n2 = n2;
        }

        public Integer getN3() {
            return n3;
        }

        public void setN3(Integer n3) {
            this.n3 = n3;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ThreeNumber that = (ThreeNumber) o;
            return Objects.equals(n1, that.n1) && Objects.equals(n2, that.n2) && Objects.equals(n3, that.n3);
        }

        @Override
        public int hashCode() {
            return Objects.hash(n1, n2, n3);
        }
    }


    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int len = nums.length;
        Set<ThreeNumber> result = new HashSet<>();
        for (int i = 0; i < len - 2; i++) {
            int firstNum = nums[i];
            int needRes = firstNum * -1;
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                if (nums[j] + nums[k] == needRes) {
                    result.add(new ThreeNumber(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (nums[j] + nums[k] > needRes) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result.stream().map(threeNumber -> {
            List<Integer> oneSolve = new ArrayList<>();
            oneSolve.add(threeNumber.getN1());
            oneSolve.add(threeNumber.getN2());
            oneSolve.add(threeNumber.getN3());
            return oneSolve;
        }).collect(Collectors.toList());
    }
}
