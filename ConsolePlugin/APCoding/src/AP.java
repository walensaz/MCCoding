import java.util.ArrayList;

public class AP {

    public static int numberOfLeapYears(int year1, int year2) {
        int leapyears = 0;
        for(int i = year1; i <= year2; i++) {
            if(isLeapYear(i)) {
                leapyears += 1;
            }
        }
        return leapyears;
    }

    public static int dayOfWeek(int month, int day, int year) {
        int firstDayOfYear = firstDayOfYear(year);
        int dayOfYear = dayOfYear(month, day, year);
        int day = firstDayOfYear;
        for(int i = 0; i < dayOfYear; i++) {
            day += 1;
            if(day > 6) {
                day = 1;
            }
        }
        return day;
    }

    public ArrayList<String> getDelimitersList(String[] tokens) {
        ArrayList<String> delimitersInToken = new ArrayList<>();
        for (String token : tokens) {
            if(token.equals(openDel) || token.equals(closeDel)) {
                delimitersInToken.add(token);
            }
        }
        return delimitersInToken;
    }

    public boolean isBalanced(ArrayList<String> delimiters) {
        ArrayList<String> openDelimiters = new ArrayList<>();
        ArrayList<String> closedDelimiters = new ArrayList<>();
        for (String token : delimiters) {
            if(token.equals(openDel)) {
                openDelimiters.add(token);
            } else if(token.equals(closeDel)) {
                closedDelimiters.add(token);
            }
        }
        return openDelimiters.size() >= closedDelimiters.size();
    }
}
