package com.aniket.Library.Management.App.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LibraryDto {

    private long id;
    private String bookName;
    private Double price;

}
