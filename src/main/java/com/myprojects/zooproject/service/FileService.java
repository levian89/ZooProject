package com.myprojects.zooproject.service;

import com.myprojects.zooproject.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public static List<Animal> readAnimals(String inputFilePath) throws IOException {
        List<Animal> animals = new ArrayList<>();

        Path pathFileToRead = Paths.get(inputFilePath);
        List<String> lines = Files.readAllLines(pathFileToRead);
        for (String line : lines) {
            String[] parts = line.split(",");
            String animalType = parts[0];
            String name = parts[1];
            int age = Integer.parseInt(parts[2]); // Schimb string-ul de tip age in integer
            String country = parts[3];

            switch (animalType) {
                case "Felina":
                    Felina felina = new Felina(name, age, country);
                    animals.add(felina);
                    break;
                case "Peste":
                    double tankSize = Double.parseDouble(parts[4]);  // Schimb string-ul de tip tankSize in double
                    Peste peste = new Peste(name, age, country, tankSize);
                    animals.add(peste);
                    break;
                case "Reptila":
                    double surroundingTemp = Double.parseDouble(parts[4]);  // Schimb string-ul de tip surroundingTemp in double
                    Reptila reptila = new Reptila(name, age, country, surroundingTemp);
                    animals.add(reptila);
                    break;
                case "Arahnida":
                    Arahnida arahnida = new Arahnida(name, age, country);
                    animals.add(arahnida);
                    break;
                case "Mamifer":
                    Mamifer mamifer = new Mamifer(name, age, country);
                    animals.add(mamifer);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown animal");
            }
        }
//        System.out.println(animals);
        return animals;
    }
}
