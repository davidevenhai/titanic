import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Statistic {
    private float pClass;
    private float gender;
    private float[] byAge;
    private float[] sibSPAndParch;
    private float Embakred;
    private static int[] ages = {0,10,11,20,21,30,31,40,41,50,51,Integer.MAX_VALUE};
    private static int[] price = {0,10,11,30,31,Integer.MAX_VALUE};
    private static int txtNumbers = 0;

    public Statistic(ArrayList<Passenger> passengers) throws FileNotFoundException {
        String toWrite = ( byEmbarked(passengers)+"\n"+byAge(passengers)+"\n" +
                byGender(passengers)+"\n"+bySibParch(passengers)+"\n"+byPrice(passengers));
        txtNumbers++;
        String fileName = String.valueOf(txtNumbers);
        File file = new File(fileName + ".txt");

        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println(toWrite);
        printWriter.close();
    }

    //by payment less than 10, 11-30 and more than 30
    public String byEmbarked(ArrayList<Passenger> passengers){
        float alive = 0, total = 0;
        String conclusion = "Total survived from embarked: ";
        for(int i = 1; i< Constants.EMBARKED.length; i++){
            for(Passenger p : passengers){
                if(p.validateEmbarked(Constants.EMBARKED[i])) {
                    total++;
                    if(p.survived()){
                        alive++;
                    }
                }
            }
            conclusion+=Constants.EMBARKED[i]+" ---> "+String.format("%.2f", (alive/total)*100)+"%. ";
        }
        return conclusion;
    }
    public String byPrice(ArrayList<Passenger> passengers){
        float alive = 0, total = 0;
        String conclusion = "Total survived per price: ";
        for(int i = 0; i< price.length-1; i+=2){
            for(Passenger p : passengers){
                if(p.costInRange(price[i], price[i+1])) {
                    total++;
                    if(p.survived()){
                        alive++;
                    }
                }
            }
            conclusion+=price[i]+"-"+ price[i+1]+" ---> "+String.format("%.2f", (alive/total)*100)+"%. ";
            if(price[i+1] == Integer.MAX_VALUE){
                conclusion = conclusion.replaceAll("-2147483647", "+");
            }
        }
        return conclusion;
    }

    public String bySibParch(ArrayList<Passenger> passengers){
    float hadFamilyTotal= 0,hadFamilyAlive = 0,noFamilyTotal = 0,noFamilyAlive = 0;
        for(Passenger p :passengers){
            if(p.hadFamily()){
                hadFamilyTotal++;
                if(p.survived()){
                    hadFamilyAlive++;
                }
            }else{
                noFamilyTotal++;
                if(p.survived()){
                    noFamilyAlive++;
                }
            }
        }
        String formattedDotFamily = String.format("%.2f",(hadFamilyAlive/hadFamilyTotal)*100);
        String formattedDotNoFamily = String.format("%.2f",(noFamilyAlive/noFamilyTotal)*100);
        return "Total people without family survived "+formattedDotNoFamily+"%.\n"+
                "Total family with family survived "+formattedDotFamily+"%.";
    }

    public String byAge(ArrayList<Passenger> passenger){
        float alive = 0;
        float total = 0;
        String calculated = "Survived by age ";
        for(int i = 0;i<=ages.length-1;i+=2){
            int minAge = ages[i];
            int maxAge = ages[i+1];
            for(Passenger p : passenger){
                if(p.ageInRange(minAge, maxAge)){
                    total++;
                    if(p.survived()){
                        alive++;
                    }
                }
            }
            String formattedDot = String.format("%.2f", (alive/total)*100);
            calculated+= minAge+"-"+maxAge+" ---> "+formattedDot+"%. ";
            if(maxAge == Integer.MAX_VALUE){
                calculated = calculated.replaceAll("-2147483647", "+");
            }
        }
        return calculated;
    }
    public String byGender(ArrayList<Passenger> passengers){
        float totalMale = 0,totalFemale = 0,survivedMale = 0,survivedFemale = 0;
        for(int i = 0;i< passengers.size();i++){
            if(passengers.get(i).validateGender("male")){
                totalMale++;
                if(passengers.get(i).survived()){
                    survivedMale++;
                }
            }else{
                totalFemale++;
                if(passengers.get(i).survived()){
                    survivedFemale++;
                }
            }
        }
        String formattedDotFemale= String.format("%.2f", (survivedFemale/totalFemale)*100);
        String formattedDotMale= String.format("%.2f", (survivedMale/totalMale)*100);
        return "Total male survived "+formattedDotMale+"%, Total female survived "+formattedDotFemale+"%";
    }





}
