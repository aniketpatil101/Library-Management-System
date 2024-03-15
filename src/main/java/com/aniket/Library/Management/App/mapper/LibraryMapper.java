package com.aniket.Library.Management.App.mapper;

import com.aniket.Library.Management.App.dto.LibraryDto;
import com.aniket.Library.Management.App.entity.Library;

public class LibraryMapper {

    public static Library mapToLibrary (LibraryDto libraryDto){
    Library library=new Library(
    libraryDto.getId(),
    libraryDto.getBookName(),
    libraryDto.getPrice()
    );
return library;
    }


public static LibraryDto mapToLibraryDto (Library library){

        LibraryDto libraryDto=new LibraryDto(
        library.getId(),
        library.getBookName(),
        library.getPrice()
    );
        return  libraryDto;
}


}
