package com.ness.library.manager.dtos;

import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED )
@Builder
public class BookDto {

    private Long id;
    private String title;
    private String author;


}
