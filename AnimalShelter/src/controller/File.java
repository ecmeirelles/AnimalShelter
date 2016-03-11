package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import model.Animal;
import model.AnimalList;
import model.Category;
import model.LostAnimal;

public class File {
	
	public void writeInFile(String fileName, String text) throws FileNotFoundException {
	    
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
	        bw.write(text);
	        bw.newLine();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public AnimalList readFile(String textFile) throws FileNotFoundException, IOException {
		AnimalList animalList = new AnimalList();

       	BufferedReader input =  new BufferedReader(new FileReader(textFile));
        String line = null;
        
        while((line = input.readLine()) != null) {
        	String values[] = line.split("\t");
        	
        	Animal animal = new Animal();
        	animal.setAnimalId(Integer.parseInt(values[0]));
        	animal.setAnimalName(values[1]);
        	
        	Category category = new Category();
        	category.setDate(LocalDate.parse(values[2]));
        	animal.setAnimalCategory(category);
        	
        	LostAnimal lostAnimal = new LostAnimal(category.getDate(), null);
        	lostAnimal.setLostLocation(values[3]);
        	
        	animal.setAnimalDescription(values[4]);
        	
        	animalList.addAnimal(animal);
        }
        
        animalList.printAnimalListScreen();
        input.close();
        
        return animalList;
    }
}