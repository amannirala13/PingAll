/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingall;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;

/**
 *
 * @author hp
 */
public class LoginController extends Pingall implements Initializable {
    
    @FXML
    private JFXTextField userid;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private Hyperlink Invalid_login;

    @FXML
    private JFXButton close_btn;


    
    
    @FXML
    private void loginBtnPressed(ActionEvent event) throws IOException, Exception {
        if(checkLogin())
        {
            setDashboard();
        
        }
        
        else
        {
                Invalid_login.setText("Invalid login !");
                }
    
    }
    @FXML
    private void close_btnPressed(ActionEvent event)
    {
        System.exit(0);
    }
    
    private boolean checkLogin() throws SQLException, Exception
    {
        boolean auth = false;
          try{ Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts","root","Amannirala_1361"); 
            try (Statement statement = connect.createStatement(); ResultSet result = statement.executeQuery("select * from users")) {
                while(result.next())
                {
                   if((result.getString("userID")).equalsIgnoreCase(userid.getText()))
                    {
                        auth = result.getString("password").equalsIgnoreCase(password.getText());
                    }
                }
            }
}
          catch(SQLException e)
          {
           System.out.println(e);
          }
        return auth;
   
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
