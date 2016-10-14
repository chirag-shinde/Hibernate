package com.smartify.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

@Entity
@Table(name = "finances_user")
@Access(value = AccessType.PROPERTY)
public class User {
	
	private Long userID;			//Basic Value Type
	
	private String firstName;		//Basic Value Type
	
	private String lastname;		//Basic Value Type

	private List<Address> address = new ArrayList<Address>();
	
	private Credential credential;
	
	private Date birthDate;			
	
	private String emailAddress;	//Basic Value Type
	
	private Date lastUpdatedDate;	
	
	private String lastUpdatedBy; 	//Basic Value Type
	
	private Date createdDate;		
	
	private String createdBy;		//Basic Value Type
	
	private boolean valid;			//Basic Value Type
	
	private int age;				//Basic Value Type
	
	private Set<Account> accounts = new HashSet<>(); 
	
	@ElementCollection
	@CollectionTable(name = "user_address" , joinColumns = @JoinColumn(name = "user_id"))
	@AttributeOverrides({
		@AttributeOverride(name = "addressLine1", column = @Column(name = "user_address_line_1")),
		@AttributeOverride(name = "addressLine2", column = @Column(name = "user_address_line_2"))
		})
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	@Formula("lower(datediff(curdate(), birth_date)/365)")
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Transient
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name")
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Column(name = "birth_date")
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Column(name = "email_address")
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@Column(name = "last_updated_date")
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	@Column(name = "last_updated_by")
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	@Column(name = "created_date", updatable = false)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "created_by", updatable = false)
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	public Credential getCredential() {
		return credential;
	}
	public void setCredential(Credential credential) {
		this.credential = credential;
	}
	
	@ManyToMany(cascade = CascadeType.ALL , mappedBy ="users")
	public Set<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	public User() {
		
	}
	public User(String firstName, String lastname, List<Address> address, Credential credential, Date birthDate,
			String emailAddress, Date lastUpdatedDate, String lastUpdatedBy, Date createdDate, String createdBy,
			boolean valid, int age) {
		
		this.firstName = firstName;
		this.lastname = lastname;
		this.address = address;
		this.credential = credential;
		this.birthDate = birthDate;
		this.emailAddress = emailAddress;
		this.lastUpdatedDate = lastUpdatedDate;
		this.lastUpdatedBy = lastUpdatedBy;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.valid = valid;
		this.age = age;

	}
	
	
}
