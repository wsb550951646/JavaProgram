package com.Generice.GenericeStack;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/2110:42
 */
public class LinkStack<T> {

    //类里面的内部静态类  node节点 泛型区分T选择E使用
    private static class Node<E> {

        E item;
        Node <E> next;
        Node(){item=null;next=null;}
        Node(E item, Node<E> next){
            this.item = item;
            this.next = next;
        }

        boolean end(){return item==null&&next==null;}

    }

    //top栈顶 此泛型都是与T相同泛型
    private Node<T> top = new Node<T>();

    public void push(T nodeItem){
        //新建一个node 将next指向当前top，然后再将top指向新的node
        top =new Node(nodeItem,top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;

    }

    public static void main(String[] args) {

        LinkStack<String> link = new LinkStack<String>();
        String sr = null;
        for(String s: "qqq www eee".split(" ")){

            link.push(s);

        }
        while ((sr=link.pop())!=null)
        System.out.println(sr);


    }


}
