package collectionPart2___.Q8;

import collectionPart2___.Q8.service.IsogramService;

public class IsogramTest {
    public static void main(String[] args) {
        String input = "six-year-old";
        IsogramService service = new IsogramService();
        boolean isIsogram = service.checkWordIsAnIsogram(input);


        System.out.println("*****************************************************");
        if (isIsogram==true){
            System.out.println("entered String is an Isogram");
        }
        else {
            System.out.println("entered String is not an Isogram");
        }
        System.out.println("*****************************************************");

    }
}
