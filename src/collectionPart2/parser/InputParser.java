package collectionPart2.parser;

import collectionPart2.mapper.CSVToPojoMapper;
import collectionPart2.mapper.StudentMapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser<T> {

    private CSVToPojoMapper mapper;

    public InputParser(CSVToPojoMapper mapper) {
        this.mapper = mapper;
    }

    public List<T> parseArray(String[] input){
         return Arrays.stream(input)
                .map(v->v.trim().split(","))
                .map(values ->(T)mapper.map(values))
                 .collect(Collectors.toList());
    }
}
