package com.example.demo.LeetCode.Q316;

import java.util.*;

public class Q316 {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 0);
            }

            map.put(ch, map.get(ch) + 1);
        }


        boolean[] visited = new boolean[26];
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (visited[c - 'a']) {
                map.put(c, map.get(c) - 1);
                continue;
            }
            while (!deque.isEmpty() && deque.peekLast() > c && map.get(deque.peekLast()) > 0) {
                Character pollOne = deque.pollLast();
                visited[pollOne - 'a'] = false;

            }
            deque.addLast(c);
            map.put(c, map.get(c) - 1);
            visited[c - 'a'] = true;

        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        return sb.toString();   
    }

    public static void main(String[] args) {
        Q316 q = new Q316();
        String res = q.removeDuplicateLetters("bbcaac");
        System.out.println(res);
    }
}
