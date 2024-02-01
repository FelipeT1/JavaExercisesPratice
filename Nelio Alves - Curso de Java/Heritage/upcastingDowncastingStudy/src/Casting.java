public class Casting {
    public static void main(String[] args) {
        Animal animalIsAnimal = new Animal();

        Animal dogIsAnimal = new Dog();

        Animal catIsAnimal = new Cat();

        doAnimalStuff(animalIsAnimal);
        doAnimalStuff(dogIsAnimal);
        doAnimalStuff(catIsAnimal);

    }

    // This method expects an Animal, but every child class of Animal IS an animal
    // Thus: we've created a method that basically accepts any object as long as this object is an Animal.
    // Instead of creating a method for each class to make the specif noise.
    public static void doAnimalStuff(Animal animal){
        //Every animal makes a noise, since dog and cat ARE animals they make their own noises
        animal.makeNoise();
        // Checks if animal is really an instance of Dog, otherwise will cause an exception
        if(animal instanceof Dog){
            //Basically says "trust me bro i KNOW that animal is a instance of Dog
            Dog dog = (Dog) animal;
            dog.rosnar();
        }
    }
}
