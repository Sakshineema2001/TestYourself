package com.exam.model.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cid;

	private String title;
	private String Description;

	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Quiz> quizzes = new LinkedHashSet<>();


	public Category()
	{
	}

	public Category(String title, String description)
	{
		this.title = title;
		Description = description;
	}

	public Long getCid()
	{
		return cid;
	}

	public void setCid(Long cid)
	{
		this.cid = cid;
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
		return Description;
	}

	public void setDescription(String description)
	{
		Description = description;
	}
}
