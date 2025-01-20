package src;

/**
 * Представляет базовый хот-дог с названием и ценой.
 */
class HotDog {
    private String name;
    private double price;

    public HotDog(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
