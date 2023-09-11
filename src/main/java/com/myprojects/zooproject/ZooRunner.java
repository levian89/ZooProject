package com.myprojects.zooproject;


import com.myprojects.zooproject.model.*;
import com.myprojects.zooproject.service.FileService;
import org.jetbrains.annotations.NotNull;

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
     //   List<Animal> animals = readAnimals(path);
        List<Animal> animals = FileService.readAnimals(inputFilePath);
      //  System.out.println(animals);
//        Felina felina = new Felina("Amber", 12, "Zimbabwe");
//        System.out.println(felina);
//        Felina felina1 = new Felina("Simba", 8, "Congo");


//        System.out.println(felina1);
//        Felina felina2 = new Felina("Felina","Nala",12, "Congo");
//        System.out.println(felina2);
//        Peste peste = new Peste("Nemo", 2, "Pacific", 2.0);
//        System.out.println(peste);
//        Peste peste1 = new Peste("Peste", "Dori", 10,"Pacific", 10.5);
//        System.out.println(peste1);
//        Peste peste2 = new Peste("Peste", "Gigantomenia", 23,"Arctic", 33.6);
//        System.out.println(peste2);
//        Reptila reptila = new Reptila("Reptila","Joseph",3,"Australia",16.0);
//        System.out.println(reptila);
//        Reptila reptila1 = new Reptila("Reptila","Astela",14,"Filipine",17.5);
//        System.out.println(reptila1);
//        Reptila reptila2 = new Reptila("Reptila","Vampirita",11,"Patagonia",15.3);
//        System.out.println(reptila2);
//        Arahnida arahnida = new Arahnida("Arahnida","Spinner",1,"Australia");
//        System.out.println(arahnida);
//        Mamifer mamifer = new Mamifer("Mamifer","Rudolf",125, "Groenlanda");
//        System.out.println(mamifer);
//        Mamifer mamifer1 = new Mamifer("Mamifer","Natasha",20, "Rusia");
//        System.out.println(mamifer1);

//        felina1.printAnimalsYoungerThan10();


