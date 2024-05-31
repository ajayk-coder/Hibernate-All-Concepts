package org.jsp.onetomanyuni;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Questiondata {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@Column(nullable=false)
private String question,questionedBy;

@OneToMany(cascade=CascadeType.ALL)
private List<Answerdata> answers;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public String getQuestionedBy() {
	return questionedBy;
}
public void setQuestionedBy(String questionedBy) {
	this.questionedBy = questionedBy;
}
public List<Answerdata> getAnswers() {
	return answers;
}
public void setAnswers(List<Answerdata> answers) {
	this.answers = answers;
}
@Override
public String toString() {
	return "Questiondata [id=" + id + ", question=" + question + ", questionedBy=" + questionedBy + "]";
}


}
