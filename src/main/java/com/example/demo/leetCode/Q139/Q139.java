package com.example.demo.leetCode.Q139;

import java.util.Arrays;
import java.util.List;

public class Q139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int index = 0;
        int[] recordDict = new int[s.length()];

        return wordBreakSub(s, wordDict, index, recordDict);

    }

    public boolean wordBreakSub(String s, List<String> wordDict, int index, int[] recordDict) {
        if (index == s.length()) {
            return true;
        }

        if (index > s.length()) {
            return false;
        }

        // 记录，避免重复计算
        if (recordDict[index] == 1) {
            return true;
        } else if (recordDict[index] == 2) {
            return false;
        }

        boolean nextWordMatchRes = false;
        for (String word : wordDict) {
            if (index + word.length() - 1 >= s.length()) {
                continue;
            }

            boolean wordMatchRes = s.startsWith(word, index);
            if (wordMatchRes) {
                nextWordMatchRes = wordBreakSub(s, wordDict,index + word.length(), recordDict);
            }

            if (nextWordMatchRes) {
                break;
            }

        }

        recordDict[index] = nextWordMatchRes ? 1 : 2;
        return nextWordMatchRes;
    }


    public static void main(String[] args) {
        Q139 q = new Q139();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        boolean res = q.wordBreak(s, wordDict);
        System.out.println(res);
    }
}
