package com.aniket.Library.Management.App.controller;

import com.aniket.Library.Management.App.dto.LibraryDto;
import com.aniket.Library.Management.App.entity.Library;
import com.aniket.Library.Management.App.service.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class LibraryController {

    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService){this.libraryService=libraryService; }

    //Adding Rest API
    @PostMapping
    public ResponseEntity<LibraryDto> AddBook (@RequestBody LibraryDto libraryDto){

        return new ResponseEntity<>(libraryService.addbook(libraryDto), HttpStatus.CREATED);
    }

    // Get Books REST API
    @GetMapping("/{id}")
    public ResponseEntity<LibraryDto>getBookById(@PathVariable Long id){
    LibraryDto libraryDto= libraryService.getbookbyId(id);
    return ResponseEntity.ok(libraryDto);
    }

    //Get All BOOKS REST API
    @GetMapping
    public ResponseEntity<List<LibraryDto>>getAllBooks(){
    List<LibraryDto>Books =libraryService.getAllBooks();
    return ResponseEntity.ok(Books);
    }


    //Delete Book REST API
@DeleteMapping("/{id}")
    public ResponseEntity<String>deleteBook(@PathVariable Long id){
        libraryService.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully");
    }

}
