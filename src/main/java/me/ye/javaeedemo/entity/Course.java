package me.ye.javaeedemo.entity;

/**
 * Created by Jacob on 12/25/2017.
 */

public class Course {

    private Long id;
    private String name;
    private String lecturer;
    private String category;

    public Course(Long id, String name, String lecturer, String category) {
        this.id = id;
        this.name = name;
        this.lecturer = lecturer;
        this.category = category;
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
