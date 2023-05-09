package presenter;

import base.DynamicArray;

import java.util.Random;

public class DemoArray {
    public DemoArray(){
        Random random = new Random();
        strDA = new DynamicArray<>();
        for (int i = 0; i < 20; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < random.nextInt(2,15); j++) {
                sb.append((char)random.nextInt(70,95));
            }
            strDA.add(sb.toString());
        }
        Integer[] rndArray = new Integer[20];
        for (int i = 0; i < rndArray.length; i++) {
            rndArray[i] = random.nextInt(1,100);
        }
        intDA = new DynamicArray<>(rndArray);
        dblDA = new DynamicArray<>();
        for (int i = 0; i < 5; i++) {
            dblDA.add(random.nextDouble(1.0, 12.0));
        }
    }
    public DynamicArray<String> strDA;
    public DynamicArray<Integer> intDA;
    public DynamicArray<Double> dblDA;
}
