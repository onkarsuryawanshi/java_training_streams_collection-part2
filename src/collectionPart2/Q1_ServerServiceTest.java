package collectionPart2;

import collectionPart2.mapper.ServerMapper;
import collectionPart2.model.Server;
import collectionPart2.parser.InputParser;
import collectionPart2.services.ServerService;

import java.util.List;

public class Q1_ServerServiceTest {
    public static void main(String[] args) {
        String[] serversInformation = {
                "Server1, Database, MySQL, 5.5",
                "Server2, Database, MySQL, 5.1",
                "Server3, OS, Ubuntu, 12.04",
                "Server1, OS, Ubuntu, 12.04",
                "Server2, OS, Ubuntu, 18.04",
                "Server3, Language, Python, 2.6.3",
                "Server4, Language, Python, 3.9.14",
                "Server4, Language, Python, 3.10.4",
                "Server5, Language, Java, 19"
        };

        ServerMapper mapper = new ServerMapper();
        List<Server> servers;
        InputParser parser = new InputParser<>(mapper);
        servers = parser.parseArray(serversInformation);


        ServerService serverService = new ServerService(servers);
        serverService.outdatesSoftwareInstalledOnAtLeastToServes().forEach((k,v)-> System.out.println(k+":"+v));



        System.out.println("--- server names ---");
        System.out.println(serverService.serverNames());

        System.out.println("--- software categories ---");
        System.out.println(serverService.softwareCategories());

        System.out.println("--- software names ---");
        System.out.println(serverService.softwareNames());
    }
}
