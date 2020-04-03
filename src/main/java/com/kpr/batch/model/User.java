/**
 * 
 */
package com.kpr.batch.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author PushkarRajuKoppanath
 *
 */
@Entity
public class User {
	@Id
	private Integer empNo;
	private String eName;
	private String dept;
	private Integer salary;
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public User(Integer empNo, String eName, String dept, Integer salary) {
		super();
		this.empNo = empNo;
		this.eName = eName;
		this.dept = dept;
		this.salary = salary;
	}
	
	public User(){
	}
	
	@Override
	public String toString() {
		return "User [empNo=" + empNo + ", eName=" + eName + ", dept=" + dept + ", salary=" + salary + "]";
	}
	
	
	

}
