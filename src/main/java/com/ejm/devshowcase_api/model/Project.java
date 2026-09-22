package com.ejm.devshowcase_api.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String url;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToMany(mappedBy = "project")
    private List<Feedback> feedbacks = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "tb_project_technology",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    private List<Technology> technologies = new ArrayList<>();

    public Project() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public Profile getProfile() { return profile; }
    public void setProfile(Profile profile) { this.profile = profile; }

    public List<Feedback> getFeedbacks() { return feedbacks; }
    public void setFeedbacks(List<Feedback> feedbacks) { this.feedbacks = feedbacks; }

    public List<Technology> getTechnologies() { return technologies; }
    public void setTechnologies(List<Technology> technologies) { this.technologies = technologies; }
}