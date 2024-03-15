package com.myprojects.zooproject.main_app;


import com.myprojects.zooproject.model.Animal;
import com.myprojects.zooproject.service.FileService;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static com.myprojects.zooproject.service.AnimalService.*;

public class ZooRunner {
    public static void main(String[] args) throws IOException {
        String inputFilePath = "./resources/in.txt";
        String outputFilePath = "./resources/out.txt";
        List<Animal> animals = FileService.readAnimals(inputFilePath);

        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("Displaying the menu:");
            System.out.println("1. Display the animals younger than 10 years old");
            System.out.println("2. Display the animals whose names do not exceed 5 letters");
            System.out.println("3. Display all the animals");
            System.out.println("4. Double the size of aquariums for all fishes");
            System.out.println("5. Decrease the ambient temperature by a certain number of degrees for reptiles");
            System.out.println("6. Increase the ambient temperature by a certain number of degrees for reptiles");
            System.out.println("7. Change the country of origin of all felines to \"Zambia\"");
            System.out.println("8. Modify the age of mammals by reversing the order of the current age digits");
            System.out.println("9. Change the names of animals that begin with the letter \"A\" to \"Victoria\"");
            System.out.println("10. Change the names of animals that begin with a certain letter to a certain name:");
            System.out.println("11. Exit app");
            System.out.println("Choose an option: ");
            option = scanner.nextInt();
            switch (option) {
                case 1 -> solveExercise1(animals);
                case 2 -> solveExercise2(animals);
                case 3 -> solveExercise3(animals);
                case 4 -> solveExercise4(animals, outputFilePath);
                case 5 -> {
                    System.out.println("Introduce the temperature with which you want " +
                            "to decrease the ambient temperature for the reptiles");
                    int temp = scanner.nextInt();
                    solveExercise5(animals, outputFilePath, temp);
                }
                case 6 -> {
                    System.out.println("Introduce the temperature with which you want " +
                            "to increase the ambient temperature for the reptiles");
                    int temp = scanner.nextInt();
                    solveExercise6(animals, outputFilePath, temp);
                }
                case 7 -> solveExercise7(animals, outputFilePath);
                case 8 -> solveExercise8(animals, outputFilePath);
                case 9 -> solveExercise9(animals, outputFilePath);
                case 10 -> {
                    System.out.println("Introduce a capital letter and change the names of animals that begin with it: ");
                    char letter = scanner.next().charAt(0);
                    System.out.println("Change them to a certain name: ");
                    String name = scanner.next();
                    solveExercise10(animals, outputFilePath, letter, name);
                }
                case 11 -> System.out.println("Exiting application");
                default -> System.out.println("Invalid option! Try another one between 1 and 11");
            }
        } while (option != 11);
    }
}