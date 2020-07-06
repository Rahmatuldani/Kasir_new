package Login;

import java.awt.event.*;
import Kasir.*;
import javax.swing.*;

public class Controller {
    View view = new View();
    Model model = new Model();
    Object [] User = new Object[6];

    void errorMessage(String message){
        JOptionPane.showMessageDialog(null,message,"Error Validation",JOptionPane.ERROR_MESSAGE);
    }

    public Controller(){
        view.setVisible(true);

        view.login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (view.fid.getText().equals("")){
                    errorMessage("ID harus berisi!");
                } else if (view.fpass.getText().equals("")){
                    errorMessage("Password harus berisi!");
                } else {
//                    try {
                        int id = Integer.parseInt(view.fid.getText());
                        String pass = view.fpass.getText();

                        User = model.getUser(id);

                        if (User[0] == null) {
                            errorMessage("ID tidak terdaftar!");
                        } else if (User[1].equals(pass)) {
                            JOptionPane.showMessageDialog(null, "Login berhasil", "Done", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            errorMessage("Password salah!");
                        }
//                    }catch (NumberFormatException e){
//                        errorMessage("ID harus berupa angka");
//                    }
                }
            }
        });
    }
}
