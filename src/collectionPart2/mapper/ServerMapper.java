package collectionPart2.mapper;

import collectionPart2.model.Server;

public class ServerMapper implements CSVToPojoMapper {

    @Override
    public Object map(String[] values) {
        if (values == null || values.length != 4) {
            throw new RuntimeException("Invalid input values");
        }
        String serverName = null;
        String softwareCategory = null;
        String softwareName = null;
        String softwareVersion = null;

        serverName = values[0];
        softwareCategory = values[1];
        softwareName = values[2];
        softwareVersion = values[3];
        Server server = new Server(serverName, softwareCategory, softwareName, softwareVersion);
        return server;

    }
}

