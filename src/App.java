public class App {
    public static void main(String[] args) {
        String[] times = {"12:00:01AM", "02:02:10PM", "10:45:20AM"};

        for(String str: times) {
            System.out.println(timeConversion(str));
        }
    }

    // objective: convert any time from AM/PM to 24-hour military clock
    static String timeConversion(String str) {
        String[] newStr = str.split(":");
        Integer newHour = Integer.parseInt(newStr[0]); // turns the hour into integer
        String[] noSign = newStr[2].split("[AP]"); // discards the AM or PM from the last part (seconds)
        
        if(newHour == 12 && newStr[2].indexOf("A") == 2) {
          return "00" + ":" + newStr[1] + ":" + noSign[0]; // return if it's 12am
        }
        
        if(newStr[2].indexOf("P") == 2 && newHour < 12) {
          newHour += 12;
          String pastPM = Integer.toString(newHour);
          return pastPM + ":" + newStr[1] + ":" + noSign[0]; // return if it's 12am
        }
        
        return newStr[0] + ":" + newStr[1] + ":" + noSign[0]; // return for AM (non-12)
    }
}
