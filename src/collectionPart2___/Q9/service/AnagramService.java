package collectionPart2___.Q9.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnagramService {
    public List<String> getListOfAnagram(String word, List<String> stringList) {
        return stringList.stream()
                .filter(f->isAnagram(f,word))
                .collect(Collectors.toList());
    }
    private boolean isAnagram(String str1, String str2){
        char[] charArr1 = str1.toLowerCase().toCharArray();
        char[] charArr2 = str2.toLowerCase().toCharArray();
        Arrays.sort(charArr1);
        Arrays.sort(charArr2);
        return(Arrays.equals(charArr1, charArr2));
    }
}
