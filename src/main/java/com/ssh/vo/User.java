package com.ssh.vo;

import java.util.*;

public class User {
    private int id;
    private String name;
    private String sex;
    private int age;
    private String location;
    private Soulmate soulmate;
    private Set<Mate> mates = new HashSet<>();

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Mate> getMates() {
        return mates;
    }

    public void setMates(Set<Mate> mates) {
        this.mates = mates;
    }

    public Set<Mate> sendSQL2LoadMates(){
        this.mates.toString();
        return this.mates;
    }

    public Soulmate getSoulmate() {
        return soulmate;
    }

    public void setSoulmate(Soulmate soulmate) {
        this.soulmate = soulmate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                age == user.age &&
                Objects.equals(name, user.name) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(location, user.location);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, sex, age, location);
    }

}
