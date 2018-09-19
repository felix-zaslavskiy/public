import base.Question;

public class LinkedList1_RemoveDuplicates implements Question {
    @Override
    public void run() {

        // Simple O(N^2) implementation.
        // Two pointers.. with one pointer searching ahead.
        // Book had somewhat simplified solution
        Node head = new Node(1);
        Node next  = head.add(1);
        next  = next.add(1);
        next = next.add(2);

        System.out.println(head);

        Node follow = head;
        Node ahead = head.getNext();

        while(follow != null) {

            while(ahead != null) {
                if(follow != ahead && follow.getValue() == ahead.getValue()) {
                    // Remove the node pointed to by ahead.

                    Node prev = ahead.getPrev();
                    Node nxt = ahead.getNext();

                    prev.setNext(nxt);
                    if(nxt != null ) nxt.setPrev(prev);

                    ahead = nxt;
                    continue;
                }

                ahead  = ahead.getNext();
            }

            follow  = follow.getNext();
            if(follow != null)
                ahead = follow.getNext();
        }
        System.out.println(head);

    }
}
