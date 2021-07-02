
package hms;
import java.io.IOException;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
//import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
public class FXMLDocumentController implements Initializable {
   
    
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    //@FXML
   // private TextField usertype;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    @FXML
    private void handlesigninAction(ActionEvent event) {
        String user=username.getText();
        String pass=password.getText();
        
        if(user.equals("") && pass.equals("")){
            JOptionPane.showMessageDialog(null,"Usernumber and Password Blank");
        }
        else if(user.equals("")){
           JOptionPane.showMessageDialog(null,"Please Enter your Username"); 
        }
        else if(pass.equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Your Password");
        }
        else
        {
            try{
               Class.forName("com.mysql.jdbc.Driver");  
               con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
               String sql="select * from signup where username=? and Password=?";
               pst=con.prepareStatement(sql);
               pst.setString(1, user);
               pst.setString(2, pass);
               rs=pst.executeQuery();
               
               if(rs.next()){
                   JOptionPane.showMessageDialog(null,"Log In Successful");
                 Parent obj = FXMLLoader.load(getClass().getResource("Reception.fxml"));
        
                Scene scene = new Scene(obj);
                Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene);
                app_stage.show();
               }
               else
               {
                 JOptionPane.showMessageDialog(null,"Username and Password and usertype Not Match");
                 username.setText("");
                 password.setText("");
             
                 
               }
               
            }catch(Exception e){
                
            }
        }
    }
    
     @FXML
    private void handlesignupAction(ActionEvent event) throws IOException {
        
         Parent obj = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        
                Scene scene = new Scene(obj);
                Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene);
                app_stage.show();
      
    }
     @FXML
    private void handlecancelAction(ActionEvent event) {
      Platform.exit();
       
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
