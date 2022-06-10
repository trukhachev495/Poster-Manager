package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.manager.MovieManager;

public class MovieManagerTest {
    Movie first = new Movie("100", "bloodshot", "action movie");
    Movie second = new Movie("200", "forward", "cartoon");
    Movie third = new Movie("300", "belgrade", "comedy");
    Movie fourth = new Movie("400", "gentlemen", "action movie");
    Movie fifth = new Movie("500", "invisibleMan", "horror");
    Movie sixth = new Movie("600", "trollsWorldTour", "cartoon");
    Movie seventh = new Movie("700", "numberOne", "comedy");

    MovieManager manager = new MovieManager();


    @Test
    public void addingTwo() {
        manager.save(first);
        manager.save(second);

        Movie[] actual = manager.findAll();
        Movie[] expected = {first, second};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void findAllEmpty() {
        Movie[] actual = manager.findAll();
        Movie[] expected = {};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void findLastDefault() {
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);

        Movie[] actual = manager.findLast();
        Movie[] expected = {seventh, sixth, fifth, fourth, third, second, first};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void findLast() {
        MovieManager manager = new MovieManager(2);
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);

        Movie[] actual = manager.findLast();
        Movie[] expected = {seventh, sixth};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void findLastLimitOverLenght() {

        MovieManager manager = new MovieManager(6);
        manager.save(first);
        manager.save(second);
        manager.save(third);

        Movie[] actual = manager.findLast();
        Movie[] expected = {third, second, first};

        Assertions.assertArrayEquals(actual, expected);

    }

}
