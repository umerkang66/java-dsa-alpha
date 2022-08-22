package strings;

public class ConvertToUppercase {
  public static void main(String[] args) {
    String str = "hi, i am umer";

    System.out.println(convertToUppercase(str));
  }

  private static String convertToUppercase(String string) {
    // always use string builder when looping is involved
    StringBuilder upperCasedString = new StringBuilder();
    for (int i = 0; i < string.length(); i++) {
      if (string.charAt(i) >= 97 && string.charAt(i) <= 122) {
        upperCasedString.append((char) (string.charAt(i) - 32));
      } else {
        upperCasedString.append(string.charAt(i));
      }
    }
    return upperCasedString.toString();
  }
}
