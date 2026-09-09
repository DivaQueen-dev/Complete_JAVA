/**
 * Strings in Java — Complete Reference
 *
 * String is immutable in Java — every operation creates a NEW String.
 * For heavy mutation, use StringBuilder (mutable, not thread-safe)
 * or StringBuffer (mutable, thread-safe).
 *
 * Key concepts:
 *   1. String creation & immutability
 *   2. Common String methods
 *   3. String comparison (== vs .equals())
 *   4. String to char array & back
 *   5. StringBuilder for efficient concatenation
 */
public class Strings {

    public static void main(String[] args) {

        // ── 1. Creation ──────────────────────────────────────────────
        String s1 = "Hello";              // string literal (stored in pool)
        String s2 = new String("Hello");  // new object on heap
        String s3 = "DSA";

        System.out.println("s1 = " + s1);
        System.out.println("s3 = " + s3);

        // ── 2. Comparison: == vs .equals() ──────────────────────────
        String a = "Java";
        String b = "Java";
        String c = new String("Java");

        System.out.println("\na == b       : " + (a == b));       // true (same pool ref)
        System.out.println("a == c       : " + (a == c));       // false (diff object)
        System.out.println("a.equals(c)  : " + a.equals(c));   // true (same content)
        System.out.println("equalsIgnoreCase: " + "java".equalsIgnoreCase("JAVA")); // true

        // ── 3. Common Methods ────────────────────────────────────────
        String str = "  Hello, World!  ";

        System.out.println("\nOriginal       : '" + str + "'");
        System.out.println("trim()         : '" + str.trim() + "'");
        System.out.println("length()       : " + str.trim().length());
        System.out.println("toLowerCase()  : " + str.trim().toLowerCase());
        System.out.println("toUpperCase()  : " + str.trim().toUpperCase());
        System.out.println("charAt(7)      : " + str.trim().charAt(7));
        System.out.println("indexOf('o')   : " + str.trim().indexOf('o'));
        System.out.println("lastIndexOf('o'): " + str.trim().lastIndexOf('o'));
        System.out.println("substring(7)   : " + str.trim().substring(7));
        System.out.println("substring(0,5) : " + str.trim().substring(0, 5));
        System.out.println("replace(l,L)   : " + str.trim().replace('l', 'L'));
        System.out.println("contains('World'): " + str.trim().contains("World"));
        System.out.println("startsWith('Hello'): " + str.trim().startsWith("Hello"));
        System.out.println("endsWith('!')  : " + str.trim().endsWith("!"));

        // ── 4. Split & Join ──────────────────────────────────────────
        String csv = "apple,banana,cherry";
        String[] fruits = csv.split(",");
        System.out.println("\nSplit result:");
        for (String f : fruits) System.out.println("  " + f);

        String joined = String.join(" | ", fruits);
        System.out.println("Joined: " + joined);

        // ── 5. char array conversion ─────────────────────────────────
        String word = "reverse";
        char[] chars = word.toCharArray();

        // Reverse manually
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        System.out.println("\nReversed '" + word + "' = " + new String(chars));

        // ── 6. StringBuilder — efficient mutation ─────────────────────
        StringBuilder sb = new StringBuilder();
        sb.append("Java");
        sb.append(" is");
        sb.append(" awesome");
        sb.insert(4, ",");       // insert at index 4
        sb.reverse();
        System.out.println("\nStringBuilder result: " + sb.toString());

        // ── 7. String.valueOf — type conversions ─────────────────────
        int num = 42;
        String fromInt = String.valueOf(num);
        int backToInt = Integer.parseInt(fromInt);
        System.out.println("\nString.valueOf(42)       = " + fromInt);
        System.out.println("Integer.parseInt(\"42\")   = " + backToInt);

        // ── 8. Palindrome check ──────────────────────────────────────
        String test = "racecar";
        String rev = new StringBuilder(test).reverse().toString();
        System.out.println("\n'" + test + "' is palindrome? " + test.equals(rev));
    }
}
