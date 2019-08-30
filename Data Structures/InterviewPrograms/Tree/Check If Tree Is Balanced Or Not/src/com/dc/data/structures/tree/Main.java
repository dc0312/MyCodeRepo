package com.dc.data.structures.tree;

class Tree{
    class TreeNode{
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

        public void insert(int value){
            if(value < data){
                if(left == null){
                    left = new TreeNode(value);
                }else{
                    left.insert(value);
                }
            }else{
                if(null == right){
                    right = new  TreeNode(value);
                }else{
                    right.insert(value);
                }
            }
        }

    }

    TreeNode root;

    public void insert(int dd){
        if(null == root){
            root = new TreeNode(dd);
        }else{
            root.insert(dd);
        }
    }

    public void inOrder(TreeNode treeNode){
        if(null != treeNode){
            inOrder(treeNode.left);
            System.out.print(treeNode.data+",");
            inOrder(treeNode.right);
        }
    }

    public boolean isBST(Tree tree){
        return balancedHeight(tree.root) > -1 ? true : false;
    }

    private int balancedHeight(TreeNode treeNode){
        if(null == treeNode){
            return 0;
        }

        int h1 = balancedHeight(treeNode.left);
        int h2 = balancedHeight(treeNode.right);

        if(Math.abs(h1-h2)>1){
            return -1;
        }

        return 1 + Math.max(h1,h2);
    }
}
public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.insert(8);
        tree.insert(12);
        tree.insert(13);
        tree.insert(14);
        tree.insert(16);
        tree.insert(25);

        tree.inOrder(tree.root);
        System.out.println();
        System.out.println(tree.isBST(tree));
    }
}
