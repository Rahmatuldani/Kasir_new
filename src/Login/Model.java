package Login;

import javax.swing.*;
import java.sql.*;

public class Model {
    Connection connection;
    ResultSet resultSet;
    Statement statement;

    public Object[] User = new Object[6];

    public Model(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/kasir","root","");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Database tidak ada","Error Database",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Driver SQL tidak diketahui","Error SQL",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public Object[] getUser(int id) {
        try{
            statement = connection.createStatement();
            System.out.println(id);
            resultSet = statement.executeQuery("SELECT * FROM user JOIN role ON user.role = role.id WHERE user.id = "+ id +"");

            while (resultSet.next()){
                User[0] = resultSet.getInt("user.id");
                User[1] = resultSet.getString("password");
                User[2] = resultSet.getString("user.name");
                User[3] = resultSet.getInt("user.role");
                User[4] = resultSet.getString("role.name");
            }
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Sintaks SQL salah","Error Statement",JOptionPane.ERROR_MESSAGE);
        }
        return User;
    }
}
