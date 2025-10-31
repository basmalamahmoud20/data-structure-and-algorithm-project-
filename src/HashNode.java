public class HashNode {
    Node node;
    boolean occupiedBefore;

    public HashNode(int value) {
        this.node = new Node(value);
        this.occupiedBefore = true;
    }
}
