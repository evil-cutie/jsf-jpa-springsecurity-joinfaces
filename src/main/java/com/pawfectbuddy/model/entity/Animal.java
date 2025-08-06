package com.pawfectbuddy.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * This entity maps to the {@code animals} table in the database.
 * The primary key is identified by the {@code id} field.
 * <p>Persistent fields include:
 * <ul>
 *     <li>{@code type}: Animal breed </li>
 * </ul>
 * Has {@code OneToMany} relationship with entity {@code Listing}
 * @author Xenia Levit
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="animals")
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="animal_id")
    private Long id;
    @Column(name="animal_type")
    private String type;
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Listing> listings = new HashSet<>();

}
