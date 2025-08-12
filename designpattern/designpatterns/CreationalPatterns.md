## Singleton Pattern
Ensures only one instance of a class exists.
```
public class Singleton {
    private static Singleton instance;

    private Singleton() {} // private constructor

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

## Factory Method Pattern
Creates objects without exposing the instantiation logic.
```
interface Animal {
    void speak();
}

class Dog implements Animal {
    public void speak() { System.out.println("Woof!"); }
}

class AnimalFactory {
    public static Animal getAnimal(String type) {
        return switch (type) {
            case "dog" -> new Dog();
            default -> throw new IllegalArgumentException("Unknown animal");
        };
    }
}
```

## Abstract Factory Pattern
Creates families of related objects without specifying their concrete classes.
```
interface Button {
    void render();
}

class WindowsButton implements Button {
    public void render() { System.out.println("Windows Button"); }
}

interface GUIFactory {
    Button createButton();
}

class WindowsFactory implements GUIFactory {
    public Button createButton() { return new WindowsButton(); }
}
```

## Builder Pattern
Constructs complex objects step-by-step.
```
class Pizza {
    private String dough;
    private String topping;

    public static class Builder {
        private final Pizza pizza = new Pizza();

        public Builder dough(String dough) {
            pizza.dough = dough;
            return this;
        }

        public Builder topping(String topping) {
            pizza.topping = topping;
            return this;
        }

        public Pizza build() {
            return pizza;
        }
    }
}
```

## Prototype Pattern
Clones existing objects instead of creating new ones from scratch.
```
class Sheep implements Cloneable {
    String name;

    Sheep(String name) { this.name = name; }

    public Sheep clone() throws CloneNotSupportedException {
        return (Sheep) super.clone();
    }
}
```