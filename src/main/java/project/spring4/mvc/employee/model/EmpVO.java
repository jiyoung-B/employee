package project.spring4.mvc.employee.model;

public class EmpVO {

    private int employee_id;
    private String first_name;
    private String email;
    private String job_id;
    private int department_id;
    private String lname;
    private String phone;
    private String hdate;
    private int sal;
    private double comm;
    private int mgrid;

    public EmpVO() {
    }

    public EmpVO(int employee_id, String first_name, String email, String job_id, int department_id) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.email = email;
        this.job_id = job_id;
        this.department_id = department_id;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHdate() {
        return hdate;
    }

    public void setHdate(String hdate) {
        this.hdate = hdate;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public int getMgrid() {
        return mgrid;
    }

    public void setMgrid(int mgrid) {
        this.mgrid = mgrid;
    }



    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    @Override
    public String toString() {
        return "EmpVO{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", email='" + email + '\'' +
                ", job_id='" + job_id + '\'' +
                ", department_id=" + department_id +
                '}';
    }
}
