package com.what3words.code_challenge;

import com.what3words.javawrapper.What3WordsV3;
import com.what3words.javawrapper.response.ConvertToCoordinates;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;



@SpringBootApplication
public class CodeChallengeApplication {

	public static void main(String[] args) {

		// run Spring App
		SpringApplication.run(CodeChallengeApplication.class, args);

		System.out.println("\n\n\n\n");


		// ***** READ INPUTS FROM FILES ***** //
		String APIkey = "";
		List<String> What3Words = new ArrayList<>();

		// Read the API key from the file and store it in the "APIkey" variable
		try (BufferedReader b = new BufferedReader(new FileReader("./inputs/apiKey.txt"))) {

			APIkey = b.readLine();
			//System.out.println("API key: " + APIkey);
		}
		catch (IOException e) {
			System.out.println(e + " when reading the API key from file.");
		}

		// Read the What3Words from the file and store each line in the "what3words" list
		try (Stream<String> stream = Files.lines(Paths.get("./inputs/w3w_addresses.txt"))) {

			// add each line to the list as a string
			stream.forEach(s -> What3Words.add(s));
			//System.out.println("What3Words: " + What3Words);
		}
		catch (IOException e) {
			System.out.println(e + " when reading the What3Words from file.");
		}


		// ***** GET COORDINATES ***** //

		// set the API key for the requests
		What3WordsV3 api = new What3WordsV3(APIkey);

		// instantiate a WordToCoordinates object which will make the request
		WordsToCoordinates wordsToCoordinates = new WordsToCoordinates();

		// List to store the coordinates and information for each what3words
		List<ConvertToCoordinates> coordinates = new ArrayList<>();

		What3Words.forEach( word -> {
			coordinates.add(wordsToCoordinates.getCoordinates(api, word));

		});

		//System.out.println(coordinates);
	}

}
