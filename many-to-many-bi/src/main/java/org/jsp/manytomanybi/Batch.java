package org.jsp.manytomanybi;


	import java.util.List;

	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

	@Entity
	public class Batch {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String subject;
	@Column(nullable=false)
	private String trainer;
	@Column(nullable=false,unique=true)
	private String batch_code;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="batch_student",
	joinColumns= {@JoinColumn(name="batch_id")},
	inverseJoinColumns= {@JoinColumn(name="student_id")})
	
	private List<Student>students;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public String getBatch_code() {
		return batch_code;
	}
	public void setBatch_code(String batch_code) {
		this.batch_code = batch_code;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Batch [id=" + id + ", subject=" + subject + ", trainer=" + trainer + ", batch_code=" + batch_code + "]";
	}

	}

