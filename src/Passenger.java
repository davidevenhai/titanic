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
    private double fare;
    private String cabin;
    private String embarked;

    public Passenger(int id, int survived, int pClass, String name, String gender, String age, int sibSp, int parch,
                     String ticket, double fare, String cabin, String embarked) {
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

    public int getId() {
        return id;
    }

    public int getSurvived() {
        return survived;
    }

    public int getpClass() {
        return pClass;
    }

    public String getGender() {
        return gender;
    }

    public float getAge() {
        return age;
    }

    public int getSibSp() {
        return sibSp;
    }

    public int getParch() {
        return parch;
    }

    public String getTicket() {
        return ticket;
    }

    public double getFare() {
        return fare;
    }

    public String getCabin() {
        return cabin;
    }

    public String getEmbarked() {
        return embarked;
    }
}
