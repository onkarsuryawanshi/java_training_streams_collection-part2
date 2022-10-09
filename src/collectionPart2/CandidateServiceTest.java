package collectionPart2;

import collectionPart2.mapper.CandidateMapper;
import collectionPart2.model.Candidate;
import collectionPart2.parser.InputParser;
import collectionPart2.services.CandidateService;

import java.util.List;
import java.util.Map;

public class CandidateServiceTest {

    public static void main(String[] args) {
        String[] candidateInfo = {"22, Ravi Pawar, Aundh, 1603",
                "23, Suvarna Kale, Baner, 803",
                "27, Vinod Chavan, Aundh, 809",
                "29, Vasant Mahajan, Aundh, 617",
                "32, Aarti Patil, Baner, 351",
                "34, Swaran Bijur, Baner, 352"};
        CandidateMapper mapper = new CandidateMapper();
        List<Candidate> candidates;
        InputParser parser = new InputParser<>(mapper);
        candidates = parser.parseArray(candidateInfo);


        CandidateService service = new CandidateService(candidates);

        Map<String, Candidate> highestVotesCandidateId = service.getIdOfCandidateHavingHighestVotesInArea();

        System.out.println(" --- candidate Having Highest votes in area ---");
        System.out.println("Area ==> candidateId");
        highestVotesCandidateId.entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() + "==>" + e.getValue().getId()));
    }
}
