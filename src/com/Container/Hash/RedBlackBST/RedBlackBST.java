package com.Container.Hash.RedBlackBST;

import com.sun.org.apache.regexp.internal.RE;

import javax.xml.soap.Node;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/159:59
 */
public class RedBlackBST<Key extends Comparable<Key>,Value> {

    private Node root;
    private Node node;
    private static final boolean RED = true;
    private static final boolean BlACK = false;

    public RedBlackBST(Key key,Value value) {
        this.node = new Node(key,value,BlACK);
    }

    public Node getNode() {
        return node;
    }

    public Node getRoot() {
        return root;
    }

    public class Node{
        private Key key;
        private Value value;
        private Node left,right,parent;
        private boolean color;

        public Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }

        public Key getKey() {
            return key;
        }

        public Value getValue() {
            return value;
        }

        public String getColor() {
            return color?"RED":"BLACK";
        }

        private Node parentOf(Node x){
            return (x==null ? null : x.parent);
        }

        private boolean colorOf(Node x){
            return (x==null?BlACK:x.color);
        }

        private Node leftOf(Node x){
            return (x==null?null:x.left);
        }

        private Node rightOf(Node x){
            return (x==null?null:x.right);
        }
        private void setColor(Node x,boolean color){
            if(x!=null)
                x.color = color;
        }

        public void forEach(Node node){

            if(node.left.key!=null && node.left.value!=null)
                forEach(node.left);

                String color =(node.color?"RED":"BLACK");
                System.out.println("key:"+node.key+" - value:"+node.value+" - color:"+color);


            if(node.right.key!=null && node.right.value!=null)
                forEach(node.right);

        }
        public void middleforEach(Node node){

            String color =(node.color?"RED":"BLACK");
            System.out.println("key:"+node.key+" - value:"+node.value+" - color:"+color);

            if(node.left.key!=null && node.left.value!=null)
                forEach(node.left);


            if(node.right.key!=null && node.right.value!=null)
                forEach(node.right);

        }

        public Value getValue(Key key){

            Node x  = root;
            while (x!=null){

                int cmp = key.compareTo(x.key);
                if(cmp < 0)
                    x = x.left;
                else if(cmp > 0)
                    x = x.right;
                else
                    return x.value;

            }
            return null;
        }

        public Node getNode(Key key){

            Node x  = root;
            while (x!=null){

                int cmp = key.compareTo(x.key);
                if(cmp < 0)
                    x = x.left;
                else if(cmp > 0)
                    x = x.right;
                else
                    return x;

            }
            return null;
        }


        public void put(Key key,Value val){

            if(root == null){
                Node node = new Node(key, val, BlACK);
                root = node;
                Node left = new Node(null, null, BlACK);
                Node right = new Node(null, null, BlACK);
                root.left = left;
                root.right =right;
                return;
            }

            Node cur = root;
            Node parent = null;

            while (cur.key!=null && cur.value!=null){

                parent = cur;
                int cmp = key.compareTo(cur.key);
                if(cmp > 0)
                    cur = cur.right;
                else if(cmp < 0)
                    cur = cur.left;
                else {
                    cur.value = value;
                    return;
                }
            }
            Node left = new Node(null, null, BlACK);
            Node right = new Node(null, null, BlACK);
            Node node = new Node(key, val, RED);
            node.right = right;
            node.left = left;

            if(key.compareTo(parent.key)>0){
                parent.right = node;
            }else {
                parent.left = node;
            }
            node.parent = parent;
            fixAfterInsertion(node);
        }

        private void fixAfterInsertion(Node x){

            while(x!=null && colorOf(parentOf(x)) == RED){

                Node parent = parentOf(x);
                Node gandPa = parentOf(parentOf(x));

                if(leftOf(gandPa) == parent){ //case1||case2||case3 parent???gandPa?????????,???x????????????
                    Node uncle = rightOf(gandPa);
                    if(uncle.color==RED){     //case1 uncle???Red

                        setColor(parent, BlACK);
                        setColor(uncle, BlACK);
                        setColor(gandPa, BlACK);
                        x = gandPa;     //???????????????????????????????????????x=gandPa,?????????????????????

                    }else {                   //case2 || case3  uncle?????????
                        if(x ==rightOf(parent)){           //x???parent?????????  case2
                            x=parent;
                            //?????????
                            rotateLeft(x);
                        }
                                                //case3
                        setColor(parent, BlACK);
                        setColor(gandPa, RED);
                        rotateRight(gandPa);
                    }
                }
                else if (rightOf(gandPa)==parent){          //case 4||5||6
                    Node uncle = leftOf(gandPa);
                    if(uncle.color==RED){                   //case 4
                        setColor(parent,BlACK);
                        setColor(uncle,BlACK);
                        setColor(gandPa, BlACK);
                        x = gandPa;
                    }else {                                 //case 5
                        if(x == leftOf(parent)){
                            x = parent;
                            rotateRight(x);
                        }
                        setColor(parent, BlACK);
                        setColor(gandPa, RED);
                        rotateLeft(gandPa);
                    }
                }



            }



        }

        /*
            ??????x???right?????????????????????

            ??????y???left??????

            ???y???parent?????? 3?????????

            x???parent????????????

         */
        private void rotateLeft(Node x){

            if(x==null)
                return;

            Node y = x.right;

            //1.???x???right?????????y???left
            x.right = y.left;

            //2.y???left??????null??????y???left???parent???x
            if(y.left!=null)
                y.left.parent = x;

            //3.?????????y???????????????y???left?????????x
            y.left = x;

            //4.y???parent???x???parent
            y.parent = x.parent;

            //4.1????????????
            if(x.parent==null)
                root = y;
            //4.2??????  ????????????
            else if(x.parent.left == x)
                x.parent.left = y;
            //4.3?????? ????????????
            else
                x.parent.right = y;

            //5. ????????????x???parent????????????
            x.parent = y;


        }

        private void rotateRight(Node x){

            if(x==null)
                return;
            Node y = x.left;

            x.left = y.right;
            if(y.right!=null)
                y.right.parent = x;

            y.right = x;

            y.parent = x.parent;
            if(x.parent==null)
                root = y;
            else if(x.parent.left==x)
                x.parent.left = y;
            else
                x.parent.right = y;

            x.parent = y;

        }




    }
}
