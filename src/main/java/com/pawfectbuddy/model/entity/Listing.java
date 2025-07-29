package com.pawfectbuddy.model.entity;
// table that represents each listing
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

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
    @Column(name="active")
    private boolean active;
    @Column
    private String username;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "user_id")
    private User user;
}
