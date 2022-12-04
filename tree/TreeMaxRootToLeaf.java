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
public class TreeMaxRootToLeaf{
    
    public static int maxRootToLeaf(Node<Integer> root){
        if(root == null) return Integer.MIN_VALUE;
        if(root.left == null && root.right == null) return root.ele;

        int maxSumOfChildNode = Math.max(maxRootToLeaf(root.left), maxRootToLeaf(root.right)); 
        return root.ele + maxSumOfChildNode;
    }
    public static void main(String[] args){
        Node<Integer> root = new Node<>(5);
        root.left = new Node<>(11);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(2);
        root.right.right = new Node<>(1);

        int result = maxRootToLeaf(root);
        System.out.println(result);
    }
}