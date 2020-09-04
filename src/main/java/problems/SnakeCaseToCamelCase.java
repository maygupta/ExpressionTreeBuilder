package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Program to convert a string into all possible combinations of camel case
 */
public class SnakeCaseToCamelCase {
  private List<String> words = Arrays.asList("car", "ball", "apple", "krishna", "nitai", "gauranga", "nitaigaur",
      "anga", "nitaigauranga", "gaurangakrishna");

  public List<String> allCamelCases(String input) {
    if ( input.length() == 0) {
      return new ArrayList<String>();
    }

    List<String> allCases = new ArrayList<>();
    int i = 1;
    while ( i <= input.length() ) {
      if (isWord(input.substring(0,i))) {
        String start = toFirstUpperCase(input.substring(0, i));
        List<String> allSubStrings = allCamelCases(input.substring(i));
        for(String x: allSubStrings) {
          String camelCase = start + x;
          if (camelCase.length() == input.length()) {
            allCases.add(camelCase);
          }
        }
        if (allSubStrings.size() == 0) {
          allCases.add(start);
        }
      }
      i += 1;
    }
    return allCases;
  }

  public String toFirstUpperCase(String s) {
    return s.substring(0,1).toUpperCase() + s.substring(1);
  }

  public String toFirstLowerCase(String s) {
    return s.substring(0,1).toLowerCase() + s.substring(1);
  }

  private boolean isWord(String s) {
    return words.contains(s);
  }

}
