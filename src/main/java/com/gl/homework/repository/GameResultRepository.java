package com.gl.homework.repository;

import com.gl.homework.entity.GameResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameResultRepository extends JpaRepository<GameResult, Long> {

    Optional<GameResult> getResultById(int id);


}
