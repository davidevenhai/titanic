import java.util.ArrayList;

public class Utils {


    public static void searchSurvived(ArrayList<Passenger> passengers, int classNumber, String genderData, String wentOnDeck,
                                      Integer passengerNumberMinData, Integer passengerNumberMaxData, String passengerNameData,
                                      Integer parchAmountData, Integer sibSPAmountData, String ticketNumberData, Float maxTicketPriceData,
                                      Float minTicketPriceData, String cabinNumberData) {

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
        System.out.println(filteredPassengers);
        System.out.println(filteredPassengers.size());
    }

}
