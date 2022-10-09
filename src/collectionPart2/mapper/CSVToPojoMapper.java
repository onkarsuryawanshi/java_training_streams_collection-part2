package collectionPart2.mapper;

public interface CSVToPojoMapper <T>{
    public T map(String[] input);
}
