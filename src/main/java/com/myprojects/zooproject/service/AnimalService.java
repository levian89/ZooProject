package com.myprojects.zooproject.service;

import com.myprojects.zooproject.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class AnimalService {
    //sa afiseze pe ecran animalele mai tinere de 10 ani;
    public static void solveExercise1(List<Animal> animals) {
        for (Animal animal : animals) {
            if (animal.getAge() < 10) {
                System.out.println(animal);
            }
        }
    }

    //sa afiseze pe ecran animalele a caror nume nu depaseste 5 litere;
    public static void solveExercise2(List<Animal> animals) {
        for (Animal animal : animals) {
            if (animal.getName().length() <= 5) {
                System.out.println(animal);
            }
        }
    }

    //sa afiseze pe ecran toate animalele;
    public static void solveExercise3(List<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    //sa dubleze marimea acvariilor la toti pestii;
    public static void solveExercise4(List<Animal> animals, String outputFile) throws IOException {
        List<String> lines = new ArrayList<>();
        String line = "\nDoubling the tank size of all fishes: ";
        lines.add(line);
        for (Animal animal : animals) {
            if (animal instanceof Peste) {
                double tankSize = ((Peste) animal).getTankSize();
                double doubledTankSize = tankSize * 2;
                ((Peste) animal).setTankSize(doubledTankSize);
                line = "name = " + animal.getName() + ", new tank size = "
                        + doubledTankSize + ", old tank size = " + tankSize;
                lines.add(line);
            }
        }
        Path pathFileToWrite = Paths.get(outputFile);
        boolean fileExists = Files.exists(pathFileToWrite);
        if (fileExists) {
            Files.write(Paths.get(outputFile), lines, StandardOpenOption.APPEND);
        } else {
            Files.write(Paths.get(outputFile), lines);
        }
        System.out.println("The file was written in " + pathFileToWrite);
    }

    //sa scada cu un anumit nr de grade temperatura ambientala la reptile;
    public static void solveExercise5(List<Animal> animals, String outputFile, int temp) throws IOException {
        List<String> lines = new ArrayList<>();
        String line = "\nDecreasing with " + temp + "°, the ambient temperature for all reptiles: ";
        lines.add(line);
        for (Animal animal : animals) {
            if (animal instanceof Reptila) {
                double surroundingTemp = ((Reptila) animal).getSurroundingTemp();
                double newSurroundingTemp = surroundingTemp - temp;
                ((Reptila) animal).setSurroundingTemp(newSurroundingTemp);
                line = "name = " + animal.getName() + ", new surrounding temperature = "
                        + newSurroundingTemp + ", old surrounding temperature = " + surroundingTemp;
                lines.add(line);
            }
        }
        Path pathFileToWrite = Paths.get(outputFile);
        boolean fileExists = Files.exists(pathFileToWrite);
        if (fileExists) {
            Files.write(Paths.get(outputFile), lines, StandardOpenOption.APPEND);
        } else {
            Files.write(Paths.get(outputFile), lines);
        }
        System.out.println("The file was written in " + pathFileToWrite);
    }

    //la fel, sa creasca temperatura;
    public static void solveExercise6(List<Animal> animals, String outputFile, int temp) throws IOException {
        List<String> lines = new ArrayList<>();
        String line = "\nIncreasing with " + temp + "°, the ambient temperature for all reptiles: ";
        lines.add(line);
        for (Animal animal : animals) {
            if (animal instanceof Reptila) {
                double surroundingTemp = ((Reptila) animal).getSurroundingTemp();
                double newSurroundingTemp = surroundingTemp + temp;
                ((Reptila) animal).setSurroundingTemp(newSurroundingTemp);
                line = "name = " + animal.getName() + ", new surrounding temperature = "
                        + newSurroundingTemp + ", old surrounding temperature = " + surroundingTemp;
                lines.add(line);
            }
        }
        Path pathFileToWrite = Paths.get(outputFile);
        boolean fileExists = Files.exists(pathFileToWrite);
        if (fileExists) {
            Files.write(Paths.get(outputFile), lines, StandardOpenOption.APPEND);
        } else {
            Files.write(Paths.get(outputFile), lines);
        }
        System.out.println("The file was written in " + pathFileToWrite);
    }

    //sa schimbe tara de provenienta a tuturor felinelor in Zambia;
    public static void solveExercise7(List<Animal> animals, String outputFile) throws IOException {
        List<String> lines = new ArrayList<>();
        String line = "\nChanging the country of origin all felines to Zambia: ";
        lines.add(line);
        for (Animal animal : animals) {
            if (animal instanceof Felina) {
                String country = animal.getCountry();
                String newCountry = "Zambia";
                animal.setCountry(newCountry);
                line = "name = " + animal.getName() + ", new country = " + newCountry + ", old country = " + country;
                lines.add(line);
            }
        }
        Path pathFileToWrite = Paths.get(outputFile);
        boolean fileExists = Files.exists(pathFileToWrite);
        if (fileExists) {
            Files.write(Paths.get(outputFile), lines, StandardOpenOption.APPEND);
        } else {
            Files.write(Paths.get(outputFile), lines);
        }
        System.out.println("The file was written in " + pathFileToWrite);
    }

    //sa modifice varsta mamiferelor, inversand ordinea cifrelor varstei actuale (12 => 21);
    public static void solveExercise8(List<Animal> animals, String outputFile) throws IOException {
        List<String> lines = new ArrayList<>();
        String line = "\nModifying the age of mammals by reversing the order of the current age digits: ";
        lines.add(line);
        for (Animal animal : animals) {
            if (animal instanceof Mamifer) {
                String ageText = String.valueOf(animal.getAge()); // transform in String valoarea varstei animalului de tip mamifer
                String reverseAgeText = new StringBuilder(ageText).reverse().toString(); // inversez valoarea de tip string a varstei mamiferului
                int reverseAge = Integer.parseInt(reverseAgeText); // transform valoarea string-ului in int ca sa scap de 0
                animal.setAge(reverseAge);
                line = "name = " + animal.getName() + ", new age = " + reverseAge + ", old age = " + ageText; // formatul liniei de iesire in fisier
                lines.add(line);
            }
        }
        Path pathFileToWrite = Paths.get(outputFile);
        boolean fileExists = Files.exists(pathFileToWrite);
        if (fileExists) {
            Files.write(Paths.get(outputFile), lines, StandardOpenOption.APPEND);
        } else {
            Files.write(Paths.get(outputFile), lines);
        }
        System.out.println("The file was written in " + pathFileToWrite);
    }

    //sa schimbe numele animalelor care incep cu litera "A" in "Victoria";
    public static void solveExercise9(List<Animal> animals, String outputFile) throws IOException {
        List<String> lines = new ArrayList<>();
        String line = "\nChanging the names of animals that begin with the letter \"A\" to \"Victoria\": ";
        lines.add(line);
        for (Animal animal : animals) {
            if (animal.getName().startsWith("A")) {
                String oldName = animal.getName();
                String newName = "Victoria";
                animal.setName(newName);
                line = "new name = " + newName + ", old name = " + oldName;
                lines.add(line);
            }
        }
        Path pathFileToWrite = Paths.get(outputFile);
        boolean fileExists = Files.exists(pathFileToWrite);
        if (fileExists) {
            Files.write(Paths.get(outputFile), lines, StandardOpenOption.APPEND);
        } else {
            Files.write(Paths.get(outputFile), lines);
        }
        System.out.println("The file was written in " + pathFileToWrite);
    }

    public static void solveExercise10(List<Animal> animals, String outputFile, char letter, String newName) throws IOException {
        List<String> lines = new ArrayList<>();
        String line = "\nChanging the names of animals that begin with the letter " + letter + " to " + newName + ": ";
        lines.add(line);
        for (Animal animal : animals) {
            if (animal.getName().startsWith(String.valueOf(letter))) {
                String oldName = animal.getName();
                animal.setName(newName);
                line = "new name = " + newName + ", old name = " + oldName;
                lines.add(line);
            }
        }
        Path pathFileToWrite = Paths.get(outputFile);
        boolean fileExists = Files.exists(pathFileToWrite);
        if (fileExists) {
            Files.write(Paths.get(outputFile), lines, StandardOpenOption.APPEND);
        } else {
            Files.write(Paths.get(outputFile), lines);
        }
        System.out.println("The file was written in " + pathFileToWrite);
    }
}
