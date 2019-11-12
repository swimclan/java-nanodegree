import java.util.LinkedList;

public class StackQueueExample {

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*");
    }

    private static LinkedList<String> buildQueue(String str) {
        LinkedList<String> queue = new LinkedList<String>();
        String[] splitString = str.split("");
        String operand = "";
        String operator = null;
        for (String c : splitString) {
            if (!isOperator(c)) {
                operand += c;
            } else {
                operator = c;
                queue.add(operand);
                queue.add(operator);
                operand = "";
                operator = null;
            }
        }
        queue.add(operand);
        return queue;
    }

    public static int calculate(String s) {
        LinkedList<String> queue = buildQueue(s);
        int total = 0;
        String currentOperator = null;
        while(!queue.isEmpty()) {
            String frag = queue.poll();
            if (!isOperator(frag) && currentOperator == null) {
                total += Integer.parseInt(frag);
            } else if (isOperator(frag)) {
                currentOperator = frag;
            } else if (!isOperator(frag)) {
                if (currentOperator.equals("+")) {
                    total += Integer.parseInt(frag);
                } else if (currentOperator.equals("-")) {
                    total -= Integer.parseInt(frag);
                } else if (currentOperator.equals("*")) {
                    total *= Integer.parseInt(frag);
                }
                currentOperator = null;
            }
        }
        return total;

    }

    public static void main(String[] args) {
        System.out.println(calculate("2+1-3+4*2"));
    }
}
