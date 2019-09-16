package tree;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);
        tree.insert(12);

        tree.inOrder(tree.root);

        System.out.println();

        System.out.println(tree.find(12).data);

        System.out.println(tree.min());
        System.out.println(tree.max());

        System.out.println(tree.getHeight());

        tree.delete(12);

        tree.inOrder(tree.root);
    }

}
