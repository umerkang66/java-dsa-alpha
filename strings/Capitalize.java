package strings;

public class Capitalize {
  public static void main(String[] args) {
    String string = "hi, i am umer";
    System.out.println(capitalize(string));
  }

  private static String capitalize(String string) {
    StringBuilder capitalizedString = new StringBuilder();

    for (int i = 0; i < string.length(); i++) {
      if (i == 0) {
        // first letter
        capitalizedString.append(charUpperCase(string.charAt(i)));
      } else if (string.charAt(i) == ' ' && i < string.length() - 1) {
        capitalizedString.append(string.charAt(i));
        capitalizedString.append(charUpperCase(string.charAt(i + 1)));
        i++;
      } else {
        capitalizedString.append(string.charAt(i));
      }
    }

    return capitalizedString.toString();
  }

  private static char charUpperCase(char character) {
    return (char) (character - 32);
  }
}
