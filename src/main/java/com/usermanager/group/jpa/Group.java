package com.usermanager.group.jpa;

import com.usermanager.group.dto.GroupCreateDTO;
import com.usermanager.permission.jpa.Permission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Builder(builderClassName = "Builder")
@EqualsAndHashCode(of = {"id"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="group_manager")
public class Group implements Serializable {

    private static final long serialVersionUID = 8647104129250551803L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_generator")
    @SequenceGenerator(name = "group_generator", sequenceName = "group_sequence", allocationSize = 1)
    private Long id;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String description;

    @ManyToMany
    @JoinTable(name="group_permission", joinColumns=
            {@JoinColumn(name="group_id")}, inverseJoinColumns=
            {@JoinColumn(name="permission_id")})
    private Set<Permission> permissions;

//    @ManyToOne
//    private User user;

    public static Group from (GroupCreateDTO groupCreateDTO){
        return Group
                .builder()
                .name(groupCreateDTO.getName())
                .description(groupCreateDTO.getDescription())
                .build();
    }


}
