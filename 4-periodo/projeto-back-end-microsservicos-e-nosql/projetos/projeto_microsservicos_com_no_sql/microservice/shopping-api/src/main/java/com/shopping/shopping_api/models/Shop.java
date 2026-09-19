package com.shopping.shopping_api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import com.example.dto.Item;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "shops")
public class Shop {
    
    @Id
    private String id;
    
    private String userIdentifier;
    private LocalDateTime date;
    private List<Item> items;
    private Double total;
}
