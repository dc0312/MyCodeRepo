package com.dc.data.structures.tree;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Tree {

    TreeNode root;

    public  void insert(int value ){
        if(root==null){
            root = new TreeNode(value);
        }else{
            root.insert(value);
        }
    }

    public void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.getLeftChild());
            System.out.print(root.getData()+",");
            inOrder(root.getRightChild());
        }
    }

    public TreeNode get(int value){
        if(root != null){
            return root.get(value);
        }else{
            return null;
        }
    }

    public int min(){
        if(root == null){
            return Integer.MIN_VALUE;
        }else{
            return root.min();
        }
    }

    public int max(){
        if(root == null){
            return Integer.MAX_VALUE;
        }else{
            return root.max();
        }
    }

    public int getHeight(){
        if(root ==null){
            return 0;
        }
        return root.getHeight(root);
    }

    public int getDiameter(){
        if(root == null){
            return 0;
        }
        return root.getDiameter(root);
    }

    public void delete(int value){
        root = delete(root,value);
    }

    private TreeNode delete(TreeNode subTreeRoot, int value){
        if(subTreeRoot == null){
            return subTreeRoot;
        }
        if(value < subTreeRoot.getData()){
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(),value));
        }else if (value > subTreeRoot.getData()){
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(),value));
        }else{
            if(subTreeRoot.getLeftChild() == null){
                return subTreeRoot.getRightChild();
            }else if(subTreeRoot.getRightChild() == null){
                return subTreeRoot.getLeftChild();
            }

            subTreeRoot.setData(subTreeRoot.getRightChild().min());

            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(),subTreeRoot.getData()));
        }
        return subTreeRoot;
    }

    public Pair<Integer,Integer> getHeightDiameter(){
        if(root == null){
            return null;
        }
        return root.getHeightDiameter(root);
    }

    public void breadthFirst(){
        if(null == root){
            return;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            System.out.print(node.getData()+",");

            if(null != node.getLeftChild()){
                queue.add(node.getLeftChild());
            }
            if(null != node.getRightChild()){
                queue.add(node.getRightChild());
            }
        }
    }
}
