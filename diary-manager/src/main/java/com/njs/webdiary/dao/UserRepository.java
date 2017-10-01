package com.njs.webdiary.dao;

import com.njs.webdiary.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Integer>
{
    int countByEmail(String email);
    UserEntity findByEmailAndPassword(String email,String password);

    UserEntity findByEmail(String email);

    @Modifying
    @Query("update UserEntity set actived=1 where activateCode=:activateCode")
    int updateActived(@Param(value = "activateCode") String activateCode);

    @Modifying
    @Query(value = "update UserEntity set postCount = postCount+1 where uid=:uid")
    int updatePostCount(int uid);

    @Modifying
    @Query(value = "update UserEntity set scanCount = scanCount + 1 where uid = ?1")
    int updateScanCount(int uid);

    List<UserEntity> findTop6ByOrderByJoinTimeDesc();

    List<UserEntity> findTop6ByOrderByPostCountDesc();

    @Modifying
    @Query(value = "update UserEntity set headUrl=:headUrl where uid=:uid")
    int updateHeadUrl(String headUrl,int uid);

    @Modifying
    @Query(value = "update UserEntity set password=substring(:code,1,8) where activateCode=:code")
    int updatePasswordByActivateCode(String code);
}
