/**
 * ZigZag Linked List Rearrangement
 *
 * Given a linked list, rearrange it in-place so that:
 *   node1 < node2 > node3 < node4 > node5 ...
 *
 * Example:
 *   Input  → 1 → 4 → 2 → 8 → 5 → 3
 *   Output → 1 → 4 → 2 → 8 → 3 → 5  (one valid zigzag)
 *
 * Approach: One-pass flag flip
 *   - Keep a boolean 'less' flag alternating between < and >
 *   - If current pair violates the pattern, swap their data
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(1)
 */

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ZIgZagLL {

    // ── Build list from array ────────────────────────────────────────
    static Node buildList(int[] arr) {
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // ── Print list ───────────────────────────────────────────────────
    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) System.out.print(" → ");
            curr = curr.next;
        }
        System.out.println();
    }

    // ── Core: ZigZag rearrangement ───────────────────────────────────
    // Alternating flag:
    //   less = true  → current node should be LESS than next  (a < b)
    //   less = false → current node should be GREATER than next (a > b)
    static Node zigzag(Node head) {
        if (head == null || head.next == null) return head;

        Node curr = head;
        boolean less = true; // first pair: we want curr < curr.next

        while (curr != null && curr.next != null) {
            if (less) {
                // We want curr < curr.next; swap if violated
                if (curr.data > curr.next.data) {
                    int temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
            } else {
                // We want curr > curr.next; swap if violated
                if (curr.data < curr.next.data) {
                    int temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
            }
            less = !less;       // flip flag for next pair
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // Test 1
        int[] arr1 = {1, 4, 2, 8, 5, 3};
        Node head1 = buildList(arr1);
        System.out.print("Input  : "); printList(head1);
        head1 = zigzag(head1);
        System.out.print("Output : "); printList(head1);
        // Expected pattern: small > big < small > big ...

        System.out.println();

        // Test 2
        int[] arr2 = {3, 5, 2, 1, 6, 4, 8};
        Node head2 = buildList(arr2);
        System.out.print("Input  : "); printList(head2);
        head2 = zigzag(head2);
        System.out.print("Output : "); printList(head2);

        System.out.println();

        // Test 3: Already in zigzag
        int[] arr3 = {1, 3, 2, 5, 4};
        Node head3 = buildList(arr3);
        System.out.print("Input  : "); printList(head3);
        head3 = zigzag(head3);
        System.out.print("Output : "); printList(head3);
    }
}
