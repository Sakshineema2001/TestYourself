package com.exam.model.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Quiz
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qid;

	private  String title;
	private String description;
	private String maxMarks;
	private String numberOfQuestions;
	private boolean active=false;

	@OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Questions> questionsSet = new HashSet<>();

	public Category getCategory()
	{
		return category;
	}

	public void setCategory(Category category)
	{
		this.category = category;
	}

	@ManyToOne()
	private Category category;

	public Quiz()
	{
	}

	public Quiz(String title, String discription, String maxMarks, String numberOfQuestions, boolean active)
	{
		this.title = title;
		this.description = discription;
		this.maxMarks = maxMarks;
		this.numberOfQuestions = numberOfQuestions;
		this.active = active;
	}

	public Long getQid()
	{
		return qid;
	}

	public void setQid(Long qid)
	{
		this.qid = qid;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getMaxMarks()
	{
		return maxMarks;
	}

	public void setMaxMarks(String maxMarks)
	{
		this.maxMarks = maxMarks;
	}

	public String getNumberOfQuestions()
	{
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(String numberOfQuestions)
	{
		this.numberOfQuestions = numberOfQuestions;
	}

	public boolean isActive()
	{
		return active;
	}

	public void setActive(boolean active)
	{
		this.active = active;
	}
}