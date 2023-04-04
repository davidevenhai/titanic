public class Passenger {
    private int id;
    private int survived;
    private int pClass;
    private String name;
    private String gender;
    private float age;
    private int sibSp;
    private int parch;
    private String ticket;
    private float fare;
    private String cabin;
    private String embarked;

    public Passenger(int id, int survived, int pClass, String name, String gender, String age, int sibSp, int parch,
                     String ticket, float fare, String cabin, String embarked) {
        this.id = id;
        this.survived = survived;
        this.pClass = pClass;
        if (name != null) {
            this.name = getFormattedName(name);
        } else {
            this.name = "";
        }
        this.gender = gender;
        if (age.equals("")) {
            this.age = 0;
        } else {
            this.age = Float.parseFloat(age);
        }
        this.sibSp = sibSp;
        this.parch = parch;
        this.ticket = ticket;
        this.fare = fare;
        this.cabin = cabin;
        if (embarked == null) {
            this.embarked = "X";
        } else {
            this.embarked = embarked;
        }
    }

    public String getName() {
        return name;
    }

    public String getFormattedName(String name) {
        String formattedName = "";
        if (name != null) {
            String lastName = name.substring(1, name.indexOf(", "));
            String firstName = name.substring(name.indexOf(". ") + 2, name.length() - 1);
            formattedName = firstName + " " + lastName;
        }
        return formattedName;
    }
    public boolean validatePClass(int pClass){
        if(pClass == 0){
            return true;
        }else{
            return pClass == this.pClass;
        }
    }
    public boolean validateTicketNumber(String ticket){
        if(ticket.equals("")){
            return true;
        }else{
            return this.ticket.contains(ticket);
        }
    }
    public boolean validateMinId(int id){
        if(id == Constants.MIN_PASSENGER){
            return true;
        }else{
            return this.id>=id;
        }
    }
    public boolean validateMaxId(int id){
        if(id == Constants.MAX_PASSENGER){
            return true;
        }else{
            return this.id>=id;
        }
    }
    public boolean validatePassengerName(String name){
        return this.name.contains(name);
    }
    public boolean validateParchAmount(int amount){
        if(amount == Constants.ZERO_VALUE){
            return true;
        }else{
            return this.parch == amount;
        }
    }
    public boolean validateSibSPAmount(int amount){
        if(amount == Constants.ZERO_VALUE){
            return true;
        }else{
            return this.sibSp == amount;
        }
    }
    public boolean validateCabinNumberData(String cabin){
        if(cabin.equals(Constants.EMPTY_STRING)){
            return true;
        }else{
            return this.cabin.equals(cabin);
        }
    }
    public boolean validateGender(String gender){
        if(gender.equals(Constants.GENDER_TYPE[0])){
            return true;
        }else{
            return this.gender.equals(gender);
        }
    }
    public boolean validateEmbarked(String embarked){
        if(embarked.equals(Constants.EMBARKED[0])){
            return true;
        }else{
            return this.embarked.equals(embarked);
        }
    }
    public boolean validateMinPrice(float fare){
        if(fare == Constants.ZERO_VALUE){
            return true;
        }else{
            return this.fare<=fare;
        }
    }
    public boolean validateMaxPrice(float fare){
        if(fare == Constants.ZERO_VALUE){
            return true;
        }else{
            return this.fare>=fare;
        }
    }

}
