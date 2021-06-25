package com.company;

public class Model {
    private String value;

    // The Program logic

    /**
     * in this method add valueInt with this.value
     *
     * @param valueString
     * @return sum
     */
    public String addStringOurValue(String valueString) {
        return value += valueString;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void validateHello(String word) {
        if (word.equals("Hello")) {
            System.out.println("Input is ok..... Continue ");

        } else {
            System.out.println("Wrong input... Should be (Hello)");
        }
    }

    public void validateWorld(String word) {
        if (word.equals("world")) {
            System.out.println("Input is ok..... Continue ");

        } else {
            System.out.println("Wrong input... Should be (world)");
        }
    }
}
