import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;

public class ManageScreen extends JPanel {
    private JComboBox<String> survivedComboBox;
    private JComboBox<String> survivedComboBoxGender;
    private JComboBox<String> survivedComboBoxEmbarked;
    public ArrayList<Passenger> passengers = new ArrayList<Passenger>();

    public ArrayList<String> values;
    private String cabinNumberData;
    private String genderData;

    private int classNumber;
    private String wentOnDeckData;
    private String classData;

    private Integer passengerNumberMinData;
    private Integer passengerNumberMaxData;
    private String passengerNameData;
    private Integer sibSPAmountBoxData;

    private Integer parchAmountData;
    private String ticketNumberData;
    private Float minTicketPriceData;
    ;
    private Float maxTicketPriceData;

    private Image backGround;

    public void ReadData(File file) {
        String data;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Constants.PATH_TO_DATA_FILE));
            String firstLine = bufferedReader.readLine();
            while ((data = bufferedReader.readLine()) != null) {
                String[] values = data.split(",");
                Passenger passenger = null;
                if (values.length == 13) {
                    passenger = new Passenger(Integer.parseInt(values[0]), Integer.parseInt(values[1]),
                            Integer.parseInt(values[2]), (values[3] + ", " + values[4]), values[5],
                            values[6], Integer.parseInt(values[7]), Integer.parseInt(values[8]),
                            values[9], Float.parseFloat(values[10]), values[11],
                            values[12] + " ");
                } else if (values.length == 12) {
                    passenger = new Passenger(Integer.parseInt(values[0]), Integer.parseInt(values[1]),
                            Integer.parseInt(values[2]), (values[3] + ", " + values[4]), values[5],
                            values[6], Integer.parseInt(values[7]), Integer.parseInt(values[8]), values[9],
                            Float.parseFloat(values[10]), values[11], "");
                }
                passengers.add(passenger);
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ManageScreen(int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE); //this is the path to the data file
        // backGround = new ImageIcon("C:\\Users\\עומר\\Downloads\\תמונה טיטאניק.jpg").getImage();
        if (file.exists()) {
            ReadData(file);
            this.setLayout(null);
            this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);
            JLabel survivedLabel = new JLabel("Passenger Class: ");
            survivedLabel.setBounds(x, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel);
            resetToDefault();

            this.survivedComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
            this.survivedComboBox.setBounds(survivedLabel.getX() + Constants.LABEL_WIDTH, survivedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.survivedComboBox);
            this.survivedComboBox.addActionListener((e) -> {
                this.classData = this.survivedComboBox.getItemAt(this.survivedComboBox.getSelectedIndex());
                if (classData.equals(Constants.PASSENGER_CLASS_OPTIONS[1])) {
                    this.classNumber = 1;
                } else if (classData.equals(Constants.PASSENGER_CLASS_OPTIONS[2])) {
                    this.classNumber = 2;
                } else if (classData.equals(Constants.PASSENGER_CLASS_OPTIONS[3])) {
                    this.classNumber = 3;
                } else if (classData.equals(Constants.PASSENGER_CLASS_OPTIONS[0])) {
                    this.classNumber = 0;
                }
                System.out.println((classData));
            });

            JLabel survivedLabelGender = new JLabel("Gender: ");
            survivedLabelGender.setBounds(100 + Constants.COMBO_BOX_WIDTH + Constants.SPACE_BETWEEN / 4, y, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(survivedLabelGender);
            this.survivedComboBoxGender = new JComboBox<>(Constants.GENDER_TYPE);
            this.survivedComboBoxGender.setBounds(survivedLabelGender.getX() + Constants.COMBO_BOX_WIDTH, y, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.survivedComboBoxGender);
            this.genderData = Constants.GENDER_TYPE[0];
            this.survivedComboBoxGender.addActionListener((e) -> {
                this.genderData = this.survivedComboBoxGender.getItemAt(this.survivedComboBoxGender.getSelectedIndex());
                System.out.println(this.genderData);

            });

            JLabel embarkedLabel = new JLabel("Went on deck:");
            embarkedLabel.setBounds(survivedLabelGender.getX() + Constants.SPACE_BETWEEN * 2 + Constants.SPACE_BETWEEN / 2, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(embarkedLabel);
            this.survivedComboBoxEmbarked = new JComboBox<>(Constants.EMBARKED);
            this.survivedComboBoxEmbarked.setBounds(embarkedLabel.getX() + Constants.SPACE_BETWEEN + Constants.SPACE_BETWEEN / 2, y, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.survivedComboBoxEmbarked);
            this.survivedComboBoxEmbarked.addActionListener((e) -> {
                this.wentOnDeckData = this.survivedComboBoxEmbarked.getItemAt(this.survivedComboBoxEmbarked.getSelectedIndex());
                System.out.println(this.wentOnDeckData);

            });

            JLabel passengerName = new JLabel("Passenger name");
            passengerName.setBounds(x + Constants.MARGIN_FROM_LEFT, 160, Constants.LABEL_WIDTH / 2 + 50, Constants.LABEL_HEIGHT);
            this.add(passengerName);

            TextField passengerNameText = new TextField("");
            passengerNameText.setBounds(x + Constants.MARGIN_FROM_LEFT, 200, Constants.LABEL_WIDTH / 2 + 50, Constants.LABEL_HEIGHT);
            this.add(passengerNameText);

            JLabel ticketNumber = new JLabel("Ticket Number");
            ticketNumber.setBounds(x + Constants.MARGIN_FROM_LEFT, 300, Constants.LABEL_WIDTH / 2 + 50, Constants.LABEL_HEIGHT);
            this.add(ticketNumber);

            TextField ticketNumberBox = new TextField("");
            ticketNumberBox.setBounds(x + Constants.MARGIN_FROM_LEFT, 350, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(ticketNumberBox);

            JLabel cabinNumber = new JLabel("Cabin");
            cabinNumber.setBounds(x + Constants.MARGIN_FROM_LEFT + 600, y, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(cabinNumber);

            TextField cabinNumberBox = new TextField("");
            cabinNumberBox.setBounds(x + Constants.MARGIN_FROM_LEFT + 650, y, Constants.LABEL_WIDTH / 2 + 50, Constants.LABEL_HEIGHT);
            this.add(cabinNumberBox);

            JLabel sibSPAmount = new JLabel("Sibilings/Spouse");
            sibSPAmount.setBounds(x + Constants.MARGIN_FROM_LEFT, 500, Constants.LABEL_WIDTH / 2 + 50, Constants.LABEL_HEIGHT);
            this.add(sibSPAmount);

            TextField sibSPAmountBox = new TextField("");
            sibSPAmountBox.setBounds(x + Constants.MARGIN_FROM_LEFT, 550, Constants.LABEL_WIDTH / 2 + 50, Constants.LABEL_HEIGHT);
            this.add(sibSPAmountBox);
            sibSPAmountBox.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    try {
                        int value = Integer.parseInt(sibSPAmountBox.getText());
                        if (value > 9) {
                            showMessage("Please enter a number between 0-9");
                            sibSPAmountBox.setText("");
                            value = Integer.parseInt(sibSPAmountBox.getText());
                        }
                        sibSPAmountBoxData = value;
                        System.out.println("sibSPAmountData number " + value);
                    } catch (NumberFormatException exception) {
                        sibSPAmountBox.setText("");
                        sibSPAmountBoxData = Constants.DEFAULT_VALUE;
                        if (!sibSPAmountBox.getText().equals("")) {
                            showMessage("Please enter a valid number");
                        }
                    }
                }
            });

            JLabel minPassengerNumber = new JLabel("Min Passenger Number");
            minPassengerNumber.setBounds(x + Constants.MARGIN_FROM_LEFT + 450, 160, Constants.LABEL_WIDTH / 2 + 90, Constants.LABEL_HEIGHT);
            this.add(minPassengerNumber);

            TextField passengerNumberMin = new TextField("");
            passengerNumberMin.setBounds(x + Constants.MARGIN_FROM_LEFT + 450, 200, Constants.LABEL_WIDTH / 2 + 50, Constants.LABEL_HEIGHT);
            this.add(passengerNumberMin);
            passengerNumberMin.addKeyListener(new KeyAdapter() {

                public void keyReleased(KeyEvent e) {
                    try {
                        int value = Integer.parseInt(passengerNumberMin.getText());
                        if (value > Constants.MAX_PASSENGER || value < Constants.MIN_PASSENGER) {
                            passengerNumberMin.setText("");
                            showMessage("Min passenger is " + Constants.MIN_PASSENGER + " Max passenger is " + Constants.MAX_PASSENGER);
                        } else {
                            passengerNumberMinData = value;
                            System.out.println("Passenger number " + value);
                        }
                    } catch (NumberFormatException exception) {
                        passengerNumberMin.setText("");
                        passengerNumberMinData = Constants.MIN_PASSENGER;
                        if (!passengerNumberMin.getText().equals("")) {
                            showMessage("Please enter a valid number");
                        }
                    }
                }
            });

            JLabel maxPassengerNumber = new JLabel("Max Passenger Number");
            maxPassengerNumber.setBounds(x + Constants.MARGIN_FROM_LEFT + 200, 160, Constants.LABEL_WIDTH / 2 + 90, Constants.LABEL_HEIGHT);
            this.add(maxPassengerNumber);

            TextField passengerNumberMax = new TextField("");
            passengerNumberMax.setBounds(x + Constants.MARGIN_FROM_LEFT + 200, 200, Constants.LABEL_WIDTH / 2 + 50, Constants.LABEL_HEIGHT);
            this.add(passengerNumberMax);
            passengerNumberMax.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent e) {
                    try {
                        int value = Integer.parseInt(passengerNumberMax.getText());
                        if (value > Constants.MAX_PASSENGER || value < Constants.MIN_PASSENGER) {
                            passengerNumberMax.setText("");
                            showMessage("Min passenger is " + Constants.MIN_PASSENGER + " Max passenger is " + Constants.MAX_PASSENGER);
                        } else {
                            passengerNumberMaxData = value;
                            System.out.println("Passenger number " + value);
                        }
                    } catch (NumberFormatException exception) {
                        passengerNumberMax.setText("");
                        passengerNumberMaxData = Constants.MAX_PASSENGER;
                        if (!passengerNumberMax.getText().equals("")) {
                            showMessage("Please enter a valid number");
                        }
                    }
                }
            });

            JLabel minTicketLabel = new JLabel("Min Price");
            minTicketLabel.setBounds(x + Constants.MARGIN_FROM_LEFT + 700, 300, Constants.LABEL_WIDTH / 2 + 90, Constants.LABEL_HEIGHT);
            this.add(minTicketLabel);

            TextField minTicketPrice = new TextField("");
            minTicketPrice.setBounds(x + Constants.MARGIN_FROM_LEFT + 700, 350, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(minTicketPrice);
            minTicketPrice.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent e) {
                    try {
                        float value = Float.parseFloat(minTicketPrice.getText());
                        minTicketPriceData = value;
                        System.out.println("Min ticket price: " + value);
                    } catch (NumberFormatException exception) {
                        if (!minTicketPrice.getText().equals("")) {
                            showMessage("Please enter a valid number");
                        }
                        minTicketPrice.setText("");
                        minTicketPriceData = Float.parseFloat(String.valueOf(Constants.DEFAULT_VALUE));
                    }
                }
            });

            JLabel maxPriceLabel = new JLabel("Max Price");
            maxPriceLabel.setBounds(x + Constants.MARGIN_FROM_LEFT + 700, 400, Constants.LABEL_WIDTH / 2 + 90, Constants.LABEL_HEIGHT);
            this.add(maxPriceLabel);

            TextField maxTicketPrice = new TextField("");
            maxTicketPrice.setBounds(x + Constants.MARGIN_FROM_LEFT + 700, 450, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(maxTicketPrice);

            maxTicketPrice.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent e) {
                    try {
                        float value = Float.parseFloat(maxTicketPrice.getText());
                        maxTicketPriceData = value;
                        System.out.println("Max ticket price: " + value);
                    } catch (NumberFormatException exception) {
                        if (!maxTicketPrice.getText().equals("")) {
                            showMessage("Please enter a valid number");
                        }
                        maxTicketPrice.setText("");
                        maxTicketPriceData = Float.parseFloat(String.valueOf(Constants.DEFAULT_VALUE));
                    }
                }
            });

            JLabel parchAmount = new JLabel("Parch");
            parchAmount.setBounds(x + Constants.MARGIN_FROM_LEFT, 400, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(parchAmount);

            TextField parchAmountBox = new TextField("");
            parchAmountBox.setBounds(x + Constants.MARGIN_FROM_LEFT, 450, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(parchAmountBox);


            parchAmountBox.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    try {
                        int value = Integer.parseInt(parchAmountBox.getText());
                        if (value > 9) {
                            showMessage("Please enter a number between 0-9");
                            parchAmountBox.setText("");
                            value = Integer.parseInt(parchAmountBox.getText());
                        }
                        parchAmountData = value;
                        System.out.println("Parch amount: " + value);
                    } catch (NumberFormatException exception) {
                        System.out.println("Please enter a valid number");
                        parchAmountBox.setText("");
                        parchAmountData = Constants.ZERO_VALUE;
                    }
                }
            });

            JButton filter = new JButton("Filter");
            filter.setBounds(x + Constants.MARGIN_FROM_LEFT + 300, 550, Constants.LABEL_WIDTH / 2 + 50, Constants.LABEL_HEIGHT + 20);
            filter.setFont(new Font("Filter", Font.ROMAN_BASELINE, 20));
            this.add(filter);
            filter.addActionListener(e -> {

                try {
                    showMessage(Utils.searchSurvived(passengers, this.classNumber, this.genderData, this.wentOnDeckData,
                            this.passengerNumberMinData, this.passengerNumberMaxData,
                            passengerNameText.getText(), this.parchAmountData, this.sibSPAmountBoxData, ticketNumberBox.getText(),
                            this.maxTicketPriceData, this.minTicketPriceData, cabinNumberBox.getText()));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
    }

    public void resetToDefault() {
        this.wentOnDeckData = Constants.EMBARKED[0];
        this.classData = Constants.PASSENGER_CLASS_OPTIONS[0];
        this.genderData = Constants.GENDER_TYPE[0];
        this.cabinNumberData = Constants.EMPTY_STRING;
        this.classNumber = Constants.ZERO_VALUE;
        this.passengerNumberMinData = Constants.MIN_PASSENGER;
        this.passengerNumberMaxData = Constants.MAX_PASSENGER;
        this.passengerNameData = Constants.EMPTY_STRING;
        this.sibSPAmountBoxData = Constants.DEFAULT_VALUE;
        this.parchAmountData = Constants.ZERO_VALUE;
        this.ticketNumberData = Constants.EMPTY_STRING;
        this.minTicketPriceData = (float) Constants.ZERO_VALUE;
        this.maxTicketPriceData = (float) Constants.DEFAULT_VALUE;
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(backGround, 0, 0, null);
    }
}


