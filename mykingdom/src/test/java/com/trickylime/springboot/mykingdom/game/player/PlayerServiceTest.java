package com.trickylime.springboot.mykingdom.game.player;

import com.trickylime.springboot.mykingdom.game.PlayerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @Mock
    private List<Player> players;

    @InjectMocks
    private PlayerService playerServiceMock;

    @Test
    public void testFindByUsername() {
        // Define the username for which you want to mock the behavior
        String usernameToFind = "admin";

        // Create a list of players to be used for filtering
        List<Player> players = List.of(
                new Player(1, "admin", "admin@gmail.com"),
                new Player(2, "user1", "user1@gmail.com"),
                new Player(3, "user2", "user2@gmail.com")
        );

// Mock the behavior of the findByUsername() method directly
        when(playerServiceMock.findByUsername(anyString())).thenAnswer(invocation -> {
            String usernameArg = invocation.getArgument(0);
            List<Player> filteredPlayers = players.stream()
                    .filter(player -> player.getUsername().equalsIgnoreCase(usernameArg))
                    .toList();

            if (!filteredPlayers.isEmpty()) {
                return filteredPlayers.get(0);
            } else {
                throw new NoSuchElementException("Player with username '" + usernameArg + "' not found");
            }
        });

        // Act
        Player actualPlayer = playerServiceMock.findByUsername(usernameToFind);

        // Assert
        assertEquals("admin", actualPlayer.getUsername());
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