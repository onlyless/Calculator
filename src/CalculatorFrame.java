import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*计算器框架*/
public class CalculatorFrame {

    private JFrame frame;
    private JTextField number;
    private JPanel panel;
    private static String expression ="";  //输入的数据转划为字符串

    public CalculatorFrame(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);

        number = new JTextField();
        number.setEditable(false);
        frame.add(number,BorderLayout.NORTH);

        panel = new JPanel();
        panel.setLayout(new GridLayout(6,3));
        frame.add(panel,BorderLayout.CENTER);


        for(int i =1;i<10;i++){
            addButton(String.valueOf(i));
        }

        addButton("+");
        addButton("0");
        addButton("-");
        addButton("*");
        addButton("C");         //按钮C的作用是清空整个输入
        addButton("/");
        addButton("(");
        addButton(")");

        JButton equal = new JButton("=");
        equal.setActionCommand("=");
        equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                number.setText(""+new Calculate().calculating(expression)); //显示计算得到的结果
                expression = "";            //  计算后整个输入清空
            }
        });
        panel.add(equal);
        frame.add(panel);
        frame.setResizable(false);      //设置窗口大小不可改变
        frame.setVisible(true);
    }

    /*当不为输入不为“C”和“=”时，将输入转化为字符串,为“C”时清空输入*/
    private void addButton(String name ){
        JButton temp = new JButton(name);
        temp.setActionCommand(name);
        if(!"C".equals(name))
            temp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    expression += name;
                    number.setText(expression);
                }
            });
        else
            temp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    expression="";
                }
            });
        panel.add(temp);
    }
}