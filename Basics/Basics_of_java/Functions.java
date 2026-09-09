/**
 * Functions (Methods) in Java — Complete Reference
 *
 * A function (called a "method" in Java) is a reusable block of code.
 *
 * Syntax:
 *   returnType methodName(parameters) { body }
 *
 * Types covered here:
 *   1. No-arg, void
 *   2. With parameters, with return value
 *   3. Method overloading (same name, different params)
 *   4. Recursion
 *   5. Pass-by-value (Java always passes by value)
 *   6. Varargs (variable arguments)
 */
public class Functions {

    // ── 1. Void method (no return) ───────────────────────────────────
    static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // ── 2. Return value ──────────────────────────────────────────────
    static int square(int x) { return x * x; }
    static double area(double r) { return 3.14159 * r * r; }

    // ── 3. Method Overloading ────────────────────────────────────────
    // Same name, different parameter types/count → compiler picks the right one
    static int add(int a, int b)          { return a + b; }
    static double add(double a, double b) { return a + b; }
    static int add(int a, int b, int c)   { return a + b + c; }

    // ── 4. Recursion ─────────────────────────────────────────────────
    static int factorial(int n) {
        if (n <= 1) return 1;        // base case
        return n * factorial(n - 1); // recursive call
    }

    static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // ── 5. Pass-by-value demo ────────────────────────────────────────
    // Java passes a COPY of the value — original is unchanged
    static void tryToModify(int x) {
        x = 999; // only modifies local copy
    }

    // ── 6. Varargs (variable number of arguments) ────────────────────
    static int sum(int... nums) {
        int total = 0;
        for (int n : nums) total += n;
        return total;
    }

    // ── 7. Higher-order style: max of array ──────────────────────────
    static int max(int[] arr) {
        int m = arr[0];
        for (int x : arr) if (x > m) m = x;
        return m;
    }

    public static void main(String[] args) {

        // 1. Void
        greet("Ash");

        // 2. Return values
        System.out.println("square(7)   = " + square(7));
        System.out.println("area(3.0)   = " + area(3.0));

        // 3. Overloading
        System.out.println("\nadd(2, 3)         = " + add(2, 3));
        System.out.println("add(1.5, 2.5)     = " + add(1.5, 2.5));
        System.out.println("add(1, 2, 3)      = " + add(1, 2, 3));

        // 4. Recursion
        System.out.println("\nfactorial(5) = " + factorial(5));  // 120
        System.out.println("fibonacci(7) = " + fibonacci(7));   // 13

        // 5. Pass-by-value
        int val = 42;
        tryToModify(val);
        System.out.println("\nAfter tryToModify(42), val = " + val); // still 42

        // 6. Varargs
        System.out.println("\nsum(1,2,3)      = " + sum(1, 2, 3));
        System.out.println("sum(1,2,3,4,5)  = " + sum(1, 2, 3, 4, 5));

        // 7. Max
        int[] nums = {4, 2, 9, 1, 7};
        System.out.println("\nmax({4,2,9,1,7}) = " + max(nums));
    }
}
