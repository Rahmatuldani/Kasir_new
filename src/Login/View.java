package Login;

import javax.swing.*;

class View extends JFrame {
    JLabel lid = new JLabel("ID");
    JLabel lpass = new JLabel("Password");

    JTextField fid = new JTextField(20);
    JPasswordField fpass = new JPasswordField(20);

    JButton login = new JButton("Login");

    public View(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(340,200);
        setLocationRelativeTo(null);
        setTitle("Login");
        setLayout(null);

        add(lid);
        add(fid);
        add(lpass);
        add(fpass);
        add(login);

        lid.setBounds(20,20,80,30);
        fid.setBounds(120,20,180,30);
        lpass.setBounds(20,60,80,30);
        fpass.setBounds(120,60,180,30);
        login.setBounds(200,110,100,30);
    }
}
