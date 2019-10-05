public class App {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("deepak");
        trie.insert("deep");

        System.out.println(trie.search("eepa"));
    }
}
