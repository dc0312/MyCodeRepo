package com.dc.data.structures.tree;

public class Tree {
    public class TreeNode{
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Data ->" + value;
        }

        public void insert(int dd){
            if(dd < value){
                if(left == null){
                    left = new TreeNode(dd);
                }else{
                    left.insert(dd);
                }
            }else{
                if(null == right){
                    right = new TreeNode(dd);
                }else{
                    right.insert(dd);
                }
            }
        }

    }

    public TreeNode root;

    public void insert(int dd){
        if(null == root){
            root = new TreeNode(dd);
        }else{
            root.insert(dd);
        }
    }

    public void inOrder(TreeNode root){
        if(null != root){
            inOrder(root.left);
            System.out.print(root.value+",");
            inOrder(root.right);
        }
    }

}
