package me.Samkist.People;

import me.Samkist.ArrayList.ArrayList;

/**
 * Created by Samkist
 * https://github.com/Samkist
 */
public class People {
    private static ArrayList<Person> people = new ArrayList<>();

    public static void addPerson(Person p) {
        people.add(p);
    }

    public static void removePerson(Person p) {
        people.remove(p);
    }

    public static ArrayList<Person> getPeople() {
        return people;
    }
}
