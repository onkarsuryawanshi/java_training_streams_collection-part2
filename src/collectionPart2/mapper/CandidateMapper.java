package collectionPart2.mapper;

import collectionPart2.model.Candidate;
import collectionPart2.model.Student;

public class CandidateMapper implements CSVToPojoMapper{

    public Candidate map(String[] values) {
        if (values == null || values.length!=4) {
            throw new RuntimeException("Invalid input values");
        }
         Integer id;
         String name;
         String constituency;
         Integer votes;
        try {
            id = Integer.parseInt(values[0].trim());
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid candidate Id ", e);
        }
        ;
        name = values[1].trim();
        constituency = values[2].trim();

        try {
            votes = Integer.parseInt(values[3].trim());
        }
        catch (NumberFormatException e){
            throw new RuntimeException("Invalid votes ", e);
        }

        Candidate candidate = new Candidate(id,name,constituency,votes);
        return candidate;
    }
}
