package ru.ivanmarkov.backend_service.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="create_date")
    private Date create_date;

    @Column(name="user_id")
    private User user;

    public Project(){

    }

    public Project(int id, String name, Date create_date, User user) {
        this.id = id;
        this.name = name;
        this.create_date = create_date;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
