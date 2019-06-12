package com.what3words.code_challenge;

import com.what3words.javawrapper.What3WordsV3;
import com.what3words.javawrapper.response.ConvertToCoordinates;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


@SpringBootApplication
public class CodeChallengeApplication {

	public static void main(String[] args) {

		// run Spring App
		SpringApplication.run(CodeChallengeApplication.class, args);
		System.out.println("\n\n\n");



		// *************** READ INPUTS FROM FILES *************** //

		String APIkey = "";
		List<String> What3Words = new ArrayList<>();

		// Read the API key from the file and store it in the "APIkey" variable
		try (BufferedReader b = new BufferedReader(new FileReader("./inputs/apiKey.txt"))) {

			APIkey = b.readLine();
		}
		catch (IOException e) {
			System.out.println(e + " when reading the API key from file.");
		}


		// Read the What3Words from the file and store each line in the "what3words" list
		try (Stream<String> stream = Files.lines(Paths.get("./inputs/w3w_addresses.txt"))) {

			stream.forEach( words -> What3Words.add(words) );  // add each line to the list as a string
		}
		catch (IOException e) {
			System.out.println(e + " when reading the What3Words from file.");
		}



		// *************** GET COORDINATES *************** //

		What3WordsV3 api = new What3WordsV3(APIkey);  // set the API key for the requests

		// instantiate a WordToCoordinates object which will make the request
		WordsToCoordinates wordsToCoordinates = new WordsToCoordinates();



		JSONArray coordinates = new JSONArray();

		// store the What3Words and their respective coordinates/information in a JSONArray, "coordinates"
		What3Words.forEach( words -> {

			JSONObject object = new JSONObject();
			object.put(words, wordsToCoordinates.getCoordinates(api, words));
			coordinates.add(object);
		});



		// *************** WRITE TO JSON FILE *************** //

		try (FileWriter file = new FileWriter("./outputs/coordinates.json")) {

			file.write(coordinates.toJSONString());
			file.flush();

		} catch (IOException e) {
			System.out.println(e + " when writing the coordinates in JSON file.");
		}

	}
}
