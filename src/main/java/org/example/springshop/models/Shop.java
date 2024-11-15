package org.example.springshop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shop {

    @Id
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String website;
    private String category;
    private String description;
}
