package com.ejm.devshowcase_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer score;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Feedback() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }
}