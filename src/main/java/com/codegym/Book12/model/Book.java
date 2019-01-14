package com.codegym.Book12.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "book")
public class Book {
    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 10)
    private String booksCode;

    @Min(1)
    private Long price;

    @NotEmpty
    @Min(1)
    @Max(3)
    private String status;


    private Long discount;

    @NotNull
    private String company;


    private Long number;

    private String description;

    public Book(@NotNull @Size(max = 10) String booksCode, @Min(1) Long price, @NotEmpty @Min(1) @Max(3) String status, @NotEmpty Long discount, @NotNull String company, @NotEmpty Long number, String description) {
        this.booksCode = booksCode;
        this.price = price;
        this.status = status;
        this.discount = discount;
        this.company = company;
        this.number = number;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBooksCode() {
        return booksCode;
    }

    public void setBooksCode(String booksCode) {
        this.booksCode = booksCode;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Book() {
    }
}
