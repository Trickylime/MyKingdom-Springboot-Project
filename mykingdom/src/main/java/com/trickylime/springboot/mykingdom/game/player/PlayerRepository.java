package com.trickylime.springboot.mykingdom.game.player;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
