
package hms;

public class test {
    private String testtype;
    private String testname;
    private String testprice;

    public test(String testtype, String testname, String testprice) {
        this.testtype = testtype;
        this.testname = testname;
        this.testprice = testprice;
    }

    public String getTesttype() {
        return testtype;
    }

    public void setTesttype(String testtype) {
        this.testtype = testtype;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    public String getTestprice() {
        return testprice;
    }

    public void setTestprice(String testprice) {
        this.testprice = testprice;
    }
    
}
