/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.*;
/**
 *
 * @author alina
 */

public class MainFrame extends JFrame{
    private Dish currentDish = new NordRagu();
    private List<String> selectedModifiers = new ArrayList<>();
    
    private JCheckBox fireSauceCB = new JCheckBox("Огненный соус (+10)");
    private JCheckBox doubleVenisonCB = new JCheckBox("Двойная порция оленины (+20)");
    private JCheckBox snowBerriesCB = new JCheckBox("Снежные ягоды (+6)");
    private JCheckBox northBreadCB = new JCheckBox("Норвежская лепешка (+7)");
    
    private JTextArea orderHistory = new JTextArea(10, 40);
    private JLabel currentOrderLabel = new JLabel("Текущий заказ: Нордское рагу (50)");
    private JButton orderButton = new JButton("Оформить заказ");
    
    private List<JCheckBox> allCheckboxes;

    public MainFrame() {
        setTitle("Заказ Нордского рагу");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        allCheckboxes = List.of(fireSauceCB, doubleVenisonCB, snowBerriesCB, northBreadCB);
        
        JPanel modifiersPanel = new JPanel(new GridLayout(4, 1));
        modifiersPanel.setBorder(BorderFactory.createTitledBorder("Добавки (не более 3)"));
        modifiersPanel.add(fireSauceCB);
        modifiersPanel.add(doubleVenisonCB);
        modifiersPanel.add(snowBerriesCB);
        modifiersPanel.add(northBreadCB);
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(currentOrderLabel, BorderLayout.CENTER);
        topPanel.add(orderButton, BorderLayout.EAST);
        
        JScrollPane historyScroll = new JScrollPane(orderHistory);
        historyScroll.setBorder(BorderFactory.createTitledBorder("Свиток заказа"));
        orderHistory.setEditable(false);
        
        add(topPanel, BorderLayout.NORTH);
        add(modifiersPanel, BorderLayout.CENTER);
        add(historyScroll, BorderLayout.SOUTH);
        
        ItemListener checkBoxListener = e -> updateCurrentOrder();
        for (JCheckBox cb : allCheckboxes) {
            cb.addItemListener(checkBoxListener);
        }
        
        orderButton.addActionListener(e -> placeOrder());
        
        pack();
        setLocationRelativeTo(null);
    }
    
    private void updateCurrentOrder() {
        int selectedCount = 0;
        for (JCheckBox cb : allCheckboxes) {
            if (cb.isSelected()) selectedCount++;
        }

        if (selectedCount >= 3) {
            for (JCheckBox cb : allCheckboxes) {
                if (!cb.isSelected()) cb.setEnabled(false);
            }
        } else {
            for (JCheckBox cb : allCheckboxes) {
                cb.setEnabled(true);
            }
        }
        
        currentDish = new NordRagu();
        selectedModifiers.clear();
        
        if (fireSauceCB.isSelected()) {
            currentDish = new FireSauce(currentDish);
            selectedModifiers.add("Огненный соус");
        }
        if (doubleVenisonCB.isSelected()) {
            currentDish = new DoubleVenison(currentDish);
            selectedModifiers.add("Двойная порция оленины");
        }
        if (snowBerriesCB.isSelected()) {
            currentDish = new SnowBerries(currentDish);
            selectedModifiers.add("Снежные ягоды");
        }
        if (northBreadCB.isSelected()) {
            currentDish = new NorthBread(currentDish);
            selectedModifiers.add("Норвежская лепешка");
        }
        
        currentOrderLabel.setText("Текущий заказ: " + currentDish.getDescription() + 
                                  " (" + currentDish.getPrice() + " септимов)");
    }
    
    private void placeOrder() {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String orderEntry = time + " | " + currentDish.getDescription() + 
                           " | " + currentDish.getPrice() + " септимов\n";
        orderHistory.append(orderEntry);

        for (JCheckBox cb : allCheckboxes) {
            cb.setSelected(false);
            cb.setEnabled(true);
        }
        currentDish = new NordRagu();
        selectedModifiers.clear();
        currentOrderLabel.setText("Текущий заказ: Нордское рагу (50 септимов)");
    }
    
}
