package com.dc.data.structures.tree;

public class TreeNode {
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public void insert(int value){

        if (value < data) {
            if(leftChild == null){
                leftChild = new TreeNode(value);
            }else{
                leftChild.insert(value);
            }
        }else{
            if(rightChild == null){
                rightChild = new TreeNode(value);
            }else{
                rightChild.insert(value);
            }
        }
    }

    public TreeNode get(int value){
        if(data == value){
            return this;
        }
        if(value<data){
            if(leftChild != null){
                return leftChild.get(value);
            }
        }else{
            if(rightChild != null){
                return rightChild.get(value);
            }
        }
        return null;
    }

    public int min(){
        if(leftChild ==null){
            return data;
        }else{
            return leftChild.min();
        }
    }

    public int max(){
        if(rightChild == null){
            return data;
        }else{
            return rightChild.max();
        }
    }

    public int getHeight(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        int leftHeight = getHeight(treeNode.leftChild);
        int rightHeight = getHeight(treeNode.rightChild);

        return 1+ Math.max(leftHeight,rightHeight);
    }

    public int getDiameter(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }

        int leftHeight = getHeight(treeNode.leftChild);
        int rightHeight = getHeight(treeNode.rightChild);

        int option1 = leftHeight +rightHeight;

        int option2 = getDiameter(treeNode.leftChild);
        int option3 = getDiameter(treeNode.rightChild);

        return Math.max(option1,Math.max(option2,option3));
    }

    public Pair<Integer,Integer> getHeightDiameter(TreeNode treeNode){
        if(treeNode == null){
            Pair<Integer,Integer> pair = new Pair<>();
            pair.first =0;
            pair.second =0;
            return pair;
        }
        Pair<Integer,Integer> lo = getHeightDiameter(treeNode.leftChild);
        Pair<Integer,Integer> ro = getHeightDiameter(treeNode.rightChild);
        int height = 1 + Math.max(lo.first,ro.first);
        int option1 = lo.first +ro.first;
        int option2 = lo.second;
        int option3 = ro.second;
        int diameter = Math.max(option1,Math.max(option2,option3));
        Pair<Integer,Integer> output = new Pair<>();
        output.first = height;
        output.second = diameter;
        return output;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}
