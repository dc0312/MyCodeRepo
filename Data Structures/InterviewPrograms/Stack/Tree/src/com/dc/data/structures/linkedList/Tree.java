package com.dc.data.structures.linkedList;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    public TreeNode root;

    public void insert(int data){
        if(null == root){
            root = new TreeNode(data);
        }else{
            root.insert(data);
        }
    }

    public void inOrderTraversal(TreeNode root){
        root.inOrderTraversal(root);
    }

    public TreeNode get(int value){
        if(root == null){
            return null;
        }else{
            return root.get(value);
        }
    }

    public TreeNode max(){
        if(root == null){
            return null;
        }else{
            return root.max();
        }
    }

    public TreeNode min(){
        if(root == null){
            return null;
        }else{
            return root.min();
        }
    }

    public int getHeight(){
        if(null == root){
            return 0;
        }else{
            return root.getHeight(root);
        }
    }

    public int getDiameter(){
        if(null == root){
            return 0;
        }else{
            return root.getDiameter(root);
        }
    }

    public void breathFirst(){
        if(null == root){
            return;
        }else{
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                System.out.print(node.data+",");
                if(null != node.leftChild){
                    queue.add(node.leftChild);
                }
                if(null != node.rightChild){
                    queue.add(node.rightChild);
                }
            }
        }
    }

    public void delete(int value){
        if(null == root){
            return;
        }else{
            root.delete(root,value);
        }
    }


}
