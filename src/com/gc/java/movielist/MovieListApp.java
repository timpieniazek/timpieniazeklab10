package com.gc.java.movielist;

import java.util.ArrayList;
import java.util.Collections;
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
			// Takes an integer from 1 to 4
			input = Validator.getInt(scan, "", 1, 4);

			category = inputToString(input);

			System.out.printf("%nThese are the titles in %s:%n", category);
			
			// method to print titles in category alphabetically
			showTitles(movieList, category);

			// loop end of user input loop
			cont = Validator.getYesOrNo(scan, "\nWould you like to continue? (y/n): ");
		}
		
		System.out.println("\nThank you!\nGoodbye!");
	}

	// uses MovieIO class to populate our movieList
	public static ArrayList<Movie> fillList(ArrayList<Movie> list) {
		for (int i = 1; i <= 100; i++) {
			list.add(MovieIO.getMovie(i));
		}
		return list;
	}

	// translates numeric input to corresponding category name
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
		default:
			return "";
		}
	}

	// makes a temporary titles ArrayList, sorts them and then prints
	public static void showTitles(ArrayList<Movie> movies, String category) {
		ArrayList<String> titles = new ArrayList<>();
		
		// cycles through ArrayList of Movie object,
		// populates temp array with matches to category
		for (Movie movie : movies) {
			if (movie.getCategory() == category) {
				titles.add(movie.getTitle());
			}
		}
		
		// sort auto alphabetizes the String ArrayList
		Collections.sort(titles);
		
		for (String title : titles) {
			System.out.println(title);
		}
	}

}
