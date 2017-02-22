import requests.InsertRequest;
import requests.ParseXmlValues;
import requests.SelectFromDb;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

public class MainInterface extends JFrame {
    private JButton browseXMLButton;
    private JPanel rootPanel;
    private JTextField chosenXMLPath;
    private JButton checkXSD;
    private JTextField chosenXSDPath;
    private JButton browseXSDButton;
    private JButton addToDataBaseButton;
    private JButton selectFromBaseButton;
    private JTextArea valueFromDB;
    private JComboBox requestSelectBox;

    private File xsdFile;
    private File xmlFile;

    public MainInterface() {
        // stuff
        final StringBuilder s = new StringBuilder();

        // set size and visible rootPanel
        rootPanel.setPreferredSize(new Dimension(700, 500));
        setContentPane(rootPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // JComboBox and default selected Index

        requestSelectBox.insertItemAt("Select From Items", 0);
        requestSelectBox.insertItemAt("Select From Persons", 1);
        requestSelectBox.insertItemAt("Select From Ships", 2);

        requestSelectBox.setSelectedIndex(0);
        s.append(SelectFromDb.selectFromItem((DataBaseConnector.getInstance().getNewConn())));


        requestSelectBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (requestSelectBox.getSelectedIndex() == 0) {
                    s.setLength(0);
                    s.append(SelectFromDb.selectFromItem(DataBaseConnector.getInstance().getNewConn()));
                }
                if (requestSelectBox.getSelectedIndex() == 1) {
                    s.setLength(0);
                    s.append(SelectFromDb.selectFromOrderPerson(DataBaseConnector.getInstance().getNewConn()));
                }
                if (requestSelectBox.getSelectedIndex() == 2) {
                    s.setLength(0);
                    s.append(SelectFromDb.selectFromShipTo(DataBaseConnector.getInstance().getNewConn()));
                }
            }
        });

        // choose xml file
        browseXMLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jf = new JFileChooser();
                int ret = jf.showDialog(null, "Open File");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    xmlFile = jf.getSelectedFile();
                    chosenXMLPath.setText(xmlFile.getAbsolutePath());
                }
            }
        });

        // choose xsd file
        browseXSDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jf = new JFileChooser();
                int ret = jf.showDialog(null, "Open File");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    xsdFile = jf.getSelectedFile();
                    chosenXSDPath.setText(xsdFile.getAbsolutePath());
                }
            }
        });

        // xml schema validation
        checkXSD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (xmlFile == null) {
                    JOptionPane.showMessageDialog(rootPanel, "Please, choose XML File");
                } else {
                    if (xsdFile == null) {
                        JOptionPane.showMessageDialog(rootPanel, "Please, choose XSD File");
                    } else {
                        if (CheckXML.verifyXmlByXsd(xmlFile, xsdFile)) {
                            JOptionPane.showMessageDialog(rootPanel, "XML passed schema checking");
                        } else {
                            JOptionPane.showMessageDialog(rootPanel, "XSD schema isn't valid");
                        }
                    }
                }
            }
        });

        // add xml values to db
        addToDataBaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (xmlFile == null) {
                    JOptionPane.showMessageDialog(rootPanel, "Please, choose XML File");
                } else {
                    if (xsdFile == null) {
                        JOptionPane.showMessageDialog(rootPanel, "Please, choose XSD File");
                    } else {
                        try {
                            ParseXmlValues.parseXmlFile(xmlFile);
                            InsertRequest insertRequest = new InsertRequest(DataBaseConnector.getInstance().getNewConn());
                            insertRequest.insertToShipToTable();
                            insertRequest.insertToItemTable();
                            insertRequest.insertToOrderPersonTable();

/*                            InsertRequest.insertToItemTable(DataBaseConnector.getInstance().getNewConn());
                            InsertRequest.insertToOrderPersonTable(DataBaseConnector.getInstance().getNewConn());
                            InsertRequest.insertToShipToTable(DataBaseConnector.getInstance().getNewConn());*/
                            JOptionPane.showMessageDialog(rootPanel, "Values added to Database");
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });

        // select from db
        selectFromBaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (valueFromDB.isShowing()) {
                    valueFromDB.setText(s.toString());
                } else {
                    JOptionPane.showMessageDialog(rootPanel, "Choose request");
                }
            }

        });
    }
}
