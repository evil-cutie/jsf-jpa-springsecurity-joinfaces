package com.pawfectbuddy.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Set;

/**
 * This entity maps to the {@code routes} table in the database.
 * The primary key is identified by the {@code routeId} field.
 * <p>Persistent fields include:
 * <ul>
 *     <li>{@code roleUrl}: A route URL </li>
 * </ul>
 * Has {@code ManyToMany} relationship with entity {@code Role}
 * @author Xenia Levit
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="routes")
public class Route implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="route_id")
    private Long routeId;
    @Column(name="route_url")
    private String routeUrl;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="route_role",
            joinColumns = @JoinColumn(name="route_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )
    private Set<Role> roles;

}
