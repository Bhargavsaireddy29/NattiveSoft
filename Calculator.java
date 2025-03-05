import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calc implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] nb = new JButton[10];
    JButton[] fb = new JButton[8];
    JPanel panel;
    JButton add, sub, mul, div, dec, del, clr, eql;
    Font myFont = new Font("Ink Free", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calc() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        frame.add(textfield);

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        dec = new JButton(".");
        eql = new JButton("=");
        clr = new JButton("CLR");
        del = new JButton("DEL");

        fb[0] = add;
        fb[1] = sub;
        fb[2] = mul;
        fb[3] = div;
        fb[4] = dec;
        fb[5] = eql;
        fb[6] = clr;
        fb[7] = del;

        for (int i = 0; i < 8; i++) {
            fb[i].addActionListener(this);
            fb[i].setFont(myFont);
            fb[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            nb[i] = new JButton(String.valueOf(i));
            nb[i].addActionListener(this);
            nb[i].setFont(myFont);
            nb[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Adding buttons to panel
        panel.add(nb[1]);
        panel.add(nb[2]);
        panel.add(nb[3]);
        panel.add(add);
        panel.add(nb[4]);
        panel.add(nb[5]);
        panel.add(nb[6]);
        panel.add(sub);
        panel.add(nb[7]);
        panel.add(nb[8]);
        panel.add(nb[9]);
        panel.add(mul);
        panel.add(dec);
        panel.add(nb[0]);
        panel.add(eql);
        panel.add(div);

        del.setBounds(150, 430, 100, 50);
        clr.setBounds(250, 430, 100, 50);

        frame.add(panel);
        frame.add(del);
        frame.add(clr);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calc();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == nb[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == dec) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == add) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == sub) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == mul) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource() == div) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if (e.getSource() == eql) {
            num2 = Double.parseDouble(textfield.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clr) {
            textfield.setText("");
        }
        if (e.getSource() == del) {
            String string = textfield.getText();
            if (!string.isEmpty()) {
                textfield.setText(string.substring(0, string.length() - 1));
            }
        }
    }
}
