package dev.group24.workwave.announcement;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "announcements")
public class Announcement {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_announcement")
    private Long id;

    @Column
    private String jobName;

    @Column
    private String companyName;

    @Column
    private String jobRequirements;

    @Column
    private String jobDescription;

    @Column
    private String salary;

    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    public Announcement() {
    }

    public Announcement(String jobName, String companyName, String jobRequirements, String jobDescription,
            String salary, Date startDate) {
        this.jobName = jobName;
        this.companyName = companyName;
        this.jobRequirements = jobRequirements;
        this.jobDescription = jobDescription;
        this.salary = salary;
        this.startDate = startDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobRequirements() {
        return jobRequirements;
    }

    public void setJobRequirements(String jobRequirements) {
        this.jobRequirements = jobRequirements;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
