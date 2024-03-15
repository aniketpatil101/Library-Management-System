package com.aniket.Library.Management.App.service;

import com.aniket.Library.Management.App.dto.LibraryDto;

import java.util.List;

public interface LibraryService {

    LibraryDto addbook(LibraryDto libraryDto);
    LibraryDto getbookbyId (Long id);
    List<LibraryDto>getAllBooks();
    void deleteBook(Long id);

}
