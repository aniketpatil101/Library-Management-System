package com.aniket.Library.Management.App.service.Impl;

import com.aniket.Library.Management.App.dto.LibraryDto;
import com.aniket.Library.Management.App.entity.Library;
import com.aniket.Library.Management.App.mapper.LibraryMapper;
import com.aniket.Library.Management.App.repository.LibraryRepository;
import com.aniket.Library.Management.App.service.LibraryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryServiceImpl implements LibraryService {

    private LibraryRepository libraryRepository;

    public LibraryServiceImpl(LibraryRepository libraryRepository){
    this.libraryRepository =libraryRepository;
    }


    @Override
    public LibraryDto addbook(LibraryDto libraryDto) {
        Library library = LibraryMapper.mapToLibrary(libraryDto);
        Library savedBook = libraryRepository.save(library);

        return LibraryMapper.mapToLibraryDto(savedBook);
    }

    @Override
    public LibraryDto getbookbyId(Long id) {
        Library library = libraryRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Book not found"));
        return  LibraryMapper.mapToLibraryDto(library);
    }

    @Override
    public List<LibraryDto> getAllBooks() {
    List<Library> books =libraryRepository.findAll();
        return books.stream().map(library -> LibraryMapper.mapToLibraryDto(library))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBook(Long id) {
    Library library= libraryRepository
            .findById(id)
            .orElseThrow(()->new RuntimeException("Book does not exist"));

    libraryRepository.deleteById(id);
    }
}
