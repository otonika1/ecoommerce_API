package com.example.practice.repository;

import com.example.practice.entity.ClientEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    Optional<ClientEntity> findByEmail(String email);



    @Query(value = "select * from client " +
            "where cl_id = :id and " +
            "(:searchText is null or concat(cl_name, concat(' ' , cl_lastname)) like :searchText)",
            countQuery = "select count(*) from client " +
                    "where cl_id = :id and " +
                    "(:searchText is null or concat(first_name, concat(' ' , last_name)) like :searchText)",
            nativeQuery = true)
    Slice<ClientEntity> search(@Param("id") Long id, @Param("searchText") String searchText, Pageable pageable);

}
