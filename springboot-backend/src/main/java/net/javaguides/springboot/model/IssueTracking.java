package net.javaguides.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Issue_Tracking")
public class IssueTracking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long issueId;
	
	@Column(name = "id")
	private long id;
	
	@Column(name = "issue_Title")
    private String title;
	
	@Column(name = "issue_Description")
    private String description;
	
	@Column(name = "issue_Status")
    private String status;
	
	@Column(name = "issue_Priority")
    private String priority;
	
	@Column(name = "issue_assignee")
    private String assignee;
	
	@Column(name = "issue_CreatedDate")
	private Date createdDate;
	
	@Column(name = "issue_DueDate")
	private Date dueDate;
	
	public IssueTracking() {	
	}

	public IssueTracking(long id, String title, String description, String status, String priority,
			String assignee, Date createdDate, Date dueDate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.assignee = assignee;
		this.createdDate = createdDate;
		this.dueDate = dueDate;
	}

	public long getIssueId() {
		return issueId;
	}

	public void setIssueId(long issueId) {
		this.issueId = issueId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	
	
	
	
	
	
	

}
