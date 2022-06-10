package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    private Movie[] items = new Movie[0];
    private int limit = 10;

    public MovieManager(int limit) {
        this.limit = limit;
    }

    public MovieManager() {
    }

    public void save(Movie item) {
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(items,0,tmp,0,items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movie[] findAll() {
        return items;
    }

    public Movie[] findLast() {
        int resultLenght;
        if (limit > items.length) {
            resultLenght = items.length;
        } else {
            resultLenght = limit;
        }
        Movie[] result = new Movie[resultLenght];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }

        return result;
    }

}


