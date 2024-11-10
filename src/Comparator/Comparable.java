package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Comparable {

    static class NameCompare implements Comparator<Movie> {
        @Override
        public int compare(Movie m1, Movie m2) {
            return m1.name.compareTo(m2.name);
        }
    }

    static class RatingCompare implements Comparator<Movie> {

        @Override
        public int compare(Movie m1, Movie m2) {
            if(m1.stars > m2.stars) {
                return 1;
            }
            else {
                return -1;
            }
        }
    }

    public static class Movie implements java.lang.Comparable<Movie> {
        @Override
        public int compareTo(Movie movie) {
            return (int) (this.release-movie.release);
        }

        public String toString() {
            return ("[" + this.name + ", " + this.stars + ", " + this.release + "]");
        }

        Movie(String name, int release, double stars) {
            this.release = release;
            this.stars = stars;
            this.name = name;
        }
        private int release;
        private double stars;
        private String name;


    }

    public static void main(String[] args) {
        Movie m1 = new Movie("star wars", 1999, 4.4);
        Movie m2 = new Movie("harry potter", 1990, 4.8);
        Movie m3 = new Movie("avengers", 2001, 4.0);
        Movie m4 = new Movie("batman", 1978, 3.5);

        ArrayList<Movie> moviesList = new ArrayList<Movie>();
        moviesList.add(m1);
        moviesList.add(m2);
        moviesList.add(m3);
        moviesList.add(m4);

        moviesList.forEach(entry -> {
            System.out.println(entry);
        });

        System.out.println();
        Collections.sort(moviesList);
        moviesList.forEach(entry -> {
            System.out.println(entry);
        });

        NameCompare nameCompare = new NameCompare();
        Collections.sort(moviesList, nameCompare);

        System.out.println();
        moviesList.forEach(entry -> {
            System.out.println(entry);
        });

        System.out.println();
        RatingCompare ratingCompare = new RatingCompare();
        Collections.sort(moviesList, ratingCompare);
        moviesList.forEach(entry -> {
            System.out.println(entry);
        });
        System.out.println();




    }
}
