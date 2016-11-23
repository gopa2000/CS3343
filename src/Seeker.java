
import java.util.*;
import java.io.*;

public class Seeker extends User implements Serializable{
	private String name;
	private String education;
	private String workExp;
	private String skills;
	private String email;
	private String password;
	
	public Seeker(String name, String education, String workExp, String skills, String email, String password){
		this.name		= name;
		this.education	= education;
		this.workExp	= workExp;
		this.skills		= skills;
		this.email		= email;
		this.password	= password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getWorkExp() {
		return workExp;
	}

	public void setWorkExp(String workExp) {
		this.workExp = workExp;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
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
		return "[Name: " + name + ", Education: " + education + ", WorkExp: " + workExp + ", Skills: " + skills + ", Email: " + email + ", Password: " + password +" ]"; 
	}
	
}
