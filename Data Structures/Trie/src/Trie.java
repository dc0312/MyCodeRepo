public class Trie {
    private Node root;

    public Trie() {
        this.root = new Node("");
    }

    public void insert(String key){
        Node tempNode = root;
        for(int i =0;i<key.length();i++){
            char c = key.charAt(i);
            int asciiIndex = c - 'a';
            if(tempNode.getChild(asciiIndex) == null){
                Node newNode = new Node(String.valueOf(c));
                tempNode.setChild(asciiIndex,newNode);
                tempNode = newNode;
            }else{
                tempNode = tempNode.getChild(asciiIndex);
            }
        }
        tempNode.setLeaf(true);

    }

    public boolean search(String key){
        Node tempNode = root;
        for(int i =0; i < key.length() ; i++){
            char c = key.charAt(i);
            int asciiIndex = c-'a';
            if(tempNode.getChild(asciiIndex) == null){
                return false;
            }else{
                tempNode = tempNode.getChild(asciiIndex);
            }
        }
        return true;

    }
}
