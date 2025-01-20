package src;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HotDogApp extends JFrame {
    private final HotDogRepository repository;
    private final DefaultListModel<String> listModel;

    public HotDogApp() {
        repository = new HotDogRepository();
        listModel = new DefaultListModel<>();

        setTitle("HotDog Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Панель управления
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 4));

        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        JButton sortButton = new JButton("Sort");
        JButton refreshButton = new JButton("Refresh");

        controlPanel.add(addButton);
        controlPanel.add(removeButton);
        controlPanel.add(sortButton);
        controlPanel.add(refreshButton);

        add(controlPanel, BorderLayout.NORTH);

        // Список хот-догов
        JList<String> hotDogList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(hotDogList);
        add(scrollPane, BorderLayout.CENTER);

        // Обработчики кнопок
        addButton.addActionListener(e -> addHotDog());
        removeButton.addActionListener(e -> removeHotDog(hotDogList.getSelectedIndex()));
        sortButton.addActionListener(e -> sortHotDogs());
        refreshButton.addActionListener(e -> refreshList());

        // Инициализация данных
        refreshList();
    }

    private void addHotDog() {
        String[] options = {"HunterDog", "MasterDog", "Berlinka"};
        String choice = (String) JOptionPane.showInputDialog(
                this,
                "Select a HotDog type:",
                "Add HotDog",
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );

        if (choice != null) {
            switch (choice) {
                case "HunterDog" -> repository.addHotDog(new HunterDog());
                case "MasterDog" -> repository.addHotDog(new MasterDog());
                case "Berlinka" -> repository.addHotDog(new Berlinka());
            }
            refreshList();
        }
    }

    private void removeHotDog(int index) {
        if (index >= 0) {
            repository.removeHotDog(index);
            refreshList();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a HotDog to remove.");
        }
    }

    private void sortHotDogs() {
        List<HotDog> hotDogs = repository.getAllHotDogs();
        hotDogs.sort((a, b) -> Double.compare(a.getPrice(), b.getPrice()));
        repository.setHotDogs(hotDogs);
        refreshList();
    }

    private void refreshList() {
        listModel.clear();
        for (HotDog hotDog : repository.getAllHotDogs()) {
            listModel.addElement(hotDog.getName() + " - " + hotDog.getPrice() + " руб.");
        }
    }
}
