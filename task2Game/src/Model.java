import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Model {
    private int value;
    private double doubleValue;
    private String stringValue;
    int minBorder=0;
    int maxBorder=100;
    int guessedNumber=randomNumber();;
    private int randomNumber(){
        return ThreadLocalRandom.current().nextInt(0, 100 + 1);
    };

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public double getDoubleValue() {
        return doubleValue;
    }
    public void setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
    }
    public String getStringValue() {
        return stringValue;
    }
    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }
    public int checkIfTrueNumber(int number)
    {
        return Integer.compare(number, guessedNumber);

    }

}