package com.pawfectbuddy.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * This entity maps to the {@code users} table in the database.
 * The primary key is identified by the {@code userId} field.
 * <p>Persistent fields include:
 * <ul>
 *     <li>{@code username}: A username </li>
 *     <li>{@code password}: A password </li>
 *     <li>{@code email}: A user's email </li>
 *     <li>{@code active}: Whether a user is active or not </li>
 * </ul>
 * Has {@code ManyToMany} relationship with entity {@code Role}
 * Has {@code OneToMany} relationship with entity {@code Listing}
 * @author Xenia Levit
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="user_email")
    private String email;
    @Column(name="active")
    private boolean active;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )
    private Set<Role> roles;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Listing> listings = new HashSet<>();

}
