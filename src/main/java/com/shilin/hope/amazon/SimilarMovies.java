package com.shilin.hope.amazon;

import java.util.*;

public class SimilarMovies {

    public static void main(String[] args) {

        SimilarMovies test = new SimilarMovies();

        Movie movie1 = new Movie(1, 1.2f);
        Movie movie2 = new Movie(2, 3.6f);
        Movie movie3 = new Movie(3, 2.4f);
        Movie movie4 = new Movie(4, 4.8f);

        movie1.addSimilarMovie(movie2);
        movie1.addSimilarMovie(movie3);

        movie2.addSimilarMovie(movie1);
        movie2.addSimilarMovie(movie4);

        movie3.addSimilarMovie(movie1);
        movie3.addSimilarMovie(movie4);

        movie4.addSimilarMovie(movie2);
        movie4.addSimilarMovie(movie3);

        List<Movie> res = test.solution(movie1, 10);

        for (Movie movie : res) {
            System.out.print(movie.getId() + " --- ");
        }


    }

    public List<Movie> solution(Movie movie, int n) {

        Comparator<Movie> movieComparator = new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                return new Float(m1.rating).compareTo(m2.rating);
            }
        };

        PriorityQueue<Movie> minHeap = new PriorityQueue<>(movieComparator);
        // i assume there's no duplicate in each movie's similar movie list
        Queue<Movie> similarList = new LinkedList<>(movie.getSimilarMovies());
        Set<Movie> visited = new HashSet<>(movie.getSimilarMovies());
        visited.add(movie);

        while (!similarList.isEmpty()) {
            Movie tmp = similarList.poll();
            addToHeap(minHeap, tmp, n);
            for (Movie m : tmp.getSimilarMovies()) {
                if (!visited.contains(m)) {
                    similarList.add(m);
                    visited.add(m);
                }
            }
        }

        List<Movie> result = new ArrayList<>(minHeap);

        return result;

    }

    private void addToHeap(PriorityQueue<Movie> heap, Movie movie, int n) {

        if (heap.size() < n) {
            heap.offer(movie);
        }
        // remove smallest
        else if (heap.size() == n && heap.peek().rating < movie.rating) {
            heap.poll();
            heap.offer(movie);
        }

    }

    static class Movie {
        private int movieId;
        private float rating;
        private ArrayList<Movie> similarMovies = new ArrayList<>();

        public Movie(int movieId, float rating) {
            this.movieId = movieId;
            this.rating = rating;
        }

        public int getId() {
            return movieId;
        }

        public float getRating() {
            return rating;
        }

        public void addSimilarMovie(Movie movie) {
            similarMovies.add(movie);
        }

        public List<Movie> getSimilarMovies() {
            return similarMovies;
        }
    }

}
