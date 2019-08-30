package com.dc.data.structures.linkedList;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);
        tree.insert(12);
        tree.insert(35);

        tree.inOrderTraversal(tree.root);
        System.out.println();
        System.out.println(tree.get(26));
        System.out.println(tree.max());
        System.out.println(tree.min());
        System.out.println(tree.getHeight());
        System.out.println(tree.getDiameter());
        tree.breathFirst();
        System.out.println();
        tree.delete(30);
        tree.inOrderTraversal(tree.root);
    }
}
