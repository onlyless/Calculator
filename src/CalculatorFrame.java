import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*���������*/
public class CalculatorFrame {

    private JFrame frame;
    private JTextField number;
    private JPanel panel;
    private static String expression ="";  //���������ת��Ϊ�ַ���

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
        addButton("C");         //��ťC�������������������
        addButton("/");
        addButton("(");
        addButton(")");

        JButton equal = new JButton("=");
        equal.setActionCommand("=");
        equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                number.setText(""+new Calculate().calculating(expression)); //��ʾ����õ��Ľ��
                expression = "";            //  ����������������
            }
        });
        panel.add(equal);
        frame.add(panel);
        frame.setResizable(false);      //���ô��ڴ�С���ɸı�
        frame.setVisible(true);
    }

    /*����Ϊ���벻Ϊ��C���͡�=��ʱ��������ת��Ϊ�ַ���,Ϊ��C��ʱ�������*/
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