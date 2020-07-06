package Kasir;

import com.mysql.jdbc.NotUpdatable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    View view;
    Model model = new Model();

    Object [] Barang = new Object[6];

    public Controller(){
//        this.User = User;
        view = new View("Cashier","Rahmatul Ramadhani");
        view.setVisible(true);

        view.fno.setText(String.valueOf(model.getTransaksi()+1));

        view.search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (view.fcari.getText().equals("")){
                    errorMessage("Kode barang harus diisi!");
                } else {
                    try {
                        long id = Long.parseLong(view.fcari.getText());

                        Barang = model.getSearchBarang(id);
                        if (Barang[0] == null) {
                            errorMessage("Barang tidak ada!");
                        } else {
                            new checkQty();
                        }
                    } catch (NumberFormatException | NullPointerException e){
                        errorMessage(e.getMessage());
                    }
                }
            }
        });
    }

    void errorMessage(String message){
        JOptionPane.showMessageDialog(null,message,"Error",JOptionPane.ERROR_MESSAGE);
    }
}
