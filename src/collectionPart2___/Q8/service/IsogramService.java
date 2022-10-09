package collectionPart2___.Q8.service;

import java.util.Arrays;
import java.util.stream.Collectors;

public class IsogramService {

    public boolean checkWordIsAnIsogram(String input) {
        String[] splitString = input.split("-");
        if (splitString.length==1){
            return IsIsogram(input);
        }
        else{
           String combinedString =  Arrays.stream(splitString).collect(Collectors.joining(""));
            return IsIsogram(combinedString);
        }
    }

    private boolean IsIsogram(String input) {
        return input.length() == input.toLowerCase().chars().distinct().count();
    }
}
