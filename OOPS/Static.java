/**
 * Static Keyword in Java — Complete Reference
 *
 * 'static' means the member belongs to the CLASS, not to any instance.
 * You can access it without creating an object.
 *
 * Use cases:
 *   1. Static variables   → shared across all objects (class-level data)
 *   2. Static methods     → utility methods that don't need 'this'
 *   3. Static blocks      → run once when class is first loaded
 *   4. Static inner class → inner class that doesn't need outer class instance
 */
public class Static {

    // ── 1. Static Variable ───────────────────────────────────────────
    // Shared by ALL instances. One copy in memory.
    static int instanceCount = 0;
    int id;

    Static() {
        instanceCount++;    // every new object increments the shared counter
        id = instanceCount;
    }

    // ── 2. Static Method ────────────────────────────────────────────
    // Can be called without an object: Static.greet()
    // Cannot access non-static (instance) fields/methods directly.
    static void greet() {
        System.out.println("Hello from a static method!");
        System.out.println("Total objects created so far: " + instanceCount);
    }

    // ── 3. Static Block ─────────────────────────────────────────────
    // Runs ONCE when the class is loaded by the JVM — before main()
    static {
        System.out.println("Static block executed — class loaded!");
        instanceCount = 0; // reset just for clarity
    }

    // ── 4. Static Nested Class ──────────────────────────────────────
    // Does not need an instance of Static to be created.
    static class MathUtils {
        static int square(int n) { return n * n; }
        static int cube(int n)   { return n * n * n; }
    }

    // ── 5. Static Constants ─────────────────────────────────────────
    // Convention: ALL_CAPS. Declared static final.
    static final double PI = 3.14159265358979;
    static final String APP_NAME = "Java DSA";

    // ── Main ─────────────────────────────────────────────────────────
    public static void main(String[] args) {

        // 3 objects created — all share instanceCount
        Static obj1 = new Static();
        Static obj2 = new Static();
        Static obj3 = new Static();

        System.out.println("obj1.id = " + obj1.id);   // 1
        System.out.println("obj2.id = " + obj2.id);   // 2
        System.out.println("obj3.id = " + obj3.id);   // 3
        System.out.println("Shared instanceCount = " + Static.instanceCount); // 3

        // Call static method — no object needed
        greet();

        // Static nested class — no outer class instance needed
        System.out.println("\nMathUtils.square(5) = " + MathUtils.square(5));
        System.out.println("MathUtils.cube(3)   = " + MathUtils.cube(3));

        // Static constants
        System.out.println("\nPI = " + PI);
        System.out.println("APP_NAME = " + APP_NAME);

        // KEY INSIGHT: static field accessed via class name (not object)
        System.out.println("\nAccessing via class name: Static.instanceCount = " + Static.instanceCount);
    }
}
