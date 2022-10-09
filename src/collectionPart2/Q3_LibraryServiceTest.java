package collectionPart2;

import collectionPart2.mapper.LibraryMapper;
import collectionPart2.model.Library;
import collectionPart2.parser.InputParser;
import collectionPart2.services.LibraryService;

import java.util.ArrayList;
import java.util.List;

public class Q3_LibraryServiceTest {

    public static void main(String[] args) {
        String[] libraryInfo = {
                "Mail Server, Authentication Library, v6",
                "Video Call Server, Authentication Library, v7",
                "Mail Server, Data Storage Library, v10",
                "Chat Server, Data Storage Library, v11",
                "Mail Server, Search Library, v6",
                "Chat Server, Authentication Library, v8",
                "Chat Server, Presence Library, v2",
                "Video Call Server, Data Storage Library, v10",
                "Video Call Server, Video Compression Library, v3"
        };

        LibraryMapper mapper = new LibraryMapper();
        List<Library> libraries ;
        InputParser parser = new InputParser<>(mapper);
        libraries = parser.parseArray(libraryInfo);



        LibraryService service = new LibraryService(libraries);
        List<String> libraryUsingOutDatedVersion = service.getProductsUsingOutDatedVersions();


        System.out.println("************************************************************");

        System.out.println(" Names of products which are using an outdated version ");
        libraryUsingOutDatedVersion.stream()
                .forEach(System.out::println);

        System.out.println("************************************************************");


    }
}
