import java.util.ArrayList;
import java.util.List;

class Apple extends Fruit {

}

class Banana extends Fruit {

}

class FruitBasket {
    List<Fruit> apples = new ArrayList<>();
    List<Fruit> bananas = new ArrayList<>();

    FruitBasket addFruit(Fruit fruit) {
        if (fruit instanceof Apple) {
            apples.add(fruit);
        } else {
            bananas.add(fruit);
        }
        return this;
    }

    int countApples() {
        return apples.size();
    }
}

public class FruitRunner {
    public static void main(String[] args) {
        FruitBasket basket = new FruitBasket();
        FruitBasket basket2 = basket.addFruit(new Apple());
        FruitBasket basket3 = basket2.addFruit(new Banana());

        basket = basket
                    .addFruit(new Apple())
                    .addFruit(new Apple())
                    .addFruit(new Banana());
        System.out.println(basket.countApples());
    }
}
