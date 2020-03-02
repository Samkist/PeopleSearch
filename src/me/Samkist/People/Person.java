package me.Samkist.People;

/**
 * Created by Samkist
 * https://github.com/Samkist
 */
public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        return this.getName().compareTo(person.getName());
    }

    @Override
    public String toString() {
        return "Name: " + name
                + "\n Age: " + age;
    }

    public String getNameAge() {
        return name + " - " + age;
    }
}
