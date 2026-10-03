
public class SyntaxChecker {
    public static boolean isBalanced(String line) {
        Stack<String> buffer = new ArrayStack<>(line.length());

        for (int i = 0; i < line.length(); i++) {
            String symbol = line.substring(i, i + 1);

            if (symbol.equals("(") || symbol.equals("[") || symbol.equals("{")) {
                buffer.push(symbol);
            }
            else if (symbol.equals (")") || symbol.equals("]") || symbol.equals("}")) {
                if (buffer.isEmpty()) {
                    return false;
                }
                String open = buffer.pop();
                
                if (symbol.equals(")") && !open.equals("(")) {
                    return false;
                }
                if (symbol.equals("]") && !open.equals("[")) {
                    return false;
                }
                if (symbol.equals("}") && !open.equals("{")) {
                    return false;
                }
            }
        }
        return buffer.isEmpty();
    }
    public static void main(String[] args) {
        String line1 = "public static void main(String[] args) {...}";
        String line2 = "int x = (5 + [a * 2]);";
        String line3 = "System.out.println(\"Hello\");";
        String line4 = "List list =new ArrayList<String>();";
        String line5 = "if (x > 0) {";

        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));

    }
}