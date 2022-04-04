package main;

import java.util.HashMap;
import java.util.Map;

public class LeeCode12 {

    public static void main(String[] args) {

        LeeCode12 leeCode12 = new LeeCode12();
        System.out.println(leeCode12.romanToInt("LVIII"));
    }

    /*貪心*/
    public String intToRoman(int num) {
        String[] chars = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] array = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; ) {
            if (num == 0) {
                break;
            }
            if (num >= array[i]) {
                num = num - array[i];
                sb.append(chars[i]);
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    public int romanToInt(String s) {
        Map<String, Integer> two = new HashMap<>();
        two.put("CM", 900);
        two.put("CD", 400);
        two.put("XC", 90);
        two.put("XL", 40);
        two.put("IX", 9);
        two.put("IV", 4);

        Map<String, Integer> one = new HashMap<>();
        one.put("M", 1000);
        one.put("D", 500);
        one.put("C", 100);
        one.put("L", 50);
        one.put("X", 10);
        one.put("V", 5);
        one.put("I", 1);

        int sum = 0;
        while (true) {
            if (s.length() >= 2) {
                String str = s.substring(0, 2);
                Integer integer = two.get(str);
                if (integer != null) {
                    sum += integer;
                    s = s.substring(2, s.length());
                } else {
                    String str1 = s.substring(0, 1);
                    Integer oneIt = one.get(str1);
                    sum += oneIt;
                    s = s.substring(1);
                }
            } else if (s.length() == 1) {
                String str1 = s.substring(0, 1);
                Integer oneIt = one.get(str1);
                sum += oneIt;
                s = s.substring(1);
            } else {
                break;
            }
        }
        return sum;
    }
}
