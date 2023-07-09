package edu.dev.demo;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 *
 */
@Slf4j
public class Main {

    /**
     * Gson is a Java library that can be used to convert Java Objects into their JSON representation.
     * It can also be used to convert a JSON string to an equivalent Java object.
     * This simple example uses of Gson from package com.google.code.gson to serialize and deserialize
     * This example use Java Records to handle cartoon cats
     * Dependency <a href="https://mvnrepository.com/artifact/com.google.code.gson/gson">Gson Maven repo</a>
     * Info: <a href="https://github.com/google/gson">Gson in Github</a>
     *
     * @param args, arguments in the main
     */
    public static void main(String[] args) {

        var garfield = new Cat("Garfield", "Male", List.of("Eats Lasagna, Sleeps, Causes disasters"));
        var jerry = new Cat("Tom", "Male", List.of("Try to eat Jerry, Try to catch Jerry, Causes disasters"));

        log.info("{} as a JSON is: {}", garfield.name, getCatSerialize(garfield));
        log.info("{} as a JSON is: {}", jerry.name, getCatSerialize(jerry));

        var garfieldAsJson = "{\"name\":\"Garfield\",\"gender\":\"Male\",\"favoriteActivities\":[\"Eats Lasagna, Sleeps, Causes disasters\"]}";
        var tomAsJson = "{\"name\":\"Jerry\",\"gender\":\"Male\",\"favoriteActivities\":[\"Try to eat Jerry, Try to catch Jerry, Causes disasters\"]}";

        log.info("{} as an Object is: {}", garfield.name, getCatDeserialize(garfieldAsJson));
        log.info("{} as an Object is: {}", jerry.name, getCatDeserialize(tomAsJson));

    }

    private static String getCatSerialize(Cat cat) {
        return new Gson().toJson(cat);
    }

    private static Cat getCatDeserialize(String cat) {
        return new Gson().fromJson(cat, Cat.class);
    }

    /**
     * Record to handle cartoon cats
     *
     * @param name               of the cats
     * @param gender             of the cats
     * @param favoriteActivities of the cats
     */
    public record Cat(String name, String gender, List<String> favoriteActivities) {
    }

}