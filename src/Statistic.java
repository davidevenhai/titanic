import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Statistic {
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
    private String byEmbarked(ArrayList<Passenger> passengers){
        String conclusion = "Total survived from embarked: ";
        for(int i = 1; i< Constants.EMBARKED.length; i++){
            float alive = 0, total = 0;
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
    private String byPrice(ArrayList<Passenger> passengers){
        String conclusion = "Total survived per price: ";
        for(int i = 0; i< Constants.PRICE.length-1; i+=2){
            float alive = 0, total = 0;
            for(Passenger p : passengers){
                if(p.costInRange(Constants.PRICE[i], Constants.PRICE[i+1])) {
                    total++;
                    if(p.survived()){
                        alive++;
                    }
                }
            }
            conclusion+=Constants.PRICE[i]+"-"+ Constants.PRICE[i+1]+" ---> "+String.format("%.2f", (alive/total)*100)+"%. ";
            if(Constants.PRICE[i+1] == Integer.MAX_VALUE){
                conclusion = conclusion.replaceAll("-2147483647", "+");
            }
        }
        return conclusion;
    }

    private String bySibParch(ArrayList<Passenger> passengers){
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
        return "Total people without family who survived are "+formattedDotNoFamily+"%.\n"+
                "Total family with family who survived are "+formattedDotFamily+"%.";
    }

    private String byAge(ArrayList<Passenger> passenger){
        String calculated = "Survived by age ";
        for(int i = 0;i<=Constants.AGES.length-1;i+=2){
            float alive = 0,total = 0;
            int minAge = Constants.AGES[i];
            int maxAge = Constants.AGES[i+1];
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
    private String byGender(ArrayList<Passenger> passengers){
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
