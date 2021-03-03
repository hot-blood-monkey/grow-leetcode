package com.example.demo.suanfa;

import com.alibaba.fastjson.JSON;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zh
 * @date 2021-02-10 12:31
 **/

public class P12 {

    public static List<String> s = Lists.newArrayList();


    public static void main(String[] args) {
        List<List<Integer>> res = new P12().threeSum(new int[] {-1,0,1,2,-1,-4});
        System.out.println(JSON.toJSONString(res));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<> ();
        // final state
        if (nums.length == 0) {
            return res;
        }

        // do something
        List<Integer> tmpRes = new ArrayList<> ();
        func(res, tmpRes, nums);
        return res;

    }

    public void func(List<List<Integer>> res, List<Integer> tmpRes, int[] nums) {
        if (nums.length == 0 && tmpRes.size() != 3) {
            return;
        }

        if ((tmpRes.size() == 3 && isSuc(tmpRes))) {
            List<Integer> f = tmpRes.stream().sorted().collect(Collectors.toList());
            if (!res.contains(f)) {
                res.add(f);
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            List<Integer> nextTem = new ArrayList(tmpRes);
            nextTem.add(nums[i]);
            func(res, nextTem, copy(nums, i));
        }
    }

    public int[] copy(int[] nums, int index) {
        int[] nextChoose = new int[nums.length - 1];
        int j = 0;
        for (int i = 0; i<nums.length; i++) {
            if (i == index) {
                continue;
            }
            nextChoose[j++] = nums[i];
        }

        return nextChoose;
    }

    public boolean isSuc(List<Integer> tempRes) {
        return tempRes.stream().reduce(Integer::sum).get() == 0;
    }


}
