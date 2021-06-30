public class Model {
    private int value;
    private double doubleValue;
    private String stringValue;
    private int max=100;
    private int min=0;
    int guessedNumber=randomNumber();;
     int randomNumber(){
        return  (int)Math.ceil(Math.random()* (max - min - 1) + min);
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