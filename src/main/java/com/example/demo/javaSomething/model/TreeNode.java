package com.example.demo.javaSomething.model;

import lombok.Data;

@Data
public class TreeNode {
    public Integer value;
    public TreeNode left;
    public TreeNode right;


    public TreeNode (Integer v) {
        this.value = v;
    }


}
