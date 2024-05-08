package com.trickylime.springboot.mykingdom.game.player;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @Mock
    private static List<Player> players = new ArrayList<>();

    @InjectMocks
    private PlayerService playerServiceMock;

    @Mock
    private Player mockedPlayer = new Player(0, "admin", "admin@gmail.com");

    @Test
    public void testFindByUsername() {

        // Mock behavior of the players list
        when(playerServiceMock.findByUsername(mockedPlayer.getUsername())).thenReturn(mockedPlayer);

        // Act
        Player actualPlayer = playerServiceMock.findByUsername(mockedPlayer.getUsername());

        // Assert
        assertEquals(mockedPlayer, actualPlayer);
    }

    @Test
    void addPlayer() {
    }

    @Test
    void getAllPlayersList() {
    }

    @Test
    void buyVillagers() {
    }

    @Test
    void sellVillagers() {
    }

    @Test
    void hireApprentice() {
    }

    @Test
    void trainApprentice() {
    }

    @Test
    void buyWeapons() {
    }

    @Test
    void sellWeapons() {
    }

    @Test
    void buyUpgrade() {
    }

    @Test
    void buyScience() {
    }

    @Test
    void battleOpponents() {
    }

    @Test
    void spyOnOpponents() {
    }
}