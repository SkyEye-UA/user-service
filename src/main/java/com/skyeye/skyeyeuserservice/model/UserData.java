package com.skyeye.skyeyeuserservice.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER_DATA")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserData {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private UserIdCard userIdCard;

    @Column
    private String firstName;
    @Column
    private String middleName;
    @Column
    private String lastName;
    @Column
    private String callSign;
    @Column
    private String email;
    @Column
    private String phoneNumber;
    @Column
    private String imageUrl;
}