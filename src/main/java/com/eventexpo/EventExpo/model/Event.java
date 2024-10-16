package com.eventexpo.EventExpo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String location;
    private String imageUrl;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private boolean isFree;
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id") // Foreign key column
    @JsonBackReference
    private Category category;
}
