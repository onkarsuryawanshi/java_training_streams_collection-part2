package collectionPart2.services;

import collectionPart2.model.Server;

import java.util.*;
import java.util.stream.Collectors;

public class ServerService {
    private List<Server> servers;
    public ServerService(List<Server> servers) {
        this.servers = servers;
    }

    public Set<String> serverNames() {
        return servers.stream()
                .map(Server::getServerName)
                .collect(Collectors.toSet());
    }
    public Set<String> softwareCategories() {
        return servers.stream()
                .map(Server::getSoftwareCategory)
                .collect(Collectors.toSet());
    }
    public Set<String> softwareNames() {
        return servers.stream()
                .map(Server::getSoftwareName)
                .collect(Collectors.toSet());
    }
    public Map<String, SortedSet<String>> outdatesSoftwareInstalledOnAtLeastToServes() {
        Map<String,SortedSet<String>> outdatedSoftwareVersions = outdatedSoftwareVersions();
        return outdatedSoftwareVersions.entrySet().stream()
                .filter(
                        entry -> servers.stream()
                                .filter(
                                        s-> entry.getKey().equals(s.getSoftwareName()) && entry.getValue().contains(s.getSoftwareVersion())
                                ).count() > 1
                )
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Map<String, SortedSet<String>> outdatedSoftwareVersions() {
        Map<String, SortedSet<String>> softwareNameVersions =servers.stream()
                .collect(Collectors.toMap(
                        Server::getServerName,
                        server -> {
                            SortedSet<String> versions = new TreeSet<String>(new SoftwareVersionComparator());
                            versions.add(server.getSoftwareVersion());
                            return versions;
                        },
                        (prev,current)->{
                            prev.addAll(current);
                            return prev;
                        }
                ));
        softwareNameVersions.forEach((name,versions)->versions.remove(versions.last()));
        return softwareNameVersions;
    }
}
