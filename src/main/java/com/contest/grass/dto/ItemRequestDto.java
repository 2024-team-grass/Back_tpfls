package com.contest.grass.dto;

public class ItemRequestDto {
    private String itemName;       // 상품명
    private String description;    // 상품 설명
    private Double price;          // 상품 가격
    private String category;       // 상품 카테고리

    // 기본 생성자
    public ItemRequestDto() {}

    // 모든 필드를 포함하는 생성자
    public ItemRequestDto(String itemName, String description, Double price, String category) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    // Getters and Setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}