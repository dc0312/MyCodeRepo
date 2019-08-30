package com.dc.data.structures.tree;

import java.util.Stack;

public class Tree {
    public class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Data ->"+data;
        }

        public void insert(int value){
            if(value < data){
                if(left == null){
                    left = new TreeNode(value);
                }else{
                    left.insert(value);
                }
            }else{
                if(right == null){
                    right = new TreeNode(value);
                }else{
                    right.insert(value);
                }
            }
        }

    }

    TreeNode root;

    public void insert(int value){
        if(null == root){
            root = new TreeNode(value);
        }else{
            root.insert(value);
        }
    }

    public void inOrder(TreeNode treeNode){
        Stack<TreeNode>  stack = new Stack<>();
        addLeftNodesToStack(stack,treeNode);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            System.out.print(curr.data+",");
            if(curr.right != null){
                addLeftNodesToStack(stack,curr.right);
            }
        }
    }

    private void addLeftNodesToStack(Stack stack,TreeNode treeNode) {
        while(treeNode != null){
            stack.push(treeNode);
            treeNode = treeNode.left;
        }
    }


}
