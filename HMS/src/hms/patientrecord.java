
package hms;

public class patientrecord {
    private String id ;
    private String name;
    private String fname;
    private String gender;
    private String age;
    private String pnum;
    private String db;
    private String advisor;
    private String die;
    private String dis;

    public patientrecord(String id, String name, String fname, String gender, String age, String pnum, String db, String advisor, String die, String dis) {
        this.id = id;
        this.name = name;
        this.fname = fname;
        this.gender = gender;
        this.age = age;
        this.pnum = pnum;
        this.db = db;
        this.advisor = advisor;
        this.die = die;
        this.dis = dis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getAdvisor() {
        return advisor;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    public String getDie() {
        return die;
    }

    public void setDie(String die) {
        this.die = die;
    }

    public String getDis() {
        return dis;
    }

    public void setDis(String dis) {
        this.dis = dis;
    }
    
    
   
}
