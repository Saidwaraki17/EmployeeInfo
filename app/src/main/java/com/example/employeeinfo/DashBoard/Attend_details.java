package com.example.employeeinfo.DashBoard;

public class Attend_details {
    String emp_name,emp_id, emp_work,emp_pre,emp_leave,emp_obs;
    public Attend_details(String name, String id, String working_days, String present, String leave, String obsent){
        this.emp_name=name;
        this.emp_id=id;
        this.emp_work=working_days;
        this.emp_pre=present;
        this.emp_leave=leave;
        this.emp_obs=obsent;


    }




    public String getempname() {
        return emp_name;
    }
    public void setempname(String employee_name) {
        this.emp_name = employee_name;
    }
    public String getempid() {
        return emp_id;
    }
    public void setempid(String employee_id) {
        this.emp_id = employee_id;
    }

    public String getworkingdays() {
        return  emp_work;

    }
    public void setworkingdays(String employee_contact) {
        this.emp_work = employee_contact;
    }


    public String getpresent() {
        return emp_pre;
    }
    public void setpresent(String present) {
        this.emp_pre = present;
    }


    public String getobs() {return emp_obs;
    }
    public void setobs(String obsent) {
        this.emp_obs = obsent;
    }


    public String getleave() {return emp_leave;
    }
    public void setleave(String leave) {
        this.emp_leave = leave;
    }

}
