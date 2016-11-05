package fruit;

public class FruitStand {
	
	public static void main(String[] args){
		
		Fruit fruit1 = new Orange();
		Fruit fruit2 = new Peach();
		
		System.out.println("Fruit 1 is a " + fruit1.getName());
		System.out.println("Fruit 2 is a " + fruit2.getName());
	}

}
