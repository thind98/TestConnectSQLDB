package vn.itsol.apiviettel.entity;

import javax.persistence.*;

@Entity
@Table(name = "API_CUSTOMER")
public class Customer {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cus_id")
    private long cus_id;

    @Column(name = "name")
    private String name;

    @Column(name = "organization")
    private String organization;

    @Column(name = "isdn ")
    private long isdn;

    @Column(name = "dob ")
    private String dob;

    @Column(name = "sex ")
    private long sex;

    @Column(name = "address ")
    private String address;

    @Column(name = "status ")
    private long status;

    @Column(name = "email ")
    private String email;

    @Column(name = "username ")
    private String username;

    @Column(name = "password ")
    private String password;

    public long getCus_id() {
        return cus_id;
    }

    public void setCus_id(long cus_id) {
		this.cus_id = cus_id;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public long getIsdn() {
        return isdn;
    }

    public void setIsdn(long isdn) {
        this.isdn = isdn;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public long getSex() {
        return sex;
    }

    public void setSex(long sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
	public String toString() {
		return "Api_Customer[cus_id=" + cus_id + ",name=" +name+ ", address= "+address+ "]";
	}

}
