package com.ssh.vo;

public class Mate {
    private int id;
    private String name;
    private Integer age;
    private String sex;
    private User user;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mate mate = (Mate) o;

        if (id != mate.id) return false;
        if (name != null ? !name.equals(mate.name) : mate.name != null) return false;
        if (age != null ? !age.equals(mate.age) : mate.age != null) return false;
        if (sex != null ? !sex.equals(mate.sex) : mate.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }

    public User sendSQL2LoadUser(){
        this.user.toString();
        return this.user;
    }

    @Override
    public String toString() {
        return "Mate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
