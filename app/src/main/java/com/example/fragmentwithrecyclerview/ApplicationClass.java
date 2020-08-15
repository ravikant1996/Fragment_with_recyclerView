package com.example.fragmentwithrecyclerview;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {
    public static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();
        people = new ArrayList<>();
        people.add(new Person("Ravikant", "9717038110"));
        people.add(new Person("Shashikant", "8882220945"));
        people.add(new Person("Vipin", "8802592914"));
    }
}
