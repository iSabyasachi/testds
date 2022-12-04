package testds.tree;

import java.util.*;
class Node<E>{
    E ele;
    Node<E> left;
    Node<E> right;

    public Node(E ele){
        this.ele = ele;
        this.left = null;
        this.right = null;
    }
    
}
public class TreeSum{  
    public static int treeSum(Node<Integer> root){
        if(root == null) return 0;

        return root.ele + treeSum(root.left) + treeSum(root.right);
    }
    public static void main(String[] args){
        Node<Integer> root = new Node<>(3);
        root.left = new Node<>(11);
        root.right = new Node<>(4);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(2);
        root.right.right = new Node<>(1);

        int result = treeSum(root);
        System.out.println(result);
    }
}