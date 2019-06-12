
# Java API Programming Challenge

​Small ​Spring Boot ​RESTful Service in Java using the [What3Words](​https://www.what3words.com) API in order to retrieve information about a given set of What3Words.
It uses the [Java Wrapper](https://docs.what3words.com/wrapper/java/) suggested on the documentation.


## Functionalities

* The program reads the inputs from the two separate files in the `inputs` folder, containing the API key and the What3Words addresses, respectively.

* The API key is used to make GET requests to the What3Words API in order to retrieve the information corresponding to the given What3Words addresses.

* The information obtained from the requests are written to a JSON file


#### Project Structure

 Inputs and Outputs are stored in the following folders:

 ```
 project
|
└───inputs
│   │   apiKey.txt
│   │   w3w_addresses.txt
│   
└───outputs
    │   coordinates.json 
```

## Usage

Run the application from your IDE as a simple Java application, or run from the Terminal using Gradle:

```bash
$ gradle bootRun
```

