package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    private List<Dog> dogs = new ArrayList<>();

    public List<Dog> getDogs() {
        return dogs;
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {
        for (Dog dog: dogs) {
            dog.feed();
        }
    }

    public Dog findByName(String name) {
        for (Dog dog: dogs) {
            if (dog.getName().equals(name)) {
                return dog;
            }
        }
        throw new IllegalArgumentException("No such name of dogs");
    }

    public void playWith(String name, int hours) {
        Dog actDog = findByName(name);
        actDog.play(hours);
    }

    public List<String> getHappyDogNames(int minHappiness) {
        List<String> names = new ArrayList<>();
        for (Dog dog: dogs) {
            if (dog.getHappiness() > minHappiness) {
                names.add(dog.getName());
            }
        }
        return names;
    }
}
