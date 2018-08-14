public class AnimalShelter {
    private static class EmptyShelterException extends Exception {};
    private static class NoDogsException extends Exception {};
    private static class NoCatsException extends Exception {};
    
    private MyQueue<Animal> ageQueue = new MyQueue<Animal>();

    public static void main(String[] args) throws Exception {
        AnimalShelter shelter = new AnimalShelter();

        Dog oldestDog = new Dog();
        Dog oldDog = new Dog();
        Dog youngDog = new Dog();
        Dog babyDog = new Dog();

        Cat oldestCat = new Cat();
        Cat oldCat = new Cat();
        Cat youngCat = new Cat();
        Cat babyCat = new Cat();

        shelter.enqueue(oldestDog);
        shelter.enqueue(oldestCat);
        shelter.enqueue(oldCat);
        shelter.enqueue(youngCat);
        shelter.enqueue(oldDog);
        shelter.enqueue(youngDog);
        shelter.enqueue(babyDog);
        shelter.enqueue(babyCat);

        verify(oldestCat == shelter.dequeueCat());
        verify(oldestDog == shelter.dequeueAny());
        verify(oldDog == shelter.dequeueDog());
        verify(oldCat == shelter.dequeueAny());
    }

    public static void verify(boolean b) throws Exception {
        if (!b) 
            throw new Exception();
    }

    public boolean isEmpty() {
        return ageQueue.isEmpty();
    }

    public void enqueue(Animal a) throws Exception{
        ageQueue.push(a);
    }

    public Animal dequeueAny() throws Exception {
        if (this.isEmpty()) throw new EmptyShelterException();
        return ageQueue.pop();
    }

    public Dog dequeueDog() throws Exception {
        if (this.isEmpty()) throw new EmptyShelterException();
        SimpleStack<Cat> catBuffer = new SimpleStack<Cat>();
        while (!this.isEmpty() && ageQueue.peek() instanceof Cat)
            catBuffer.push((Cat) ageQueue.pop());
        if (this.isEmpty()) throw new NoDogsException();
        Dog temp = (Dog) ageQueue.pop();
        shiftFromTo(catBuffer, ageQueue);
        return temp;
    }

    public Cat dequeueCat() throws Exception {
        if (this.isEmpty()) throw new EmptyShelterException();
        SimpleStack<Dog> dogBuffer = new SimpleStack<Dog>();
        while (!this.isEmpty() && ageQueue.peek() instanceof Dog)
            dogBuffer.push((Dog) ageQueue.pop());
        if (this.isEmpty()) throw new NoCatsException();
        Cat temp = (Cat) ageQueue.pop();
        shiftFromTo(dogBuffer, ageQueue);
        return temp;
    }

    public static void shiftFromTo(Stack src, Stack dest) throws Exception {
        while (!src.isEmpty())
            dest.push(src.pop());
    }
}

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}