package com.pawfectbuddy.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * This entity maps to the {@code cities} table in the database.
 * The primary key is identified by the {@code id} field.
 * <p>Persistent fields include:
 * <ul>
 *     <li>{@code name}: A city name </li>
 * </ul>
 * Has {@code OneToMany} relationship with entity {@code Listing}
 * @author Xenia Levit
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cities")
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="city_id")
    private Long id;
    @Column(name="city_name")
    private String name;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Listing> listings = new HashSet<>();

}

