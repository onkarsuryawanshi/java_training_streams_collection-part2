package collectionPart2.services;


import collectionPart2.model.Library;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.comparingInt;


public class LibraryService {
    List<Library> libraries;

    public LibraryService(List<Library> libraries) {
        this.libraries = libraries;
    }

    public List<String> getProductsUsingOutDatedVersions() {
        Map<String,Library> latestVersionLibrary = getLatestVersionForEachLibrary();

        Set<String> productNameUsingOutOfDateLib = getNamesOfProductUsingOutDatedLibrary(latestVersionLibrary);
        return productNameUsingOutOfDateLib.stream().collect(toList());
    }

    private Set<String> getNamesOfProductUsingOutDatedLibrary(Map<String, Library> latestVersionLibrary) {
        Set<String> productNameUsingOutOfDateLib =libraries.stream()
                .filter(library -> library.getLibraryVersion() < latestVersionLibrary.get(library.getLibraryName()).getLibraryVersion())
                .map(Library::getProductName)
                .collect(toSet());
        return productNameUsingOutOfDateLib;
    }

    private Map<String, Library> getLatestVersionForEachLibrary() {

        return libraries.stream()
                .collect(groupingBy(Library::getLibraryName,
                        collectingAndThen(
                                maxBy(comparingInt(Library::getLibraryVersion)),
                                Optional::get
                        )));
    }

}
