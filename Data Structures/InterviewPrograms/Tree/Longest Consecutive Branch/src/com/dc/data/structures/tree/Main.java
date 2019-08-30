package com.dc.data.structures.tree;

class Tree{
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Data->"+data;
        }
    }

    TreeNode root;

    public void inOrder(TreeNode treeNode){
        if(null != treeNode){
            inOrder(treeNode.left);
            System.out.print(treeNode.data+",");
            inOrder(treeNode.right);
        }
    }

    public int consecutiveLength(TreeNode treeNode){
        if(null == treeNode){
            return 0;
        }
        return Math.max(consecutiveLength(treeNode.left,treeNode.data,1),consecutiveLength(treeNode.right,treeNode.data,1));
    }

    private int consecutiveLength(TreeNode treeNode, int prev, int length   ) {
        if(null == treeNode){
            return length;
        }
        if(treeNode.data == prev+1){
            int leftLength = consecutiveLength(treeNode.left, treeNode.data,length+1);
            int rightLength = consecutiveLength(treeNode.right,treeNode.data, length+1);
            return Math.max(leftLength,rightLength);
        }else{
            int leftLength = consecutiveLength(treeNode.left, treeNode.data,1);
            int rightLength = consecutiveLength(treeNode.right,treeNode.data, 1);
            return Math.max(leftLength,rightLength);
        }
    }
}
public class Main {

    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.root = new Tree.TreeNode(0);
        tree.root.left = new Tree.TreeNode(1);
        tree.root.right =   new Tree.TreeNode(2);
        tree.root.left.left = new Tree.TreeNode(1);
        tree.root.left.left.left = new Tree.TreeNode(2);
        tree.root.left.left.left.left = new Tree.TreeNode(3);
        tree.root.left.left.left.left.left = new Tree.TreeNode(4);
        tree.root.left.right = new Tree.TreeNode(2);
        tree.root.right.left =   new Tree.TreeNode(1);
        tree.root.right.right =   new Tree.TreeNode(3);

        tree.inOrder(tree.root);
        System.out.println();
        System.out.println(tree.consecutiveLength(tree.root));

    }
}