//        animals.add(felina);
//        animals.add(peste);




        Scanner scanner = new Scanner(System.in);
        int indexCommand;
        do {
            System.out.println("Dati index comanda: 0 pentru iesire din aplicatie");
            indexCommand = scanner.nextInt();
            switch (indexCommand) {
                case 0:
                    System.out.println("Exiting application");
                    break;
                case 1:
                    solveExercise1(animals);
                    break;
                case 2:
                    solveExercise2(animals);
                    break;
                case 3:
                    solveExercise3(animals);
                    break;
                case 4:
                    solveExercise4(animals, outputFilePath);
//                    fara append
                    break;
                case 5:
                    solveExercise5(animals, outputFilePath);
                    break;
                case 6:
                    solveExercise6(animals, outputFilePath);
                    break;
                case 7:
                    solveExercise7(animals, outputFilePath);
                    break;
                case 8:
                    solveExercise8(animals, outputFilePath);
                    // la toate celelalte pui cu append
                    break;
                case 9:
                    solveExercise9(animals, outputFilePath);
                    break;
                default:
                    System.out.println("Comanda necunoscuta");
            }
        } while (indexCommand != 0);

    }


    // sa schimbe numele animalelor care incep cu litera "A" in "Victoria";
    private static void solveExercise9(List<Animal> animals, String outputFile) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Animal animal : animals) {
            if(animal.getName().startsWith("A")) {
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

    //sa modifice varsta mamiferelor, inversand ordinea cifrelor varstei actuale (12 => 21);
    private static void solveExercise8(List<Animal> animals, String outputFile) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Animal animal : animals) {
//            if(animal.getClass().getSimpleName().equals("Mamifer")){
//                    Mamifer m = (Mamifer) animal;
//        }
            if (animal instanceof Mamifer) {
                String ageText = String.valueOf(animal.getAge()); // transform in String valoarea varstei animalului de tip mamifer
                String reverseAgeText = new StringBuilder(ageText).reverse().toString(); // inversez valoarea de tip string a varstei mamiferului
                int reverseAge = Integer.parseInt(reverseAgeText); // transform valoarea string-ului in int ca sa scap de 0
                String line = "name = " + animal.getName() + ", new age = " + reverseAge + ", old age = " + ageText; // formatul liniei de iesire in fisier
                lines.add(line);
            }
//            if (animal instanceof Mamifer) {
//                int initialAge = animal.getAge();
//                int temp = initialAge;
//                int reverseAge = 0;
//                while (initialAge>0) {
//                   int r = initialAge % 10;
//                   reverseAge = (reverseAge * 10) + r;
//                   initialAge = initialAge /10;
//                }
//                String line = "name = " + animal.getName() + ", new age = " + reverseAge + ", old age = " + temp;
//                lines.add(line);
//            }
        }
        Files.write(Paths.get(outputFile), lines, StandardOpenOption.APPEND);
        //Files.write(Paths.get(outputFile), lines);
        System.out.println("The file was written");
    }

    // sa schimbe tara de provenienta a tuturor felinelor in Zambia;
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

    // sa creasca cu un anumit nr de grade temperatura ambientala la reptile;
    private static void solveExercise6(List<Animal> animals, String outputFile) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal instanceof Reptila) {
                double surroundingTemp = ((Reptila) animal).getSurroundingTemp();
                double newSurroundingTemp = surroundingTemp + 5;
                String line = "name = " + animal.getName() + ", new surrounding temperature = " + newSurroundingTemp + ", old surrounding temperature = " + surroundingTemp;
                lines.add(line);
            }
        }
        Files.write(Paths.get(outputFile), lines, StandardOpenOption.APPEND);
        //    Files.write(Paths.get(outputFile), lines);
        System.out.println("The file was written");
    }

    // sa scada cu un anumit nr de grade temperatura ambientala la reptile;
    private static void solveExercise5(List<Animal> animals, String outputFile) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal instanceof Reptila) {
                double surroundingTemp = ((Reptila) animal).getSurroundingTemp();
                double newSurroundingTemp = surroundingTemp - 5;
                String line = "name = " + animal.getName() + ", new surrounding temperature = " + newSurroundingTemp + ", old surrounding temperature = " + surroundingTemp;
                lines.add(line);
            }
        }
        Path pathFileToWrite = Paths.get(outputFile);
        Files.write(pathFileToWrite, lines, StandardOpenOption.APPEND);
    //    Files.write(Paths.get(outputFile), lines);
        System.out.println("The file was written");
    }


    // sa dubleze marimea acvariilor la toti pestii;
    private static void solveExercise4(List<Animal> animals, String outputFile) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Animal animal : animals) {

//            if(animal.getClass().getSimpleName().equals("Peste")) {
//                double tankSize = ((Peste) animal).getTankSize();
//                double doubledTankSize = tankSize * 2;
//                String line = "name = " + animal.getName() + ", new tank size = " + doubledTankSize + ", old tank size = " + tankSize;
//                lines.add(line);
//            }
            if (animal instanceof Peste) {
                double tankSize = ((Peste) animal).getTankSize();
                double doubledTankSize = tankSize * 2;
                String line = "name = " + animal.getName() + ", new tank size = " + doubledTankSize + ", old tank size = " + tankSize;
                lines.add(line);
            }
        }
        Path pathFileToWrite = Paths.get(outputFile);
        Path write = Files.write(pathFileToWrite, lines);
        System.out.println("The file was written");
        System.out.println(write);
    }


    private static void solveExercise3(List<Animal> animals) {
        for (Animal animal : animals) {
                System.out.println(animal);
        }
    }

    private static void solveExercise2(List<Animal> animals) {
        for (Animal animal : animals) {
            if (animal.getName().length() <= 5) {
                System.out.println(animal);
            }
        }
    }

    private static void solveExercise1(List<Animal> animals) {
        for (Animal animal : animals) {
            if (animal.getAge() < 10) {
                System.out.println(animal);
            }
        }
    }

//    private static List<Animal> readAnimals(String inputFilePath) throws IOException {
//        List<Animal> animals = new ArrayList<>();
//
//        Path pathFileToRead = Paths.get(inputFilePath);
//        List<String> lines = Files.readAllLines(pathFileToRead);
//        for (String line : lines) {
//            String[] parts = line.split(","); // Divizez linia respectiva cu string-uri dupa virgula
//            String animalType = parts[0];
//            String name = parts[1];
//            int age = Integer.parseInt(parts[2]); // Schimb string-ul de tip age in integer
//            String country = parts[3];
//
//            switch (animalType) {
//                case "Felina":
//                    Felina felina = new Felina(name, age, country);
//                    animals.add(felina);
//                    break;
//                case "Peste":
//                    double tankSize = Double.parseDouble(parts[4]);  // Schimb string-ul de tip tankSize in double
//                    Peste peste = new Peste(name, age, country, tankSize);
//                    animals.add(peste);
//                    break;
//                case "Reptila":
//                    double surroundingTemp = Double.parseDouble(parts[4]);  // Schimb string-ul de tip surroundingTemp in double
//                    Reptila reptila = new Reptila(name, age, country, surroundingTemp);
//                    animals.add(reptila);
//                    break;
//                case "Arahnida":
//                    Arahnida arahnida = new Arahnida(name, age, country);
//                    animals.add(arahnida);
//                    break;
//                case "Mamifer":
//                    Mamifer mamifer = new Mamifer(name, age, country);
//                    animals.add(mamifer);
//                    break;
//                default:
//                    throw new IllegalArgumentException("Unknown animal");
//            }
//        }
//        return animals;
//    }
}