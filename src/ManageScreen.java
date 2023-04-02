import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ManageScreen extends JPanel {
    private JComboBox<String> survivedComboBox;
    private JComboBox<String> survivedComboBoxSex;
    public ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    public ArrayList<String> values;

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
                            Double.parseDouble(values[10]), values[11],"");
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

        if (file.exists()) {
            ReadData(file);
            this.setLayout(null);
            this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);
            JLabel survivedLabel = new JLabel("Passenger Class: ");
            survivedLabel.setBounds(x , y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel);

            this.survivedComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
            this.survivedComboBox.setBounds(survivedLabel.getX() +Constants.LABEL_WIDTH, survivedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.survivedComboBox);
            this.survivedComboBox.addActionListener((e) -> {

            });

            JLabel survivedLabelSex = new JLabel("Sex: ");
            survivedLabelSex.setBounds(survivedComboBox.getX()+Constants.COMBO_BOX_WIDTH+Constants.SPACE_BETWEEN, y, Constants.LABEL_WIDTH/2, Constants.LABEL_HEIGHT);
            this.add(survivedLabelSex);
            this.survivedComboBoxSex = new JComboBox<>(Constants.SEX_TYPE);
            this.survivedComboBoxSex.setBounds(survivedLabelSex.getX() + Constants.COMBO_BOX_WIDTH/2, y, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.survivedComboBoxSex);
            this.survivedComboBoxSex.addActionListener((e) -> {

            });

        }

    }
    //TextField passengerName = new TextField("");
    //            passengerName.setBounds(x + Constants.MARGIN_FROM_LEFT * 2, y + 70, Constants.LABEL_WIDTH * 2, Constants.LABEL_HEIGHT);
    //            this.add(passengerName); מיועד לאביחי, זה הטקסט שמעל הלוח בחירה שלו
}
