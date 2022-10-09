package collectionPart2.model;

public class Server {
    private String serverName;
    private String softwareCategory;
    private String softwareName;
    private String softwareVersion;

    public Server(String serverName, String softwareCategory, String softwareName, String softwareVersion) {
        this.serverName = serverName;
        this.softwareCategory = softwareCategory;
        this.softwareName = softwareName;
        this.softwareVersion = softwareVersion;
    }

    public String getServerName() {
        return serverName;
    }

    public String getSoftwareCategory() {
        return softwareCategory;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    @Override
    public String toString() {;
        return java.text.MessageFormat.format("serverName:{0},softwareCategory:{1},softwareName:{2},softwareVersion:{3}",serverName,softwareCategory,softwareName,softwareVersion);
    }
}
