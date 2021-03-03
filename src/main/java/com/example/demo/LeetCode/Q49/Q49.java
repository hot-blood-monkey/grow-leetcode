package com.example.demo.LeetCode.Q49;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author zh
 * @date 2021-02-20 15:50
 **/

public class Q49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = String.valueOf(array);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Object o = new Q49().groupAnagrams(strs);
        System.out.println(JSON.toJSONString(o));
    }
}
