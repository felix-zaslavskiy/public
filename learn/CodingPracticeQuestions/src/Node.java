public class Node {

    Node next;
    Node prev;

    int value;

    public Node add(int value) {
        this.next = new Node(value);
        this.next.prev = this;
        return next;
    }

    public Node(int value ) {
        this.value = value;
    }

    Node getNext(){
        return next;
    }

    Node getPrev() {
        return prev;
    }

    int getValue() {
        return value;
    }

    void setNext(Node next) {
        this.next = next;
    }

    void setPrev(Node prev) {
        this.prev = prev;
    }

    public String toString() {
        String result = "" + value;

        Node nextNode = next;
        while(nextNode != null){
            result += "->" + nextNode.value;
            nextNode = nextNode.getNext();
        }
        return result;
    }
}
