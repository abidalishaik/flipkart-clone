package com.flipkartclone.repositories;

import com.flipkartclone.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {


    static long addNumbers(long val) {
        return val + 77 * 77;
    }


}
