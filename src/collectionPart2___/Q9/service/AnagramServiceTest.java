package collectionPart2___.Q9.service;

import java.util.Arrays;
import java.util.List;

public class AnagramServiceTest {
    public static void main(String[] args) {

        String word = "listen";
        List<String> stringList = Arrays.asList("enlists", "google", "inlets" ,"banana" );

        AnagramService service = new AnagramService();

        List<String> listAnagram = service.getListOfAnagram(word,stringList);


        System.out.println("***************************************************");
        System.out.print("Anagrams are --");
        listAnagram.stream()
                        .forEach(System.out::println);
        System.out.println("***************************************************");

    }
}
