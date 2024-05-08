package com.skyeye.skyeyeuserservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER_ID_CARD")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserIdCard {

   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;

   @OneToOne(mappedBy = "userIdCard")
   private UserData userData;

   @Column
   private String code;

   @Column
   private ZonedDateTime issueDate;
   @Column
   private ZonedDateTime expiryDate;
   @Column
   private String title;
}
