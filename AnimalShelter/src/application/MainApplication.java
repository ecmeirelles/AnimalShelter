package application;

import model.Animal;
import model.AnimalList;
import model.Person;

public class MainApplication {

	public static void main(String[] args) {
		/* Creating new instances of Person */
		Person person1 = new Person("Victoria Hamptom", "320 Curraheen Rd, Cork", "+353898456974", "victoriahamptom@gmail.com");
		Person person2 = new Person("Klauss Manning", "515 Woodbine Rd, Dublin", "+353808796542", "klaussmanning@gmail.com");
		
		/* Printing their details */
		person1.printPersonScreen();
		person2.printPersonScreen();
		
		/* Creating new instances of Animal */
		Animal animal1 = new Animal(1234, 2, "Dog", "Black and White", 'F', "Female dog found in Oliver Plunket Street in February 12th", "Klara", "Yorkshire");
		Animal animal2 = new Animal(4567, 7, "Cat", "Dark Gray", 'M', "Male cat found in the front door of the Shelter building in December 3rd", "Robby", "Persian");
		Animal animal3 = new Animal(7890, 4, "Dog", "Caramel", 'M', "Male dog available for adoption", "Rex", "Pibull");
		/* Creating an animal list */
		AnimalList animalList = new AnimalList();
		
		/* Printing an empty list */
		animalList.printAnimalListScreen();
		/* Adding animals to the list */
		animalList.addAnimal(animal1);
		animalList.addAnimal(animal2);
		animalList.addAnimal(animal3);
		/* Printing a list with some animals */
		animalList.printAnimalListScreen();
		
		/* Trying to add the same animal again */
		animalList.addAnimal(animal1);
		
		/* Removing an animal */
		animalList.removeAnimal(animal2);
		/* Printing the list to prove a removal of an animal */
		animalList.printAnimalListScreen();
	}
}
