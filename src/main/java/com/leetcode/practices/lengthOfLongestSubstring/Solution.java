package com.leetcode.practices.lengthOfLongestSubstring;




import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return 0;
        }
        ArrayList<String> subStrings = subStrings(addSplitor(s));

        List<Integer> maxContinue = subStrings.parallelStream().map(Solution::countMaxContinue).collect(Collectors.toList());

        return Collections.max(maxContinue);
    }


    static int countMaxContinue(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return s.length();
        }
        char[] chars = s.toCharArray();

        ArrayList<Integer> returnArrayList = new ArrayList<>(s.length());
        for (int i = 0; i < chars.length; i++) {
            HashMap<String, Integer> tempMap = new HashMap<>(s.length());
            tempMap.put(String.valueOf(chars[i]), i);
            for (int j = i + 1; j < chars.length; j++) {
                String key = String.valueOf(chars[j]);
                if (tempMap.containsKey(key)) {
                    returnArrayList.add(j - i);
                    break;
                }
                if (j == chars.length - 1) {
                    returnArrayList.add(j - i + 1);
                }
                tempMap.put(String.valueOf(chars[j]),j);
            }
        }
        Collections.sort(returnArrayList);
        return returnArrayList.get(returnArrayList.size() - 1);
    }


    ArrayList<String> addSplitor(String s) {
        char[] chars = s.toCharArray();
        ArrayList<String> arrayList = new ArrayList<>(2 * s.length());
        arrayList.add(String.valueOf(chars[0]));
        for (int i = 1; i < chars.length; i++) {
            String s1 = String.valueOf(chars[i]);
            String s0 = String.valueOf(chars[i - 1]);
            if (s0.equals(s1)) {
                arrayList.add("myspiltor");
                arrayList.add(s1);
            } else {
                arrayList.add(s1);
            }
        }
        return arrayList;
    }

    ArrayList<String> subStrings(ArrayList<String> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : arrayList) {
            stringBuilder.append(s);
        }

        String[] strings = stringBuilder.toString().split("myspiltor");

        ArrayList<String> arrayList1 = new ArrayList<>(strings.length);
        Collections.addAll(arrayList1, strings);
        return arrayList1;
    }


}
