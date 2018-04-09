import java.util.Collections;
import java.util.Optional;

public class Accumul {

  private static final String STRING_DELIMITER = "-";
  private static final String EMPTY_STRING_DELIMITER = "";

  private static void accum(String s) {

    StringBuilder resultBuilder = new StringBuilder();

    if ( !Optional.ofNullable(s).isPresent() || !s.matches("[a-zA-Z]+")) {
      throw new IllegalArgumentException("Incorrect parameter provided");
    }

      s = s.toUpperCase();
      char[] arr = s.toCharArray();
      resultBuilder.append(Character.toString(arr[0]));
      for (int k = 1; k < arr.length; k++) {
        resultBuilder.append(STRING_DELIMITER).append(Character.toString(arr[k]))
            .append(String.join(EMPTY_STRING_DELIMITER, Collections.nCopies(k,
                                                                            Character
                                                                                .toString(
                                                                                    arr[k])
                                                                                .toLowerCase())));

      }
      System.out.println(resultBuilder);
  }

  public static void main(String[] args) {
    Accumul.accum("abcd");    // "A-Bb-Ccc-Dddd"
    Accumul.accum("RqaEzty"); // "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
    Accumul.accum("cwAt");    // "C-Ww-Aaa-Tttt"
  }
}
