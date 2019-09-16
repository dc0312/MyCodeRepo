package tree;

public class Tree {
    public TreeNode root;

    public void insert(int value){
        if(null == root){
            root = new TreeNode(value);
        }else{
            root.insert(value);
        }
    }

    public void inOrder(TreeNode root){
        if(null != root){
            inOrder(root.leftChild);
            System.out.print(root.data+",");
            inOrder(root.rightChild);
        }
    }

    public TreeNode find(int key) {
        if (null != root) {
            return root.findKey(key);
        }
        return null;
    }

    public int min(){
        if(null != root){
            return root.min();
        }else{
            return -1;
        }
    }

    public int max(){
        if(null != root){
            return root.max();
        }else{
            return -1;
        }
    }

    public int getHeight(){
        if(null != root){
            return root.getHeight(root);
        }else{
            return -1;
        }
    }

    public void delete(int dd){
        root =  delete(root,dd);
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
            if(subTreeRoot.leftChild == null){
                return subTreeRoot.rightChild;
            }else if(subTreeRoot.rightChild == null){
                return subTreeRoot.leftChild;
            }
        }
        return subTreeRoot;
    }
}
