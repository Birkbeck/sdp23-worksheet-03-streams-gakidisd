import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Outline {

  public static List<String> getList() {
    return List.of("hi", "bat", "ear", "hello", "iguana",
            "beaver", "winterland", "elephant", "eye", "qi");
  }

  // Loop through the words and print each one on a separate line,
  // with two spaces in front of each word.
  public static void question1() {
    List<String> words = getList();
    System.out.println("1: ");
    // YOUR CODE

    for (String word: words){
      System.out.println("  " + word);
    }
  }

  // Repeat this problem but without two spaces in front of each word.
  // This should be trivial if you use the same approach as the previous
  // question; the point here is to make use of a method reference.
  public static void question2() {
    List<String> words = getList();
    System.out.println("2: ");
    // YOUR CODE

    words.stream().forEach(word -> System.out.println(word));
  }

  // For each of the following lambda expressions (see Question 5 in Worksheet 2),
  // produce the list that contains the elements of the original list
  // that satisfy the predicate defined by the lambda expression
  // (use the filter stream operation):
  //  - s -> s.length() < 4 (strings with no more than 3 characters),
  //  -  s -> s.contains("b") (strings containing "b"),
  // s -> (s.length() % 2) == 0 (strings of even length).

  public static void question3() {
    List<String> words = getList();
    System.out.println("3:");
    // YOUR CODE
    List<String> lessThanFour = words.stream()
            .filter(s -> s.length() < 4)
            .toList();

    List<String> containingB = words.stream()
            .filter(s -> s.contains("b"))
            .collect(Collectors.toList());

    List<String> evenLength = words.stream()
            .filter(s -> s.length() % 2 ==0)
            .toList();

    System.out.println("List with strings with no more than e characters");
    System.out.println(lessThanFour);

    System.out.println();

    System.out.println("List containing 'D'");
    System.out.println(containingB);

    System.out.println();

    System.out.println("List with strings of even length");
    System.out.println(evenLength);


  }


  // For each of the following lambda expressions (see Question 7 in Worksheet 2),
  // produce the list that contains the results of applying the function
  // defined by the lambda expression to each element of the original list
  // (use the map stream operation):
  // - s -> s + "!",
  //  s -> s.replace("i", "eye"),
  //  s -> s.toUpperCase().

  public static void question4() {
    List<String> words = getList();
    System.out.println("4:");
    // YOUR CODE
    List<String> newList = words.stream()
            .map(s -> s + "!")
            .toList();

    List<String> newList1 = words.stream()
            .map(s -> s.replace("i","eye"))
            .toList();

    List<String> newList2 = words.stream()
            .map(s -> s.toUpperCase(Locale.ROOT))
            .toList();

    System.out.println("First List");
    System.out.println(newList);

    System.out.println();
    System.out.println("Second List");
    System.out.println(newList1);

    System.out.println();
    System.out.println("Third List");
    System.out.println(newList2);
  }


  // (*) Turn the strings in the list into uppercase, keep only the
  // ones that are shorter than four characters, and, of what is remaining,
  // keep only the ones that contain "e", and print the first result.
  // Repeat the process, except checking for a "q" instead of an "e".

  public static void question5() {
    List<String> words = getList();
    System.out.println("5a:");
    // YOUR CODE
    List<String> newList = words.stream()
            .map(word -> word.toUpperCase(Locale.ROOT)) // all the words to uppercase
            .filter(word -> word.length() < 4) // filtering the words being less than 4 characters
            .filter(word -> word.contains("e")) // keeping only the words containing e
            .toList(); //saving the results to a new list

    System.out.println(newList);

    List<String> newList1 = words.stream()
            .map(word -> word.toUpperCase(Locale.ROOT)) // all the words to uppercase
            .filter(word -> word.length() < 4) // filtering the words being less than 4 characters
            .filter(word -> word.contains("q")) // keeping only the words containing e
            .toList(); //saving the results to a new list

    System.out.println("\n" + newList1);
  }


  // (** ) The above example uses lazy evaluation, but it is not easy to see
  // that it is doing so. Create a variation of the above example that shows
  // that it is doing lazy evaluation. The simplest way is to track which
  // entries are turned into upper case.

  public static void question6() {
    List<String> words = getList();
    System.out.println("6:");
    // YOUR CODE


    List<String> newList = new ArrayList<>();
    // we apply the mapping first
    for (String word : words){
      newList.add(word.toUpperCase(Locale.ROOT));
    }
    System.out.println("List of words before any conversion");
    System.out.println(words);
    System.out.println();
    System.out.println("List of words after converting them to uppercase.");
    System.out.println(newList);

    List<String> words1 = newList;
    //we apply the filtering and keeping only the words with less than 4 chars
    for (int i = 0; i < newList.size(); i++) {
      if (newList.get(i).length() > 4){
        words1.remove(i);
      }
    }

    System.out.println("\nList of words with less than 4 chars");
    System.out.println(words1);

    List<String> words2 = words1;
    // keeping only the strings containg "e" from the last list
    for (int i = 0; i < words1.size(); i++) {
      if (!words1.get(i).contains("e")){
        words2.remove(i);
      }
    }

    System.out.println("\nList of words with less than 4 chars");
    System.out.println(words2);





  }

  // (*) Produce a single String that is the result of concatenating the
  // uppercase versions of all the Strings.
  // For example, the result should be "HIHELLO...".
  // Hint: use a map operation that turns the words into upper case,
  // followed by a reduce operation that concatenates them.

  public static void question7() {
    List<String> words = getList();
    System.out.println("7:");
    // YOUR CODE


    String concatenatedString = words.stream()
            .map(word -> word.toUpperCase(Locale.ROOT))
            .reduce( (word1,word2) -> word1+word2)
            .stream().collect(Collectors.joining());

    System.out.println("Concatenated Words: " + concatenatedString);
  }


  // (*) Produce a single String that is the result of concatenating the
  // uppercase versions of all the Strings.
  // For example, the result should be "HIHELLO...".
  // Use a single reduce operation, without using map.

  public static void question8() {
    List<String> words = getList();
    System.out.println("8:");
    // YOUR CODE

              words.stream()
            .reduce( (word1,word2) -> word1 + word2)
            .stream()
            .forEach(word -> System.out.println(word.toUpperCase(Locale.ROOT)));
  }

  // (*) Produce a String that is all the words concatenated together, but
  // with commas in between. For example, the result should be "hi,hello,...".
  // Note that there is no comma at the beginning, before "hi", and also no comma
  // at the end, after the last word.

  public static void question9() {
    List<String> words = getList();
    System.out.println("9:");
    // YOUR CODE
    String concat = words.stream().collect(Collectors.joining(","));

    System.out.println(concat);
  }

  // CONTINUE WITH THE REST OF THE QUESTIONS

  /**
   * Using streams to find the first two dishes of type MEAT
   */
  public static void question10(){
    List<Dish> menu = Dish.getMenu();

    menu.stream()
            .limit(2)
            .filter(dish -> dish.type() == Dish.Type.MEAT)
            .forEach(dish -> System.out.println(dish));
  }

  public static void question11(){
    List<Dish> menu = Dish.getMenu();

    int sum = menu.stream()
            .map(dish -> dish.name())
            .reduce (0, (i, l) -> i + 1, (i, j) -> i + 1);


    System.out.println(sum);
  }

  public static void main(String... args) { // varargs alternative to String[]
    question11();

  }
}