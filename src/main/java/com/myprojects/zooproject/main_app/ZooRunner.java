package com.myprojects.zooproject.main_app;


import com.myprojects.zooproject.model.*;
import com.myprojects.zooproject.service.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            System.out.println("7. Change the country of origin of all felines to Zambia");
            System.out.println("8. Modify the age of mammals by reversing the order of the current age digits");
            System.out.println("9. Change the names of animals that begin with the letter \"A\" to \"Victoria\"");
            System.out.println("10. Exit app");
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
                case 10 -> System.out.println("Exiting application");
                default -> System.out.println("Invalid option! Try another one between 0 and 9");
            }
        } while (option != 10);
    }

    //sa afiseze pe ecran animalele mai tinere de 10 ani;
    private static void solveExercise1(List<Animal> animals) {
        for (Animal animal : animals) {
            if (animal.getAge() < 10) {
                System.out.println(animal);
            }
        }
    }

    //sa afiseze pe ecran animalele a caror nume nu depaseste 5 litere;
    private static void solveExercise2(List<Animal> animals) {
        for (Animal animal : animals) {
            if (animal.getName().length() <= 5) {
                System.out.println(animal);
            }
        }
    }

    //sa afiseze pe ecran toate animalele;
    private static void solveExercise3(List<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    //sa dubleze marimea acvariilor la toti pestii;
    private static void solveExercise4(List<Animal> animals, String outputFile) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal instanceof Peste) {
                double tankSize = ((Peste) animal).getTankSize();
                double doubledTankSize = tankSize * 2;
                String line = "name = " + animal.getName() + ", new tank size = "
                        + doubledTankSize + ", old tank size = " + tankSize;
                lines.add(line);
            }
        }
        Path pathFileToWrite = Paths.get(outputFile);
        Path write = Files.write(pathFileToWrite, lines);
        System.out.println("The file was written");
        System.out.println(write);
    }

    //sa scada cu un anumit nr de grade temperatura ambientala la reptile;
    private static void solveExercise5(List<Animal> animals, String outputFile, int temp) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal instanceof Reptila) {
                double surroundingTemp = ((Reptila) animal).getSurroundingTemp();
                double newSurroundingTemp = surroundingTemp - temp;
                String line = "name = " + animal.getName() + ", new surrounding temperature = "
                        + newSurroundingTemp + ", old surrounding temperature = " + surroundingTemp;
                lines.add(line);
            }
        }
//        Path pathFileToWrite = Paths.get(outputFile);
//        Files.write(Paths.get(outputFile), lines);
        Files.write(Paths.get(outputFile), lines, StandardOpenOption.APPEND);
        System.out.println("The file was written");
    }

    //la fel, sa creasca temperatura;
    private static void solveExercise6(List<Animal> animals, String outputFile, int temp) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal instanceof Reptila) {
                double surroundingTemp = ((Reptila) animal).getSurroundingTemp();
                double newSurroundingTemp = surroundingTemp + temp;
                String line = "name = " + animal.getName() + ", new surrounding temperature = "
                        + newSurroundingTemp + ", old surrounding temperature = " + surroundingTemp;
                lines.add(line);
            }
        }

//        Files.write(Paths.get(outputFile), lines);
        Files.write(Paths.get(outputFile), lines, StandardOpenOption.APPEND);
        System.out.println("The file was written");
    }

    //sa schimbe tara de provenienta a tuturor felinelor in Zambia;
    private static void solveExercise7(List<Animal> animals, String outputFile) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal instanceof Felina) {
                String country = animal.getCountry();
                String newCountry = "Zambia";
                String line = "name = " + animal.getName() + ", new country = " + newCountry + ", old country = " + country;
                lines.add(line);
            }
        }
        //    Files.write(Paths.get(outputFile), lines);
        Files.write(Paths.get(outputFile), lines, StandardOpenOption.APPEND);
        System.out.println("The file was written");
    }

    //sa modifice varsta mamiferelor, inversand ordinea cifrelor varstei actuale (12 => 21);
    private static void solveExercise8(List<Animal> animals, String outputFile) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Animal animal : animals) {

            if (animal instanceof Mamifer) {
                String ageText = String.valueOf(animal.getAge()); // transform in String valoarea varstei animalului de tip mamifer
                String reverseAgeText = new StringBuilder(ageText).reverse().toString(); // inversez valoarea de tip string a varstei mamiferului
                int reverseAge = Integer.parseInt(reverseAgeText); // transform valoarea string-ului in int ca sa scap de 0
                String line = "name = " + animal.getName() + ", new age = " + reverseAge + ", old age = " + ageText; // formatul liniei de iesire in fisier
                lines.add(line);
            }
        }
        Files.write(Paths.get(outputFile), lines, StandardOpenOption.APPEND);
        //Files.write(Paths.get(outputFile), lines);
        System.out.println("The file was written");
    }

    //sa schimbe numele animalelor care incep cu litera "A" in "Victoria";
    private static void solveExercise9(List<Animal> animals, String outputFile) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getName().startsWith("A")) {
                String oldName = animal.getName();
                String newName = "Victoria";
                String line = "name = " + animal.getName() + ", new name = " + newName + ", old name = " + oldName;
                lines.add(line);
            }
        }
        Files.write(Paths.get(outputFile), lines, StandardOpenOption.APPEND);
        //    Files.write(Paths.get(outputFile), lines);
        System.out.println("The file was written");
    }
}