package strings;

public class GetShortedPath {
  public static void main(String[] args) {
    String paths = "WNEENESENNN";
    System.out.println(getShortedPath(paths));
  }

  private static double getShortedPath(String paths) {
    // at first (x,y) == (0,0)
    int x = 0, y = 0;
    int initialX = x, initialY = y;
    for (int i = 0; i < paths.length(); i++) {
      if (paths.charAt(i) == 'N') {
        // north: go above in graph: increase y by 1
        y += 1;
      }
      if (paths.charAt(i) == 'S') {
        // south: go down in graph: decrease y by 1
        y -= 1;
      }
      if (paths.charAt(i) == 'W') {
        // west: go right in graph: decrease x by 1
        x -= 1;
      }
      if (paths.charAt(i) == 'E') {
        // east: go left in graph: increase x by 1
        x += 1;
      }
    }
    // Here we have gotten the x, and y values, calculate the displacement using
    // pythagoras theorem d = ((x2-x1)^2 + (y2-y1)^2) ^ 1/2
    return Math.sqrt(Math.pow((x - initialX), 2) + Math.pow((y - initialY), 2));
  }
}
