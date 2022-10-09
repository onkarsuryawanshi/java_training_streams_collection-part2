package collectionPart2.mapper;

import collectionPart2.model.Customer;
import collectionPart2.model.Library;

public class LibraryMapper implements CSVToPojoMapper {

    @Override
    public Object map(String[] values) {
        if (values == null || values.length!=3) {
            throw new RuntimeException("Invalid input values");
        }
        String productName;
        String libraryName;
        Integer libraryVersion;

        productName = values[0];
        libraryName = values[1];
        try {
            libraryVersion = Integer.valueOf(values[2].replace("v","").trim());
        }
        catch (NumberFormatException e){
            throw new RuntimeException("Invalid version number entered  ", e);
        }

        Library library = new Library(productName,libraryName,libraryVersion);
        return library;
    }
}
