package application;

import model.Animal;
import model.AnimalList;

public class MainApplication {

	public static void main(String[] args) {
		Animal animal1 = new Animal(1234, 2, "Dog", "Black and White", 'F', "Female dog found in Oliver Plunket Street in February 12th", "Klara", "Yorkshire");
		Animal animal2 = new Animal(4567, 7, "Cat", "Dark Gray", 'M', "Male cat found in the front door of the Shelter building in December 3rd", "Robby", "Persian");
		
		AnimalList animalList = new AnimalList();
		
		/* Printing an empty list */
		animalList.printAnimalListScreen();
		/* Adding animals to the list */
		animalList.addAnimal(animal1);
		animalList.addAnimal(animal2);
		/* Printing a list with some animals */
		animalList.printAnimalListScreen();
		
		/* Trying to add the same animal again */
		animalList.addAnimal(animal1);
		
		/* Removing an animal */
		animalList.removeAnimal(animal1);
		/* Printing the list to prove a removal of an animal */
		animalList.printAnimalListScreen();
	}

}
