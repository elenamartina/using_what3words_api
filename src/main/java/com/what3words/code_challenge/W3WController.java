package com.what3words.code_challenge;
import com.what3words.javawrapper.response.ConvertToCoordinates;
import org.json.simple.JSONArray;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// @RestController combines @Controller and @ResponseBody,
// two annotations that results in web requests returning data rather than a view.
@RestController
public class W3WController {
 // The @Autowired annotation tells Spring where an injection needs to occur
 // and finds what needs to be injected here (the WordsToCoordinates Component).
 @Autowired
 private WordsToCoordinates wordsToCoordinates;

 // @GetMapping annotation maps HTTP GET requests onto specific handler methods.
 // It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
 @GetMapping(path="/what3words")
 // Get coordinates for all the given What3Words
 public JSONArray getAllWhat3Words() {
  List<String> words = new ArrayList<>();
  words.add("silk.slap.soils");
  words.add("zealous.range.garage");
  words.add("slurs.this.shark");
  return wordsToCoordinates.getAllCoordinates(words);
 }

 @GetMapping(path="/what3words/{words}")
 // Get coordinates for a specific What3Words
 public ConvertToCoordinates getWhat3Words(@PathVariable String words) {
  return wordsToCoordinates.getCoordinates(words);
 }
}
