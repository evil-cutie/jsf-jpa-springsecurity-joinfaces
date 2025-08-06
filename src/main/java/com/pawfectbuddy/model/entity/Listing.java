package com.pawfectbuddy.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import java.io.Serializable;

/**
 * This entity maps to the {@code listings} table in the database.
 * The primary key is identified by the {@code listingId} field.
 * <p>Persistent fields include:
 * <ul>
 *     <li>{@code title}: A listing title </li>
 *     <li>{@code description}: A listing description </li>
 *     <li>{@code image}: A listing image </li>
 *     <li>{@code phone}: A listing phone </li>
 *     <li>{@code active}: Whether a listing is active or not </li>
 * </ul>
 * Has {@code ManyToOne} relationship with entity {@code User}
 * Has {@code ManyToOne} relationship with entity {@code City}
 * Has {@code ManyToOne} relationship with entity {@code Animal}
 * @author Xenia Levit
 */

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
    @Column(name="listing_title")
    private String title;
    @Column(name="description")
    private String description;
    @Column(name="listing_image")
    private String image;
    @Column(name="active")
    private boolean active;
    @Column
    private String phone;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "city_id")
    private City city;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "animal_id")
    private Animal animal;

}
