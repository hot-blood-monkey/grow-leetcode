package com.example.demo.hw.Q3;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zh
 * @date 2021-02-11 21:24
 **/

public class Main {
    private static List<String> resList = new ArrayList<>();


    private static Set<String> resSet = new HashSet<>();

    private static Map<String, List<String>> map;



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer n = in.nextInt();
        in.nextLine();
        String s1 = in.nextLine();
        List<String> source = Arrays.stream(s1.split(" ")).sorted().collect(Collectors.toList());

        backLast(source, "");
        Arrays.stream(resSet.toArray()).sorted().forEach(System.out::println);


    }

    private static void backLast(List<String> chooseList, String s) {
        if (chooseList.size() == 0) {
            resSet.add(s);

            return;
        }

        for (int i = 0; i < chooseList.size(); i++) {
            List<String> nextChoose = new ArrayList<>(chooseList);
            nextChoose.remove(i);
            backLast(nextChoose, s + chooseList.get(i));
        }

    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        Integer n = in.nextInt();
//        in.nextLine();
//        String s1 = in.nextLine();
//        List<String> source = Arrays.stream(s1.split(" ")).collect(Collectors.toList());
//
//        backLast(source, "");
//        resList.stream().sorted().forEach(System.out::println);
//
//
//    }
//
//    private static void backLast(List<String> chooseList, String s) {
//        if (chooseList.size() == 0) {
//            if (!resList.contains(s)) {
//                resList.add(s);
//            }
//
//            return;
//        }
//
//        for (int i = 0; i < chooseList.size(); i++) {
//            List<String> nextChoose = new ArrayList<>(chooseList);
//            nextChoose.remove(i);
//            backLast(nextChoose, s + chooseList.get(i));
//        }
//
//    }
}
