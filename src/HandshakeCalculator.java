import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HandshakeCalculator {
    public static void main(String[] args) {
        System.out.println(calculateHandshake(19));
    }

public static List<Signal> calculateHandshake(int number) {
        List<Signal> secret = new ArrayList<>();
 number = Integer.parseInt(Integer.toBinaryString(number)); // try later with string with contain
    if (number >=10000) Collections.reverse(secret);
    if (number >=1000) {
        secret.add(Signal.JUMP);
        number -= 1000;
    }
    if (number >=100) {
            secret.add(Signal.CLOSE_YOUR_EYES);
            number -= 100;
    }
    if (number >=10){
                secret.add(Signal.DOUBLE_BLINK);
                number-=10;
    }
    if (number >=1){
           secret.add(Signal.WINK);
       number-=1;
    }

return secret;
}

}
