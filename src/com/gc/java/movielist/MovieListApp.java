package com.gc.java.movielist;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieListApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input;
		String category;
		// creates ArrayList of Movie class objects, and runs the
		// getMovie() method to populate it with example from MovieIO
		ArrayList<Movie> movieList = new ArrayList<>();
		fillList(movieList);

		System.out.println("Welcome to the Movie List Application!\n");

		String cont = "y";
		while (cont.equalsIgnoreCase("y")) {

			System.out.printf("There are %s movies in this list.%nWhat category are you interested in?%n",
					movieList.size());
			System.out.printf("::1-animated:: ::2-drama::%n:::3-horror::: ::4-scifi::%n");
			input = Validator.getInt(scan, "", 1, 4);

			category = inputToString(input);
			// System.out.println(inputToString(input));

			System.out.printf("%nThese are the titles in %s:%n", category);
			showTitles(movieList, category);

			// System.out.println("\nWould you like to continue? (y/n):");
			cont = Validator.getYesOrNo(scan, "\nWould you like to continue? (y/n): ");
		}
	}

	public static ArrayList<Movie> fillList(ArrayList<Movie> list) {
		for (int i = 1; i <= 100; i++) {
			list.add(MovieIO.getMovie(i));
		}
		return list;
	}

	public static String inputToString(int input) {
		switch (input) {
		case 1:
			return "animated";
		case 2:
			return "drama";
		case 3:
			return "horror";
		case 4:
			return "scifi";
		}
		return "";
	}

	public static void showTitles(ArrayList<Movie> movies, String category) {
		for (Movie movie : movies) {
			if (movie.getCategory() == category) {
				System.out.println(movie.getTitle());
			}
		}
	}

}
