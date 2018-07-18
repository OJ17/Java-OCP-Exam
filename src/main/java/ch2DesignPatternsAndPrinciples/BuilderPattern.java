package ch2DesignPatternsAndPrinciples;

import java.util.List;

// this is an object that requires values set at instantiation
// it is often used with immutable objects because the values
// of an immutable object must be set at runtime
// Locale in java.time has a builder pattern
public class BuilderPattern {
    private String name;
    private int age;
    private List<String> favouritePlaces;

    public BuilderPattern(String name, int age, List<String> favouritePlaces) {

    }

    public BuilderPattern setAge(int age) {
        this.age = age;
        return this;
    }

    public BuilderPattern setName(String name) {
        this.name = name;
        return this;
    }

    public BuilderPattern setFavouritePlace(List<String> favouritePlaces) {
        this.favouritePlaces = favouritePlaces;
        return this;
    }

    public BuilderPattern build() {
        return new BuilderPattern(name, age, favouritePlaces);
    }
}
