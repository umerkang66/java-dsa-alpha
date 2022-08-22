package strings;

public class StringBuilders {
  public static void main(String[] args) {
    StringBuilder stringBuilder = new StringBuilder("a ");
    for (char i = 'b'; i <= 'z'; i++) {
      stringBuilder.append(i);
      if (i < 'z') {
        stringBuilder.append(' ');
      }
    }
    System.out.println(stringBuilder.length());
  }
}
