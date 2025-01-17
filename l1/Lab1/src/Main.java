import java.util.ArrayList;
import java.util.List;

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

/**
 * Класс, представляющий хот-дог типа HunterDog.
 */
class HunterDog extends HotDog {
    public HunterDog() {
        super("HunterDog", 3.50);
    }
}

/**
 * Класс, представляющий хот-дог типа MasterDog.
 */
class MasterDog extends HotDog {
    public MasterDog() {
        super("MasterDog", 4.00);
    }
}

/**
 * Класс, представляющий хот-дог типа Berlinka.
 */
class Berlinka extends HotDog {
    public Berlinka() {
        super("Berlinka", 4.80);
    }
}

/**
 * Класс для управления заказами хот-догов, расчета общей и средней стоимости.
 */
class Order {
    private List<HotDog> hotDogs = new ArrayList<>();

    // Метод для добавления хот-дога в заказ
    public void addHotDog(HotDog hotDog) {
        hotDogs.add(hotDog);
    }

    // Метод для расчета общей стоимости заказа
    public double getTotalPrice() {
        double total = 0;
        for (HotDog hotDog : hotDogs) {
            total += hotDog.getPrice();
        }
        return total;
    }

    // Метод для получения общего количества хот-догов в заказе
    public int getTotalHotDogs() {
        return hotDogs.size();
    }

    // Метод для расчета средней стоимости хот-догов в заказе
    public double getAveragePrice() {
        if (hotDogs.isEmpty()) {
            return 0;
        }
        return getTotalPrice() / hotDogs.size();
    }
}

/**
 * Главный класс для демонстрации работы системы заказов хот-догов.
 */
public class Main {
    public static void main(String[] args) {
        Order order = new Order();

        // Добавление хот-догов в заказ
        order.addHotDog(new HunterDog());
        order.addHotDog(new MasterDog());
        order.addHotDog(new Berlinka());

        // Вывод информации о заказе
        System.out.println("Общее количество хот-догов: " + order.getTotalHotDogs());
        System.out.println("Общая стоимость заказа: " + order.getTotalPrice() + " рублей");
        System.out.printf("Средняя стоимость хот-догов: %.2f рублей%n", order.getAveragePrice());
    }
}