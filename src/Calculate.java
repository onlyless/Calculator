import java.util.Stack;

/*读取一个字符串，然后在两个栈中计算表达式的值,这样可以判断（）的优先级*/
public class Calculate {
    private static Stack<String> ops = new Stack<>();   //操作栈
    private static Stack<Double> nums = new Stack<>();  //数据栈

    private static void calculate() {
        String op = ops.pop();
        if (op.equals("+"))
            nums.push(nums.pop() + nums.pop());
        else if (op.equals("-"))
            nums.push(nums.pop() - nums.pop());
        else if (op.equals("*"))
            nums.push(nums.pop() * nums.pop());
        else if (op.equals("/"))
            nums.push(nums.pop() / nums.pop());
    }

    public double calculating(String s){
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    break;
                case '+':
                    ops.push("+");
                    break;
                case '-':
                    ops.push("-");
                    break;
                case '*':
                    ops.push("*");
                    break;
                case '/':
                    ops.push("/");
                    break;
                case ')': {
                    calculate();
                    break;
                }
                default:
                    nums.push(Double.parseDouble(s.charAt(i) + ""));
                    break;
            }
        }
        while (!ops.empty()) {
            calculate();
        }
        return nums.pop();      //返回结果
    }
}
