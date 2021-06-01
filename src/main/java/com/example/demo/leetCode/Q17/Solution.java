package com.example.demo.leetCode.Q17;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author zh
 * @date 2021-02-14 00:45
 **/

public class Solution {
    private  List<String> resList = new ArrayList<>();
    private Stack<Character> f = new Stack<Character>();
    char s = 'c';
    private  Map<String, List<String>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return resList;
        }
        f.empty();

        init();

        char[] chars = digits.toCharArray();
        List<String> nextChooseNumStrList = new ArrayList<>();
        for (char aChar : chars) {
            nextChooseNumStrList.add(String.valueOf(aChar));
        }
        running("", nextChooseNumStrList);
        return resList;
    }


    private void init() {
        map.put("2", new ArrayList<String>(Arrays.asList("a", "b", "c")));
        map.put("3", new ArrayList<String>(Arrays.asList("d", "e", "f")));
        map.put("4", new ArrayList<String>(Arrays.asList("g", "h", "i")));
        map.put("5", new ArrayList<String>(Arrays.asList("j", "k", "l")));
        map.put("6", new ArrayList<String>(Arrays.asList("m", "n", "o")));
        map.put("7", new ArrayList<String>(Arrays.asList("p", "q", "r", "s")));
        map.put("8", new ArrayList<String>(Arrays.asList("t", "u", "v")));
        map.put("9", new ArrayList<String>(Arrays.asList("w", "x", "y", "z")));
    }


    private void running(String tempRes, List<String> chooseList) {
        if (chooseList.size() == 0) {
            resList.add(tempRes);
            return;
        }


        int index = 0;
        List<String> nextChooseNumStrList = new ArrayList<>(chooseList);
        nextChooseNumStrList.remove(index);
        for (String chooseStr : map.get(chooseList.get(index))) {
            running(tempRes + chooseStr, nextChooseNumStrList);
        }
    }

    public static void main(String[] args) {
        Object res = new Solution().letterCombinations("");
        System.out.println(JSON.toJSONString(res));


        int i = 1 << 30;
        System.out.println(i);
    }
}
