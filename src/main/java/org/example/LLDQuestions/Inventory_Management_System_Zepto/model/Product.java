package org.example.LLDQuestions.Inventory_Management_System_Zepto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {
    String productId;
    String productName;
    String productDescription;
    ProductCategory productCategory;
}
