package com.sprint.mission.jpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.Getter;

@Entity
@Table(name = "menus")
@Getter
public class Menu {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "menu_name", nullable = false, length = 80)
  private String name;

  @Column(nullable = false)
  private int price;

  @Column(name = "created_at", nullable = false)
  private Instant createdAt;

  @ManyToOne(fetch = FetchType.LAZY) // 실무 권장
  @JoinColumn(name = "category_id", nullable = false)
  private Category category;

  protected Menu() { }

  public Menu(String name, int price, Category category) {
    this.name = name;
    this.price = price;
    this.createdAt = Instant.now();
    this.category = category;
  }

  // 연관관계 편의 메서드(선택)
  public void changeCategory(Category category) {
    this.category = category;
  }
}