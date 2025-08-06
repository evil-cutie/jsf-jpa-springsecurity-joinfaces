package com.pawfectbuddy.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * This entity maps to the {@code roles} table in the database.
 * The primary key is identified by the {@code roleId} field.
 * <p>Persistent fields include:
 * <ul>
 *     <li>{@code roleName}: A role name </li>
 * </ul>
 * @author Xenia Levit
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private Long roleId;
    @Column(name="role_name")
    private String roleName;

}
