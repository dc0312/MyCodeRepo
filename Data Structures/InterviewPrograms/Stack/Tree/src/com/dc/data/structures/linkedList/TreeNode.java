package com.dc.data.structures.linkedList;

public class TreeNode {
    public int data;
    public TreeNode leftChild;
    public TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data ->"+data;
    }

    public void insert(int dd){
        if(dd < data){
            if(null == leftChild){
                leftChild = new TreeNode(dd);
            }else{
                leftChild.insert(dd);
            }
        }else{
            if(null == rightChild){
                rightChild = new TreeNode(dd);
            }else{
                rightChild.insert(dd);
            }
        }
    }

    public void inOrderTraversal(TreeNode root){
        if(root != null){
            inOrderTraversal(root.leftChild);
            System.out.print(root.data+",");
            inOrderTraversal(root.rightChild);
        }
    }

    public TreeNode get(int value){
        if(value == data){
            return this;
        }
        if(value < data){
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

    public TreeNode max(){
        if(rightChild == null){
            return this;
        }else{
            return rightChild.max();
        }
    }

    public TreeNode min(){
        if(leftChild == null){
            return this;
        }else{
            return leftChild.min();
        }
    }

    public int getHeight(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        int leftChild = getHeight(treeNode.leftChild);
        int rightChild = getHeight(treeNode.rightChild);
        return 1+ Math.max(leftChild,rightChild);
    }

    public int getDiameter(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        int leftHeight = getHeight(treeNode.leftChild);
        int righHeight = getHeight(treeNode.rightChild);

        int option1 = leftHeight +righHeight;
        int option2 = getDiameter(treeNode.rightChild);
        int option3 = getDiameter(treeNode.leftChild);

        return Math.max(option1, Math.max(option2,option3));
    }

    public TreeNode delete(TreeNode subTreeRoot, int value){
        if(null == subTreeRoot){
            return subTreeRoot;
        }

        if(value < subTreeRoot.data){
            subTreeRoot.leftChild = delete(subTreeRoot.leftChild,value);
        }else if(value > subTreeRoot.data){
            subTreeRoot.rightChild = delete(subTreeRoot.rightChild,value);
        }else{
            if(null == subTreeRoot.leftChild){
                return subTreeRoot.rightChild;
            }else if(null == subTreeRoot.rightChild){
                return subTreeRoot.leftChild;
            }

            subTreeRoot.data = subTreeRoot.rightChild.min().data;
            subTreeRoot.rightChild = delete(subTreeRoot.rightChild,subTreeRoot.data);
            return null;
        }
        return subTreeRoot;
    }
}
