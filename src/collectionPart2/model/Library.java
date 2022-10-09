package collectionPart2.model;

public class Library {
    private String productName;
    private String libraryName;
    private Integer libraryVersion;

    public Library(String productName, String libraryName, Integer libraryVersion) {
        this.productName = productName;
        this.libraryName = libraryName;
        this.libraryVersion = libraryVersion;
    }

    public String getProductName() {
        return productName;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public Integer getLibraryVersion() {
        return libraryVersion;
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format("productName:{0},libraryName:{1},libraryVersion:{2}",productName,libraryName,libraryVersion);
    }
}
