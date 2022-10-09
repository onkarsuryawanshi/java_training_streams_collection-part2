package collectionPart2.model;

public class Candidate {
    private Integer id;
    private String name;
    private String constituency;
    private Integer votes;

    public Candidate(Integer id, String name, String constituency, Integer votes) {
        this.id = id;
        this.name = name;
        this.constituency = constituency;
        this.votes = votes;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getConstituency() {
        return constituency;
    }

    public Integer getVotes() {
        return votes;
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format("candidateId:{0},candidateName:{1},constituency:{2},candidateVotes:{3}",id,name,constituency,votes);
    }
}
