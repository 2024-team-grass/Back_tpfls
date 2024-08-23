package com.contest.grass.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ItemId;

    @Column(length = 10)
    private String title; // 상품명

    @Column(length = 500)
    private String content;

    private Integer price;
    private String sale;
    private Integer qty; // 재고수량

    // 카테고리와의 다대다 관계 설정
    @ManyToMany
    @JoinTable(
            name = "CATEGORY_ITEM", // 중간 테이블 이름
            joinColumns = @JoinColumn(name = "ITEM_ID"), // 현재 엔티티(Item)의 외래 키
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID") // 연관된 엔티티(Category)의 외래 키
    )
    private List<Category> categories = new ArrayList<>();

    // Getter와 Setter 메서드
    public Long getItemId() {
        return ItemId;
    }

    public void setItemId(Long itemId) {
        ItemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}