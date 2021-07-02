                 
package hms;

public class adddoctor {
    private String license_No ;
    private String name;
    private String specilization;
    private String qualification;
    private String room_no;

    public adddoctor(String license_No, String name, String specilization, String qualification, String room_no) {
        this.license_No = license_No;
        this.name = name;
        this.specilization = specilization;
        this.qualification = qualification;
        this.room_no = room_no;
    }

   // adddoctor(String id, String Name, String Spe, String Room) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    
    public String getLicense_No() {
        return license_No;
    }

    public String getName() {
        return name;
    }

    public String getSpecilization() {
        return specilization;
    }

    public String getQualification() {
        return qualification;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setLicense_No(String license_No) {
        this.license_No = license_No;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecilization(String specilization) {
        this.specilization = specilization;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }
    
   
    
}
