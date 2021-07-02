
package hms;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FXMLController implements Initializable {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confarmpassword;

    @FXML
    private TextField usertype;

    @FXML
    private TextField age;

    @FXML
    private TextField phonenumber;

    @FXML
    private TextField gender;

    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    @FXML
    private void handlecreateAction(ActionEvent event) throws SQLException{
       String uname=username.getText();
       String  pass=password.getText();
       String compass=confarmpassword.getText();
       String usertyp=usertype.getText();
       String Age=age.getText();
       String pnum=phonenumber.getText();
       String gen=gender.getText();
       
        try {  
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
            String sql="Insert into signup values(?,?,?,?,?,?,?)";
            pst=con.prepareStatement(sql);
            pst.setString(1,uname);
            pst.setString(2,pass);
            pst.setString(3,compass);
            pst.setString(4,usertyp);
            pst.setString(5,gen);
            pst.setString(6,Age);
            pst.setString(7,pnum);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Account Create Successful");
            username.setText("");
            password.setText("");
            confarmpassword.setText("");
            usertype.setText("");
            age.setText("");
            phonenumber.setText("");
            gender.setText("");
            con.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
               
    }
    
    
    @FXML
    private void handlesininAction(ActionEvent event) throws IOException{
        Parent obj = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
                Scene scene = new Scene(obj);
                Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene);
                app_stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    
}
