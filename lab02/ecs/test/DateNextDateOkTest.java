import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
public class DateNextDateOkTest
{
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
  @ValueSource(ints = {17000620,20050415,19010720,34560327,15000217,17000629,
    18001129,34530129,4440229,20050430,34530130,34560330,19010731,
    34530131,34561231,15000231})
  void exceptionTest(int d) {
    Date date = intToDate(d);
    if (date.isEndOfMonth())
      assertEquals(intToDate(d+70), date.nextDate());
    else
    assertEquals(intToDate(d+1), date.nextDate());
    };


}
