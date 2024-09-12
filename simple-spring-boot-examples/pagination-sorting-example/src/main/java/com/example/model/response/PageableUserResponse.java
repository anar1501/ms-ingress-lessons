package com.example.model.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageableUserResponse {
    List<UserResponse> users;
    int lastPageNumber;
    long totalElements;
    boolean hasNextPage;
}
