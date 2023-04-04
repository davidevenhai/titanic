public class Filter {

    private String classData;
    private String genderData;
    private String wentOnDeck;
    private Integer minAgeData;
    private Integer maxAgeData;
    private Integer passengerNumberMinData;
    private Integer PassengerNumberMaxData;
    private String enterPassengerNameData;
    private Integer parchAmountData;
    private Integer sibSPAmountData;
    private String ticketNumberData;
    private Float maxTicketPriceData;
    private Float minTicketPriceData;
    private String cabinNumberData;

    public Filter(String classData, String genderData, String wentOnDeck, Integer minAgeData, Integer maxAgeData, Integer passengerNumberMinData, Integer passengerNumberMaxData, String enterPassengerNameData, Integer parchAmountData, Integer sibSPAmountData, String ticketNumberData, Float maxTicketPriceData, Float minTicketPriceData, String cabinNumberData) {
        this.classData = classData;
        this.genderData = genderData;
        this.wentOnDeck = wentOnDeck;
        this.minAgeData = minAgeData;
        this.maxAgeData = maxAgeData;
        this.passengerNumberMinData = passengerNumberMinData;
        PassengerNumberMaxData = passengerNumberMaxData;
        this.enterPassengerNameData = enterPassengerNameData;
        this.parchAmountData = parchAmountData;
        this.sibSPAmountData = sibSPAmountData;
        this.ticketNumberData = ticketNumberData;
        this.maxTicketPriceData = maxTicketPriceData;
        this.minTicketPriceData = minTicketPriceData;
        this.cabinNumberData = cabinNumberData;
    }
}
