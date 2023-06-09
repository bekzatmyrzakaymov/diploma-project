package com.diploma.project.model.oauth;

;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "users", schema = "oauth")
@SequenceGenerator(name = "default_abstract_entity_gen", sequenceName = "SEQ_USERS", allocationSize = 1, schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String iin;

    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    private String patronymic;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String username;
    private String password;
    private Boolean enabled = true;

    public User() {}

    public User(String iin, String lastName, String firstName, String patronymic,
                String email, String phoneNumber,
                String username, String password) {
        this.iin = iin;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;

    }

    @ManyToOne
    private Role role;

    @Enumerated(EnumType.STRING)
    private EUserStatus status;
}
