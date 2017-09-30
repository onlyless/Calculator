import java.util.Stack;

/*��ȡһ���ַ�����Ȼ��������ջ�м�����ʽ��ֵ,���������жϣ��������ȼ�*/
public class Calculate {
    private static Stack<String> ops = new Stack<>();   //����ջ
    private static Stack<Double> nums = new Stack<>();  //����ջ

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
        return nums.pop();      //���ؽ��
    }
}
