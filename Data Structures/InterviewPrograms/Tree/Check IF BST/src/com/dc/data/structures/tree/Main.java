package com.dc.data.structures.tree;

import org.omg.PortableInterceptor.INACTIVE;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(5);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(7);
        tree.insert(6);
        tree.insert(8);

        tree.inOrder(tree.root);
        System.out.println();
        System.out.println(isBST(tree));
    }

    public static boolean isBST(Tree tree){
        return isBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(Tree.TreeNode treeNode, int min , int max){
        if(treeNode == null){
            return true;
        }
        if(treeNode.value < min || treeNode.value > max){
            return false;
        }
        return isBST(treeNode.left, min, treeNode.value) && isBST(treeNode.right, treeNode.value + 1, max );
    }
}
