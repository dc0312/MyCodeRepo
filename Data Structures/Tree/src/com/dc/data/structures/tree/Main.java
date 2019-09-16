package com.dc.data.structures.tree;

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

        //tree.inOrder(tree.root);
        System.out.println();

        //tree.delete(15);

        //tree.inOrder(tree.root);
        /*System.out.println(tree.get(15));
        System.out.println(tree.get(151));

        System.out.println(tree.min());
        System.out.println(tree.max());

        System.out.println("Height : "+tree.getHeight());

        System.out.println("Diameter : "+tree.getDiameter());

        System.out.println("Height : "+tree.getHeightDiameter().first);
        System.out.println("Diameter : "+tree.getHeightDiameter().second);*/

        tree.delete(27);
        System.out.println();
        //tree.inOrder(tree.root);
        System.out.println();
        tree.breadthFirst();
    }
}
