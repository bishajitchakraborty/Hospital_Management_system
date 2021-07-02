
package hms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ReceptionController implements Initializable {
  
  
    
    @FXML
    void handlenewpatientAction(ActionEvent event) throws IOException{
        Parent obj = FXMLLoader.load(getClass().getResource("PatientFrom.fxml"));
                Scene scene = new Scene(obj);
                Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene);
                app_stage.show();
    }
    @FXML
    void handlepatientupdateAction(ActionEvent event) throws IOException{
               Parent obj = FXMLLoader.load(getClass().getResource("patientrecord.fxml"));
                Scene scene = new Scene(obj);
                Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene);
                app_stage.show();
    }
    @FXML
    void handleAppointmentAction(ActionEvent event) throws IOException{
        Parent obj = FXMLLoader.load(getClass().getResource("PatientAppoint.fxml"));
        Scene scene = new Scene(obj);
        Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }
    @FXML
    void handlehomepageAction(ActionEvent event) throws IOException{
        Parent obj = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
                Scene scene = new Scene(obj);
                Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene);
                app_stage.show();
    }
    @FXML
    public void handletestAction(ActionEvent event) throws IOException{
         Parent obj = FXMLLoader.load(getClass().getResource("testslist.fxml"));
        
                Scene scene = new Scene(obj);
                Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene);
                app_stage.show();
    }
    @FXML
    void handlesignoutAction(ActionEvent event) throws IOException{
        Parent obj = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
                Scene scene = new Scene(obj);
                Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene);
                app_stage.show();
    }
    
     @FXML
    void handledddoctorAction(ActionEvent event) throws IOException{
        Parent obj = FXMLLoader.load(getClass().getResource("adddoctor.fxml"));
        
                Scene scene = new Scene(obj);
                Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene);
                app_stage.show();
    }
    
     @FXML
    void hospitalAction(ActionEvent event) throws IOException{
        Parent obj = FXMLLoader.load(getClass().getResource("Hospital_Information.fxml"));
        
                Scene scene = new Scene(obj);
                Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene);
                app_stage.show();
    }
    @FXML
    public void handlesecurityAction(ActionEvent event) throws IOException{
                Parent obj = FXMLLoader.load(getClass().getResource("securitysystem.fxml"));
                Scene scene = new Scene(obj);
                Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene);
                app_stage.show();
    }
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    } 
    
    
    
 }


      
    

