package compare;

import model.Car;

import java.util.Arrays;

public class ComparatorVsComparable {

    public static void main(String[] args) {

        Integer[] newNum = {2, 7, 9, 3};
        Arrays.sort(newNum, (Integer v1, Integer v2) -> v1-v2); //default behaviour

        System.out.println("Increasing order: ");
        for(int v : newNum) {
            System.out.print(v + " ");
        }

        System.out.println();
        Arrays.sort(newNum, (Integer v1, Integer v2) -> v2-v1);
        // Same as above: Arrays.sort(newNum, (Integer v1, Integer v2) -> v2.compareTo(v1));

        System.out.println("Decreasing order: ");
        for(int v : newNum) {
            System.out.print(v + " ");
        }

        System.out.println();
        System.out.println();


        // Car class implementation
        Car[] arrayCar = new Car[3];
        arrayCar[0] = new Car("Hyundai", "Electric");
        arrayCar[1] = new Car("Nexon", "Petrol");
        arrayCar[2] = new Car("Ferrari", "Petrol");

        System.out.println("Descending order: ");
        Arrays.sort(arrayCar, (Car c1, Car c2) -> c2.carType.compareTo(c1.carType));
        for (Car car: arrayCar) {
            System.out.println(car.carName + " | " + car.carType);
        }

        System.out.println();

        System.out.println("Ascending order: ");
        Arrays.sort(arrayCar, (Car c1, Car c2) -> c1.carType.compareTo(c2.carType));
        for (Car car: arrayCar) {
            System.out.println(car.carName + " | " + car.carType);
        }
    }
}
