import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ManageScreen extends JPanel {
    private JComboBox<String> survivedComboBox;
    private JComboBox<String> survivedComboBoxSex;
    private JComboBox<String> survivedComboBoxEmbarked;
    public ArrayList<Passenger> passengers = new ArrayList<Passenger>();

    public ArrayList<String> values;

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
        backGround=new ImageIcon("C:\\Users\\עומר\\Downloads\\תמונה טיטאניק.jpg").getImage();

        if (file.exists()) {
            ReadData(file);
            this.setLayout(null);
            this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);
            JLabel survivedLabel = new JLabel("Passenger Class: ");
            survivedLabel.setBounds(x, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel);

            this.survivedComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
            this.survivedComboBox.setBounds(survivedLabel.getX() + Constants.LABEL_WIDTH, survivedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.survivedComboBox);
            this.survivedComboBox.addActionListener((e) -> {

            });

            JLabel survivedLabelSex = new JLabel("Gender: ");
            survivedLabelSex.setBounds(survivedComboBox.getX() + Constants.COMBO_BOX_WIDTH + Constants.SPACE_BETWEEN / 4, y, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(survivedLabelSex);
            this.survivedComboBoxSex = new JComboBox<>(Constants.SEX_TYPE);
            this.survivedComboBoxSex.setBounds(survivedLabelSex.getX() + Constants.COMBO_BOX_WIDTH, y, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.survivedComboBoxSex);
            this.survivedComboBoxSex.addActionListener((e) -> {

            });
            JLabel embarkedLabel = new JLabel("Went on deck:");
            embarkedLabel.setBounds(survivedLabelSex.getX() + Constants.SPACE_BETWEEN * 2 + Constants.SPACE_BETWEEN / 2, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(embarkedLabel);
            this.survivedComboBoxEmbarked = new JComboBox<>(Constants.SEX_TYPE);
            this.survivedComboBoxEmbarked.setBounds(embarkedLabel.getX() + Constants.SPACE_BETWEEN + Constants.SPACE_BETWEEN / 2, y, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.survivedComboBoxEmbarked);
            this.survivedComboBoxEmbarked.addActionListener((e) -> {

            });
            JLabel ageMin = new JLabel("Min age");
//            ageMin.setFont(new Font("Min age",20,Font.BOLD));
            ageMin.setBounds(x + Constants.MARGIN_FROM_LEFT, 160, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(ageMin);
            TextField minAge = new TextField("");
            minAge.setBounds(x + Constants.MARGIN_FROM_LEFT, 200, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(minAge);
            JLabel ageMax = new JLabel("Max age");
            ageMax.setBounds(x + Constants.MARGIN_FROM_LEFT+100, 160, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(ageMax);
            TextField maxAge = new TextField("");
            maxAge.setBounds(x + ageMax.getX(), 200, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
            this.add(maxAge);

        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(backGround,0,0,null);
    }
}
//TextField passengerName = new TextField("");
//            passengerName.setBounds(x + Constants.MARGIN_FROM_LEFT * 2, y + 70, Constants.LABEL_WIDTH * 2, Constants.LABEL_HEIGHT);
//            this.add(passengerName); מיועד לאביחי, זה הטקסט שמעל הלוח בחירה שלו

