package com.Container.Hash.RedBlackBST;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/1916:39
 */
public class Test {

    public static void main(String[] args) {


        RedBlackBST<Integer, String> bts = new RedBlackBST<>(0,"node");

        RedBlackBST<Integer, String>.Node node = bts.getNode();

        node.put(1, "a");
        node.put(2, "b");
        node.put(3, "c");
        node.put(4, "d");
        node.put(5, "e");
        node.put(6, "f");
        node.put(7, "g");
        node.put(8, "h");
        node.put(9, "i");
        node.put(10, "j");
        node.put(11, "k");
        node.put(12, "l");
        node.put(13, "n");
        node.put(14, "m");
        node.put(15, "o");
        /*
        root.put(1, "a");
        root.put(2, "b");
        root.put(3, "c");
        root.put(4, "d");
        root.put(5, "e");
        root.put(6, "f");
        root.put(8, "g");
        root.put(9, "h");
        root.put(10, "i");
        root.put(11, "j");
        root.put(12, "k");
        root.put(13, "l");
        root.put(14, "n");
        root.put(15, "m");
        */
        System.out.println(bts.getRoot().getKey()+"-"+bts.getRoot().getValue()+" -co"+bts.getRoot().getColor());


       //node.forEach(bts.getRoot());
        node.middleforEach(bts.getRoot());

        RedBlackBST<Integer, String>.Node node1 = node.getNode(13);
        RedBlackBST<Integer, String>.Node node2 = node.getNode(15);
        System.out.println(node1);
        System.out.println(node2);


    }


}
