package com.example.demo.leetCode.Q79;

import java.util.ArrayList;
import java.util.List;

public class Q79 {
    public boolean exist(char[][] board, String word) {

        int wordIndex = 0;
        List<int[]> hasChoose = new ArrayList<>();
        for (int row = 0; row < board.length; row ++) {
            for (int col = 0; col < board[0].length; col ++) {
                if (nextExist(board, hasChoose, row, col, word, wordIndex)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean nextExist(char[][] board, List<int[]> hasChoose, int row, int col, String word, int wordIndex) {
        if (wordIndex >= word.length()) {
            return true;
        }

        // 超出左右边界
        if (row >= board.length || col >= board[0].length || row < 0 || col < 0) {
            return false;
        }

        // 走到重复
        for (int[] chooseStep : hasChoose) {
            if (chooseStep[0] == row && chooseStep[1] == col) {
                return false;
            }
        }


        // 1. compare
        if (board[row][col] == word.charAt(wordIndex)) {
            hasChoose.add(new int[]{row, col});

            boolean res = nextExist(board, hasChoose, row + 1, col, word, wordIndex + 1)
                    || nextExist(board, hasChoose, row - 1, col, word, wordIndex + 1)
                    || nextExist(board, hasChoose, row, col + 1, word,  wordIndex + 1)
                    || nextExist(board, hasChoose, row, col - 1, word, wordIndex + 1);
            hasChoose.remove(hasChoose.size() - 1);

            return res;
        }
        return false;
    }


    public static void main(String[] args) {
        Q79 q = new Q79();
        char[][] board = new char[][] {{'C','A','A'}, {'A','A','A'}, {'B','C','D'}};
        boolean res = q.exist(board, "AAB");
        System.out.println(res);
    }
}
