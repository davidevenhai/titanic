import java.util.ArrayList;

public class Utils {


    public static void searchSurvived(ArrayList<Passenger> passengers, int classNumber, String genderData, String wentOnDeck,
                               Integer passengerNumberMinData, Integer passengerNumberMaxData, String passengerNameData,
                               Integer parchAmountData, Integer sibSPAmountData, String ticketNumberData, Float maxTicketPriceData,
                               Float minTicketPriceData, String cabinNumberData) {

        ArrayList<Passenger> filteredPassengers = new ArrayList<Passenger>();
        for (int i = 0; i < passengers.size(); i++) {
            if ((passengers.get(i).getpClass() == classNumber) && (passengers.get(i).getGender().equals(genderData))
                    && (passengers.get(i).getCabin().equals(wentOnDeck)) && (passengers.get(i).getId() >= passengerNumberMinData)
                    && (passengers.get(i).getId() <= passengerNumberMaxData) && (passengers.get(i).getName().contains(passengerNameData))
                    && (passengers.get(i).getParch() <= parchAmountData) && (passengers.get(i).getSibSp() == sibSPAmountData)
                    && (passengers.get(i).getTicket().contains(ticketNumberData)) && (passengers.get(i).getFare() >= minTicketPriceData
                    && (passengers.get(i).getFare() <= maxTicketPriceData)) && (passengers.get(i).getCabin().contains(cabinNumberData))) {
                filteredPassengers.add(passengers.get(i));
            }
        }
        System.out.println(filteredPassengers);
    }
//                if ((passengers.get(i).getpClass() == classNumber) && (passengers.get(i).getGender().equals(genderData))
//            && (passengers.get(i).getCabin().equals(wentOnDeck)) && (passengers.get(i).getId() >= passengerNumberMinData)
//            && (passengers.get(i).getId() <= passengerNumberMaxData) && (passengers.get(i).getName().contains(passengerNameData))
//            && (passengers.get(i).getParch() <= parchAmountData) && (passengers.get(i).getSibSp() == sibSPAmountData)
//            && (passengers.get(i).getTicket().contains(ticketNumberData)) && (passengers.get(i).getFare() >= minTicketPriceData
//                    && (passengers.get(i).getFare() <= maxTicketPriceData)) && (passengers.get(i).getCabin().contains(cabinNumberData))) {
//        filteredPassengers.add(passengers.get(i));
//    }
//}
}
