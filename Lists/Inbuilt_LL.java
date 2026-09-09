import java.util.LinkedList;

/**
 * Inbuilt_LL — Java's java.util.LinkedList
 *
 * Java's LinkedList is a doubly-linked list that also implements
 * Deque, so it can be used as a Stack, Queue, or LL in one.
 *
 * Time Complexity:
 *   add/addFirst/addLast  → O(1)
 *   get(index)            → O(n)
 *   remove(index)         → O(n)
 *   contains()            → O(n)
 */
public class Inbuilt_LL {
    public static void main(String[] args) {

        LinkedList<Integer> ll = new LinkedList<>();

        // ── Adding elements ──────────────────────────────────────────
        ll.add(10);           // adds to tail
        ll.add(20);
        ll.add(30);
        ll.addFirst(5);       // adds to head  → [5, 10, 20, 30]
        ll.addLast(40);       // adds to tail  → [5, 10, 20, 30, 40]
        ll.add(2, 15);        // inserts at index 2 → [5, 10, 15, 20, 30, 40]

        System.out.println("List after adding: " + ll);

        // ── Accessing elements ───────────────────────────────────────
        System.out.println("First element : " + ll.getFirst());
        System.out.println("Last element  : " + ll.getLast());
        System.out.println("Element at [2]: " + ll.get(2));

        // ── Removing elements ────────────────────────────────────────
        ll.removeFirst();            // removes head
        ll.removeLast();             // removes tail
        ll.remove(Integer.valueOf(15)); // removes first occurrence of 15

        System.out.println("List after removing: " + ll);

        // ── Useful utilities ─────────────────────────────────────────
        System.out.println("Size    : " + ll.size());
        System.out.println("Contains 20? : " + ll.contains(20));
        System.out.println("Index of 20  : " + ll.indexOf(20));

        // ── Iterating ────────────────────────────────────────────────
        System.out.print("Forward : ");
        for (int x : ll) System.out.print(x + " ");
        System.out.println();

        // ── Using as a Deque (double-ended queue) ────────────────────
        LinkedList<String> deque = new LinkedList<>();
        deque.push("A");    // push to front (like Stack)
        deque.push("B");
        deque.push("C");
        System.out.println("Deque (stack order): " + deque);
        System.out.println("Pop: " + deque.pop());  // removes from front
        System.out.println("Peek: " + deque.peek()); // views front without removal

        // ── Using as a Queue ─────────────────────────────────────────
        LinkedList<String> queue = new LinkedList<>();
        queue.offer("first");   // enqueue
        queue.offer("second");
        queue.offer("third");
        System.out.println("\nQueue: " + queue);
        System.out.println("Poll (dequeue): " + queue.poll());
        System.out.println("Queue after poll: " + queue);

        // ── Clear ────────────────────────────────────────────────────
        ll.clear();
        System.out.println("\nAfter clear, isEmpty? " + ll.isEmpty());
    }
}
