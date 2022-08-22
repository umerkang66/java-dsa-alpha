package strings;

public class StringCompression {
  public static void main(String[] args) {
    char[] chars = { 'a', 'a', 'a', 'b', 'b', 'c', 'c', 'c', 'd', 'd' };
    char[] chars2 = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
    char[] chars3 = { 'a', 'b', 'c', 'd' };

    System.out.println(compressString(chars));
    System.out.println(compressString(chars2));
    System.out.println(compressString(chars3));
  }

  private static String compressString(char[] characters) {
    StringBuilder compressedChars = new StringBuilder();

    for (int i = 0; i < characters.length; i++) {
      // it will be reset when new character will be encountered in the string
      Integer counter = 1;
      while (i < characters.length - 1 && characters[i] == characters[i + 1]) {
        counter++;
        i++;
      }
      // add the first first reoccurring letter, this will be actually last one of the
      // reoccurring characters
      compressedChars.append(characters[i]);
      if (counter > 1) {
        compressedChars.append("" + counter);
      }
    }

    return compressedChars.toString();
  }
}
