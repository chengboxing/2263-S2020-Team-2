package isu.gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class NewGamePanel extends JPanel {

    MainFrame frame;
    public NewGamePanel(MainFrame frame) {
        this.frame = frame;

        Border innerBorder3 = BorderFactory.createTitledBorder("Number of Players");
        Border innerBorder2 = BorderFactory.createTitledBorder("Game Name");
        Border innerBorder1 = BorderFactory.createTitledBorder("Players");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);


        JSlider slider = new JSlider(0, 6);
        JLabel label1 = new JLabel("1. Player Name : ");
        JLabel label2 = new JLabel("2. Player Name : ");
        JLabel gameLabel = new JLabel("Game Name : ");
        JTextField gameField = new JTextField(20);
        JTextField field1 = new JTextField(10);
        JTextField field2 = new JTextField(10);
        JPanel btnPanel = new JPanel(new BorderLayout());
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel rightPanel = new JPanel(new BorderLayout());
        JPanel leftPanel = new JPanel(new BorderLayout()){
            public Dimension getPreferredSize(){
                return new Dimension(frame.getWidth()/3, frame.getHeight());
            }
        };
        JPanel leftUpperPanel = new JPanel(new BorderLayout()){
            public Dimension getPreferredSize(){
                return new Dimension(leftPanel.getWidth(), leftPanel.getHeight()/2);
            }
        };
        JPanel leftLowerPanel = new JPanel(new BorderLayout()){
            public Dimension getPreferredSize(){
                return new Dimension(leftPanel.getWidth(), leftPanel.getHeight()/2);
            }
        };
        JButton cancel = new JButton("Cancel");
        JButton start = new JButton("Start");

        leftUpperPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder2));
        leftLowerPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder3));

        leftUpperPanel.setLayout(new FlowLayout());
        leftUpperPanel.add(gameLabel);
        leftUpperPanel.add(gameField);



        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setValue(2);

        leftLowerPanel.add(slider);


        cancel.addActionListener(e -> frame.showStartPanel());
        start.addActionListener(e -> frame.showGamePanel());

        rightPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder1));

        GroupLayout lt = new GroupLayout(rightPanel);
        rightPanel.setLayout(lt);

        lt.setAutoCreateGaps(true);
        lt.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hgroup = lt.createSequentialGroup();
        hgroup.addGroup(lt.createParallelGroup().addComponent(label1).addComponent(label2));
        hgroup.addGroup(lt.createParallelGroup().addComponent(field1).addComponent(field2));
        lt.setHorizontalGroup(hgroup);

        GroupLayout.SequentialGroup vgroup = lt.createSequentialGroup();
        vgroup.addGroup(lt.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label1).addComponent(field1));
        vgroup.addGroup(lt.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label2).addComponent(field2));
        lt.setVerticalGroup(vgroup);





        setLayout(new BorderLayout());

        btnPanel.add(cancel, BorderLayout.WEST);
        btnPanel.add(start, BorderLayout.EAST);

        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        leftPanel.add(leftUpperPanel, BorderLayout.NORTH);
        leftPanel.add(leftLowerPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);


    }

}
