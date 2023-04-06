import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Utils {
    public static int numbers = 0;
    public static String searchSurvived(ArrayList<Passenger> passengers, int classNumber, String genderData, String wentOnDeck,
                                        Integer passengerNumberMinData, Integer passengerNumberMaxData, String passengerNameData,
                                        Integer parchAmountData, Integer sibSPAmountData, String ticketNumberData, Float maxTicketPriceData,
                                        Float minTicketPriceData, String cabinNumberData) throws IOException {

        ArrayList<Passenger> filteredPassengers = new ArrayList<Passenger>();
        for (int i = 0; i < passengers.size(); i++) {

            if (passengers.get(i).validatePClass(classNumber) && passengers.get(i).validateGender(genderData) && passengers.get(i).validateEmbarked(wentOnDeck)
                    && passengers.get(i).validateMinId(passengerNumberMinData) && passengers.get(i).validateMaxId(passengerNumberMaxData)
                    && passengers.get(i).validatePassengerName(passengerNameData) && passengers.get(i).validateParchAmount(parchAmountData)
                    && passengers.get(i).validateSibSPAmount(sibSPAmountData) && passengers.get(i).validateTicketNumber(ticketNumberData)
                    && passengers.get(i).validateMaxPrice(maxTicketPriceData) && passengers.get(i).validateMinPrice(minTicketPriceData)
                    && passengers.get(i).validateCabinNumberData(cabinNumberData)) {
                filteredPassengers.add(passengers.get(i));
            }
        }

        int survived = 0;
        int died = 0;
        for (int i = 0; i < filteredPassengers.size(); i++) {
            if (filteredPassengers.get(i).survived()) {
                survived++;
            } else {
                died++;
            }
        }
        numbers++;
        String fileName = String.valueOf(numbers);
        File file = new File(fileName + ".csv");

        PrintWriter printWriter = new PrintWriter(file);
        for (int i = 0; i < filteredPassengers.size(); i++) {
            printWriter.println(filteredPassengers.get(i).toString());
        }
        printWriter.close();
        return "Total rows: " + filteredPassengers.size() + " (" + survived + ") survived, " + died + " did not)";
    }

}



