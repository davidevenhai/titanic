import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class ManageScreen extends JPanel implements ActionListener {
    private JComboBox<String> survivedComboBox;
    private JComboBox<String> survivedComboBoxGender;
    private JComboBox<String> survivedComboBoxEmbarked;
    public ArrayList<Passenger> passengers = new ArrayList<Passenger>();

    public ArrayList<String> values;
    private String cabinNumberData = "";
    private String genderData="";
    private int classNumber;
    private String wentOnDeckData;
    private Integer passengerNumberMinData;
    private Integer passengerNumberMaxData;
    private String passengerNameData;
    private Integer sibSPAmountData;
    private Integer parchAmountData;
    private String ticketNumberData;
    private Float minTicketPriceData;
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
                            values[9], Double.parseDouble(values[10]), values[11],
                            values[12] + " ");
                } else if (values.length == 12) {
                    passenger = new Passenger(Integer.parseInt(values[0]), Integer.parseInt(values[1]),
                            Integer.parseInt(values[2]), (values[3] + ", " + values[4]), values[5],
                            values[6], Integer.parseInt(values[7]), Integer.parseInt(values[8]), values[9],
                            Double.parseDouble(values[10]), values[11], "");
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
        backGround = new ImageIcon("C:\\Users\\עומר\\Downloads\\תמונה טיטאניק.jpg").getImage();

        if (file.exists()) {
            ReadData(file);
            this.setLayout(null);
            this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);
            JLabel survivedLabel = new JLabel("Passenger Class: ");
            survivedLabel.setBounds(x, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel);

            this.survivedComboBoxGender = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
            this.survivedComboBoxGender.setBounds(survivedLabel.getX() + Constants.LABEL_WIDTH, survivedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.survivedComboBoxGender);
            this.survivedComboBoxGender.addActionListener((e) -> {
                String classData = Constants.PASSENGER_CLASS_OPTIONS[0];
                classData = this.survivedComboBoxGender.getItemAt(this.survivedComboBoxGender.getSelectedIndex());
                int classNumber = 0;
                if (classData.equals(Constants.PASSENGER_CLASS_OPTIONS[1])) {
                    classNumber = 1;
                } else if (classData.equals(Constants.PASSENGER_CLASS_OPTIONS[2])) {
                    classNumber = 2;
                } else if (classData.equals(Constants.PASSENGER_CLASS_OPTIONS[3])) {
                    classNumber = 3;
                } else{
                    classData.equals(Constants.PASSENGER_CLASS_OPTIONS[0]);
                }
                System.out.println((classData));
            });

            JLabel survivedLabelGender = new JLabel("Gender: ");
            survivedLabelGender.setBounds(survivedComboBoxGender.getX() + Constants.COMBO_BOX_WIDTH + Constants.SPACE_BETWEEN / 4, y, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(survivedLabelGender);
            this.survivedComboBoxGender = new JComboBox<>(Constants.GENDER_TYPE);
            this.survivedComboBoxGender.setBounds(survivedLabelGender.getX() + Constants.COMBO_BOX_WIDTH, y, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.survivedComboBoxGender);
            this.survivedComboBoxGender.addActionListener((e) -> {
                String genderData = Constants.GENDER_TYPE[0];
                genderData = this.survivedComboBoxGender.getItemAt(this.survivedComboBoxGender.getSelectedIndex());
                System.out.println(genderData);

            });
            JLabel embarkedLabel = new JLabel("Went on deck:");
            embarkedLabel.setBounds(survivedLabelGender.getX() + Constants.SPACE_BETWEEN * 2 + Constants.SPACE_BETWEEN / 2, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(embarkedLabel);
            this.survivedComboBoxEmbarked = new JComboBox<>(Constants.EMBARKED);
            this.survivedComboBoxEmbarked.setBounds(embarkedLabel.getX() + Constants.SPACE_BETWEEN + Constants.SPACE_BETWEEN / 2, y, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.survivedComboBoxEmbarked);
            this.survivedComboBoxEmbarked.addActionListener((e) -> {
                String wentOnDeckData = Constants.EMBARKED[0];
                wentOnDeckData = this.survivedComboBoxEmbarked.getItemAt(this.survivedComboBoxEmbarked.getSelectedIndex());
                System.out.println(wentOnDeckData);

            });
            JLabel ageMin = new JLabel("Min age");
            ageMin.setBounds(x + Constants.MARGIN_FROM_LEFT + 700, 500, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(ageMin);

            TextField minAge = new TextField("");
            minAge.setBounds(x + Constants.MARGIN_FROM_LEFT + 700, 550, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(minAge);
            minAge.addActionListener(e -> {
                Integer minAgeData = 0;
                try {
                    minAgeData = Integer.parseInt(minAge.getText());
                    System.out.println(minAgeData);

                } catch (Exception exception) {
                    System.out.println("Please enter a valid number");
                }
            });

            JLabel ageMax = new JLabel("Max age");
            ageMax.setBounds(x + Constants.MARGIN_FROM_LEFT + 700, 160, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(ageMax);

            TextField maxAge = new TextField("");
            maxAge.setBounds(x + Constants.MARGIN_FROM_LEFT + 700, 200, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(maxAge);
            maxAge.addActionListener(e -> {
                Integer maxAgeData = 0;
                try {
                    maxAgeData = Integer.parseInt(maxAge.getText());
                    System.out.println(maxAgeData);

                } catch (Exception exception) {
                    System.out.println("Please enter a valid number");
                }
            });

            //Min-Max passenger labels/Text Field.
            JLabel minPassengerNumber = new JLabel("Min Passenger Number");
            minPassengerNumber.setBounds(x + Constants.MARGIN_FROM_LEFT + 450, 160, Constants.LABEL_WIDTH / 2 + 90, Constants.LABEL_HEIGHT);
            this.add(minPassengerNumber);

            TextField passengerNumberMin = new TextField("");
            passengerNumberMin.setBounds(x + Constants.MARGIN_FROM_LEFT + 450, 200, Constants.LABEL_WIDTH / 2 + 50, Constants.LABEL_HEIGHT);
            this.add(passengerNumberMin);
            passengerNumberMin.addActionListener(e -> {
                Integer passengerNumberMinData = Constants.MIN_PASSENGER;
                try {
                    passengerNumberMinData = Integer.parseInt(passengerNumberMin.getText());
                    System.out.println(passengerNumberMinData);

                } catch (Exception exception) {
                    System.out.println("Please enter a valid number");
                }
            });


            JLabel maxPassengerNumber = new JLabel("Max Passenger Number");
            maxPassengerNumber.setBounds(x + Constants.MARGIN_FROM_LEFT + 200, 160, Constants.LABEL_WIDTH / 2 + 90, Constants.LABEL_HEIGHT);
            this.add(maxPassengerNumber);

            TextField PassengerNumberMax = new TextField("");
            PassengerNumberMax.setBounds(x + Constants.MARGIN_FROM_LEFT + 200, 200, Constants.LABEL_WIDTH / 2 + 50, Constants.LABEL_HEIGHT);
            this.add(PassengerNumberMax);
            PassengerNumberMax.addActionListener(e -> {
                Integer PassengerNumberMaxData = Constants.MAX_PASSENGER;
                try {
                    PassengerNumberMaxData = Integer.parseInt(PassengerNumberMax.getText());
                    System.out.println(PassengerNumberMaxData);

                } catch (Exception exception) {
                    System.out.println("Please enter a valid number");
                }
            });

            //Passenger name;
            JLabel passengerName = new JLabel("Passenger name");
            passengerName.setBounds(x + Constants.MARGIN_FROM_LEFT, 160, Constants.LABEL_WIDTH / 2 + 50, Constants.LABEL_HEIGHT);
            this.add(passengerName);

            TextField passengerNameText = new TextField("");
            passengerNameText.setBounds(x + Constants.MARGIN_FROM_LEFT, 200, Constants.LABEL_WIDTH / 2 + 50, Constants.LABEL_HEIGHT);
            this.add(passengerNameText);

            passengerNameText.addActionListener(e -> {
                String passengerNameData = "";
                try {
                    passengerNameData = passengerNameText.getText();
                    System.out.println(passengerNameData);

                } catch (Exception exception) {
                    System.out.println("Please enter a valid name");
                }
            });

            ///Continue from here

            //Search by number of brothers (SibSP), need to let him enter numbers between 1-9
            JLabel sibSPAmount = new JLabel("Sibilings/Spouse");
            sibSPAmount.setBounds(x + Constants.MARGIN_FROM_LEFT, 500, Constants.LABEL_WIDTH / 2 + 50, Constants.LABEL_HEIGHT);
            this.add(sibSPAmount);

            TextField sibSPAmountBox = new TextField("");
            sibSPAmountBox.setBounds(x + Constants.MARGIN_FROM_LEFT, 550, Constants.LABEL_WIDTH / 2 + 50, Constants.LABEL_HEIGHT);
            this.add(sibSPAmountBox);
            sibSPAmountBox.addActionListener(e -> {
                Integer sibSPAmountData = 0;
                try {
                    sibSPAmountData = Integer.parseInt(sibSPAmountBox.getText());
                    System.out.println(sibSPAmountData);

                } catch (Exception exception) {
                    System.out.println("Please enter a valid number");
                }
            });

            //Search by number of parents/childrens (Parch)
            JLabel parchAmount = new JLabel("Parch");
            parchAmount.setBounds(x + Constants.MARGIN_FROM_LEFT, 400, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(parchAmount);

            TextField parchAmountBox = new TextField("");
            parchAmountBox.setBounds(x + Constants.MARGIN_FROM_LEFT, 450, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(parchAmountBox);
            parchAmountBox.addActionListener(e -> {
                try {
                    Integer parchAmountData = 0;
                    parchAmountData = (Integer.parseInt(parchAmountBox.getText()));
                    System.out.println(parchAmountData);

                } catch (Exception exception) {
                    System.out.println("Please enter a valid number");
                }
            });


            //Search by Ticket Number (שי רצה לפי מספר אבל בפועל זה סטרינג בקובץ אקסל)
            JLabel ticketNumber = new JLabel("Ticket Number");
            ticketNumber.setBounds(x + Constants.MARGIN_FROM_LEFT, 300, Constants.LABEL_WIDTH / 2 + 50, Constants.LABEL_HEIGHT);
            this.add(ticketNumber);

            TextField ticketNumberBox = new TextField("");
            ticketNumberBox.setBounds(x + Constants.MARGIN_FROM_LEFT, 350, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(ticketNumberBox);
            ticketNumberBox.addActionListener(e -> {
                String ticketNumberData = "";
                try {
                    ticketNumberData = ticketNumberBox.getText();
                    System.out.println(ticketNumberData);

                } catch (Exception exception) {
                    System.out.println("Please enter a ticket number");
                }
            });

            //Min-Max ticket price labels/Text Field.
            JLabel minTicketLabel = new JLabel("Min Price");
            minTicketLabel.setBounds(x + Constants.MARGIN_FROM_LEFT + 700, 300, Constants.LABEL_WIDTH / 2 + 90, Constants.LABEL_HEIGHT);
            this.add(minTicketLabel);

            TextField minTicketPrice = new TextField("");
            minTicketPrice.setBounds(x + Constants.MARGIN_FROM_LEFT + 700, 350, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(minTicketPrice);
            minTicketPrice.addActionListener(e -> {
                Float minTicketPriceData = 0f;
                try {
                    minTicketPriceData = Float.parseFloat(minTicketPrice.getText());
                    System.out.println(minTicketPriceData);

                } catch (Exception exception) {
                    System.out.println("Please enter a valid price");
                }
            });

            JLabel maxPriceLabel = new JLabel("Max Price");
            maxPriceLabel.setBounds(x + Constants.MARGIN_FROM_LEFT + 700, 400, Constants.LABEL_WIDTH / 2 + 90, Constants.LABEL_HEIGHT);
            this.add(maxPriceLabel);

            TextField maxTicketPrice = new TextField("");
            maxTicketPrice.setBounds(x + Constants.MARGIN_FROM_LEFT + 700, 450, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(maxTicketPrice);
            maxTicketPrice.addActionListener(e -> {
                try {
                    Float maxTicketPriceData = 0f;
                    maxTicketPriceData = Float.parseFloat(maxTicketPrice.getText());
                    System.out.println(maxTicketPriceData);

                } catch (Exception exception) {
                    System.out.println("Please enter a valid price");
                }
            });

            //Search by Cabin Number (שי רצה לפי מספר אבל בפועל זה סטרינג בקובץ אקסל)
            JLabel cabinNumber = new JLabel("Cabin");
            cabinNumber.setBounds(x + Constants.MARGIN_FROM_LEFT + 600, y, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(cabinNumber);

            TextField cabinNumberBox = new TextField("");
            cabinNumberBox.setBounds(x + Constants.MARGIN_FROM_LEFT + 650, y, Constants.LABEL_WIDTH / 2 + 50, Constants.LABEL_HEIGHT);
            this.add(cabinNumberBox);
            cabinNumberBox.addActionListener(e -> {
                String cabinNumberData = "דש";
                try {
                    cabinNumberData = cabinNumberBox.getText();
                    System.out.println(cabinNumberData);

                } catch (Exception exception) {
                    System.out.println("Please enter a valid cabin number");
                }
            });

            JButton filter = new JButton("Filter");
            filter.setBounds(x + Constants.MARGIN_FROM_LEFT + 300, 550, Constants.LABEL_WIDTH / 2 + 50, Constants.LABEL_HEIGHT + 20);
            filter.setFont(new Font("Filter", Font.ROMAN_BASELINE, 20));
            this.add(filter);

            filter.addActionListener(e -> {
                searchSurvived(passengers, classNumber, genderData, wentOnDeckData, passengerNumberMinData,
                        passengerNumberMaxData, passengerNameData, parchAmountData, sibSPAmountData, ticketNumberData,
                        maxTicketPriceData, minTicketPriceData, cabinNumberData);
            });
        }
    }

    public void searchSurvived(ArrayList<Passenger> passenger, int classNumber, String genderData, String wentOnDeck,
                               Integer passengerNumberMinData, Integer passengerNumberMaxData, String passengerNameData,
                               Integer parchAmountData, Integer sibSPAmountData, String ticketNumberData, Float maxTicketPriceData,
                               Float minTicketPriceData, String cabinNumberData) {

        ArrayList<Passenger> filteredPassengers = new ArrayList<Passenger>();
        for (int i = 0; i < this.passengers.size(); i++) {
            if ((this.passengers.get(i).getpClass() == classNumber) && (this.passengers.get(i).getGender().equals(genderData))
                    && (this.passengers.get(i).getCabin().equals(wentOnDeck)) && (this.passengers.get(i).getId() >= passengerNumberMinData)
                    && (this.passengers.get(i).getId() <= passengerNumberMaxData) && (this.passengers.get(i).getName().contains(passengerNameData))
                    && (this.passengers.get(i).getParch() <= parchAmountData) && (this.passengers.get(i).getSibSp() == sibSPAmountData)
                    && (this.passengers.get(i).getTicket().contains(ticketNumberData)) && (this.passengers.get(i).getFare() >= minTicketPriceData
                    && (this.passengers.get(i).getFare() <= maxTicketPriceData)) && (this.passengers.get(i).getCabin().contains(cabinNumberData))) {
                filteredPassengers.add(passengers.get(i));
            }
        }
        System.out.println(filteredPassengers);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(backGround, 0, 0, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
//TextField passengerName = new TextField("");
//            passengerName.setBounds(x + Constants.MARGIN_FROM_LEFT * 2, y + 70, Constants.LABEL_WIDTH * 2, Constants.LABEL_HEIGHT);
//            this.add(passengerName); מיועד לאביחי, זה הטקסט שמעל הלוח בחירה שלו

