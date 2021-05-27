import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DateNextDateExceptionTest{

  public Date intToDate(int number){
    String temp = Integer.toString(number);
    int[] numbers = new int[temp.length()];
    int y = 0;
    int m = 0;
    int d = 0;
    for (int i = 0; i < temp.length(); i++) {
      numbers[i] = temp.charAt(i) - '0';
      y = numbers[0]*1000+numbers[1]*100+numbers[2]*10+numbers[3];
      m = numbers[4]*10+numbers[5];
      d = numbers[6]*10+numbers[7];
    }
    return new Date(y,m,d);
  }

  @ParameterizedTest
  @ValueSource(ints = {15000231, 15000229, 14581512, 19750650})
  void exceptionTest(int d) {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
    intToDate(d);//new Date(d);
  });
  }


}
