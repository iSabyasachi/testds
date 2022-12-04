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
public class TestDFS{    
    public static List<Character> findDFS(Node<Character> root){
        if(root == null) return new ArrayList<>();

        List<Character> leftList = findDFS(root.left);
        List<Character> rightList = findDFS(root.right);
        
        List<Character> allList = new ArrayList<>();
        allList.add(root.ele);
        allList.addAll(leftList);
        allList.addAll(rightList);
        return allList;
    }
    public static void main(String[] args){
        Node<Character> root = new Node<>('a');
        root.left = new Node<>('b');
        root.right = new Node<>('c');
        root.left.left = new Node<>('d');
        root.left.right = new Node<>('e');
        root.right.right = new Node<>('f');

        List<Character> result = findDFS(root);
        System.out.println(result);
    }
}