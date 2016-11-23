
import java.util.*;
import java.io.*;

public class Listing extends User implements Serializable{
	private String name;
	private String jobDescription;
	private String skillsRequired;
	private String jobTitle;
	private String expRequired;
	private String email;
	private String password;
	
	public Listing(String name, String jobDescription, String skillsRequired, String jobTitle, String expRequired, String email, String password){
		this.name 			= name;
		this.jobDescription = jobDescription;
		this.skillsRequired = skillsRequired;
		this.jobTitle		= jobTitle;
		this.expRequired	= expRequired;
		this.email			= email;
		this.password		= password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getExpRequired() {
		return expRequired;
	}

	public void setExpRequired(String expRequired) {
		this.expRequired = expRequired;
	}
	

	public String getSkillsRequired() {
		return skillsRequired;
	}

	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString(){
		return "[Name: " + name + ", Job description: " + jobDescription + ", Job title: " + jobTitle + ", Experience required: " + expRequired + ", Skills required: " + skillsRequired + ", Email: " + email + ", Password: " + password +" ]";
	}
}
