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

    public Passenger(String[] values) {
        this.id = checkIntNum(values[0]);
        this.survived = checkIntNum(values[1]);
        this.pClass = checkIntNum(values[2]);
        this.name = getFormattedName(values[3] + ", " + values[4]);
        this.gender = values[5];
        this.age = checkFloat(values[6]);
        this.sibSp = checkIntNum(values[7]);
        this.parch = checkIntNum(values[8]);
        this.ticket = values[9];
        this.fare = checkFloat(values[10]);
        this.cabin = values[11];
        if (values.length > 12) {
            this.embarked = values[12];
        }

    }

    private int checkIntNum(String number) {
        int num = Constants.ZERO_VALUE;
        if (!number.equals(Constants.EMPTY_STRING)) {
            num = Integer.parseInt(number);
        }
        return num;
    }

    private float checkFloat(String number) {
        float check = Constants.ZERO_VALUE;
        if (!number.equals(Constants.EMPTY_STRING)) {
            check = Float.parseFloat(number);
        }
        return check;
    }

    public boolean survived() {
        return this.survived == Constants.SURVIVED;
    }

    public String getFormattedName(String name) {
        String formattedName = Constants.EMPTY_STRING;
        if (name != null) {
            String lastName = name.substring(1, name.indexOf(", "));
            String firstName = name.substring(name.indexOf(". ") + 2, name.length() - 1);
            formattedName = firstName + " " + lastName;
        }
        return formattedName;
    }

    public boolean validatePClass(int pClass) {
        if (pClass == Constants.ZERO_VALUE) {
            return true;
        } else {
            return pClass == this.pClass;
        }
    }

    public boolean validateTicketNumber(String ticket) {
        if (ticket.equals(Constants.EMPTY_STRING)) {
            return true;
        } else {
            return this.ticket.contains(ticket);
        }
    }

    public boolean validateMinId(int id) {
        if (id == Constants.MIN_PASSENGER) {
            return true;
        } else {
            return this.id >= id;
        }
    }

    public boolean validateMaxId(int id) {
        if (id == Constants.MAX_PASSENGER) {
            return true;
        } else {
            return this.id <= id;
        }
    }

    public boolean validatePassengerName(String name) {
        if (name.equals(Constants.EMPTY_STRING)) {
            return true;
        } else {
            return this.name.contains(name);
        }
    }

    public boolean validateParchAmount(int amount) {
        if (amount == Constants.ZERO_VALUE) {
            return true;
        } else {
            return this.parch == amount;
        }
    }

    public boolean validateSibSPAmount(int amount) {
        if (amount == Constants.DEFAULT_VALUE) {
            return true;
        } else {
            return this.sibSp == amount;
        }
    }

    public boolean validateCabinNumberData(String cabin) {
        if (cabin.equals(Constants.EMPTY_STRING)) {
            return true;
        } else {
            return this.cabin.contains(cabin);
        }
    }

    public boolean validateGender(String gender) {
        if (gender.equals(Constants.GENDER_TYPE[0])) {
            return true;
        } else {
            return this.gender.equals(gender);
        }
    }

    public boolean validateEmbarked(String embarked) {
        try {
            if (embarked.equals(Constants.EMBARKED[0])) {
                return true;
            } else {
                return this.embarked.contains(embarked);
            }
        } catch (NullPointerException exception) {
            return false;
        }
    }

    public boolean validateMinPrice(float fare) {
        if (fare == Constants.ZERO_VALUE) {
            return true;
        } else {
            return this.fare >= fare;
        }
    }

    public boolean validateMaxPrice(float fare) {
        if (fare == Constants.DEFAULT_VALUE) {
            return true;
        } else {
            return this.fare <= fare;
        }
    }

    public boolean hadFamily() {
        return this.parch > 0 || this.sibSp > 0;
    }

    public boolean ageInRange(int minAge, int maxAge) {
        if (this.age >= minAge && this.age <= maxAge) {
            return true;
        } else {
            return false;
        }
    }

    public boolean costInRange(int minCost, int maxCost) {
        if (this.fare >= minCost && this.fare <= maxCost) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return
                id +
                        "," + survived +
                        "," + pClass +
                        "," + name +
                        "," + gender +
                        "," + age +
                        "," + sibSp +
                        "," + parch +
                        "," + ticket +
                        "," + fare +
                        "," + cabin +
                        "," + embarked;
    }
}
