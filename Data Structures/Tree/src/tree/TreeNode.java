package tree;

public class TreeNode {
    public int data;
    public TreeNode leftChild;
    public TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public void insert(int value){
        if(value < data){
            if(null == leftChild){
                leftChild = new TreeNode(value);
            }else{
                leftChild.insert(value);
            }
        }else{
            if(null == rightChild){
                rightChild = new TreeNode(value);
            }else{
                rightChild.insert(value);
            }
        }
    }

    public TreeNode findKey(int key){
        if(data == key){
            return this;
        }
        if(key < data){
            if(null != leftChild){
                return leftChild.findKey(key);
            }
        }else{
            if(null != rightChild){
                return rightChild.findKey(key);
            }
        }
        return null;
    }

    public int min(){
        if(null != leftChild){
            return leftChild.min();
        }else{
            return data;
        }
    }

    public int max(){
        if(null == rightChild){
            return data;
        }else{
            return rightChild.max();
        }
    }

    public int getHeight(TreeNode treeNode){
        if(null == treeNode){
            return 0;
        }

        int leftHeight = getHeight(treeNode.leftChild);
        int rightHeight = getHeight(treeNode.rightChild);

        return 1 + Math.max(leftHeight,rightHeight);
    }
}

