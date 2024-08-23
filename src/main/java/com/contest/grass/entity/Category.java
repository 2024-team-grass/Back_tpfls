package com.contest.grass.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CategoryId;

    private String name;

    // 부모-자식 관계 설정 (생략)

    // 다대다 (Item <-> Category)
    @ManyToMany(mappedBy = "categories")
    private List<Item> items = new ArrayList<>();

    // Getter와 Setter 메서드
    public Long getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Long categoryId) {
        CategoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}