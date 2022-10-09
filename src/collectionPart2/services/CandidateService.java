package collectionPart2.services;

import collectionPart2.model.Candidate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class CandidateService {
    List<Candidate> candidates;


    public CandidateService(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public Map<String, Candidate> getIdOfCandidateHavingHighestVotesInArea() {
        Map<String, Candidate> highestVotesCandidateId =
                candidates
                        .stream()
                        .collect(groupingBy(
                                candidate ->candidate.getConstituency(),
                                collectingAndThen(maxBy(comparingInt(c->c.getVotes())), Optional::get)
                        ));
        return highestVotesCandidateId;
    }
}

