package main;

import java.util.*;

public class LeeCode17 {




    public static void main(String[] args) {
        LeeCode17 le = new LeeCode17();
        le.letterCombinations("23");
    }

    static int maxDep;
    static List<String> res;
    static Map<Integer, List<Character>> numToChar;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }
        maxDep = digits.length();
        res = new ArrayList<>();
        numToChar = new HashMap<>();
        numToChar.put(2, Arrays.asList('a', 'b', 'c'));
        numToChar.put(3, Arrays.asList('d', 'e', 'f'));
        numToChar.put(4, Arrays.asList('g', 'h', 'i'));
        numToChar.put(5, Arrays.asList('j', 'k', 'l'));
        numToChar.put(6, Arrays.asList('m', 'n', 'o'));
        numToChar.put(7, Arrays.asList('p', 'q', 'r', 's'));
        numToChar.put(8, Arrays.asList('t', 'u', 'v'));
        numToChar.put(9, Arrays.asList('w', 'x', 'y', 'z'));

        su(0, "", digits);
        return res;
    }

    public void su(int dep, String str, String originStr) {
        if (dep == maxDep) {
            res.add(str);
            return;
        }
        List<Character> characters = numToChar.get(Integer.parseInt(originStr.charAt(dep) + ""));
        for (Character character : characters) {
            su(dep + 1, str + character, originStr);
        }
    }
}
