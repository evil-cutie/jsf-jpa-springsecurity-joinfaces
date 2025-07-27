package com.pawfectbuddy.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="listings")
public class Listing implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="listing_id")
    private Long listingId;
    @Column(name="animal_name")
    private String name;
    @Column(name="animal_type")
    private String type;
    @Column(name="description")
    private String description;
    @Column(name="animal_location")
    private String location;
    @Column(name="listing_image")
    private String image;
}
