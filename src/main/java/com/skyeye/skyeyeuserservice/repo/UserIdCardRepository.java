package com.skyeye.skyeyeuserservice.repo;

import com.skyeye.skyeyeuserservice.model.UserIdCard;
import com.skyeye.skyeyeuserservice.model.UserIdCardRecord;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIdCardRepository extends JpaRepository<UserIdCard, UUID> {

  @Query("SELECT "
      + "new com.skyeye.skyeyeuserservice.model.UserIdCardRecord("
      + "ic.code, ic.issueDate, ic.expiryDate, ic.title) "
      + "FROM UserData ud LEFT JOIN FETCH UserIdCard ic on ud.userIdCard.id = ic.id "
      + "WHERE ud.id = :userId")
  Optional<UserIdCardRecord> findByUserId(@Param("userId") UUID userid);
}
