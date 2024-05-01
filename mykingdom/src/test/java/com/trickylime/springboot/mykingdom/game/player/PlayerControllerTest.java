package com.trickylime.springboot.mykingdom.game.player;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ModelMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayerControllerTest {

    @Mock
    private PlayerService playerServiceMock;

    @InjectMocks
    private PlayerController playerControllerMock;

    @Mock
    private Player mockedPlayer;

    ModelMap model = new ModelMap();

    @Test
    public void listPlayerStats_test() {

        String viewName = playerControllerMock.listPlayerStats(mockedPlayer, model);
        assertEquals("main", viewName);
    }

    @Test
    void villagersPage_test() {

        String viewName = playerControllerMock.villagersPage(mockedPlayer, model);
        assertEquals("villagers", viewName);
    }

    @ParameterizedTest
    @CsvSource({"5, 3, 2, true", "5, 3, 2, false"})
    void buyVillagers_trueAndFalseTest(int workers, int farmers, int spies, boolean isEnoughFood) {

        when(playerServiceMock.buyVillagers(any(Player.class), anyInt(), anyInt(), anyInt())).thenReturn(isEnoughFood);

        String viewName = playerControllerMock.buyVillagers(mockedPlayer, workers, farmers, spies, model);

        if (isEnoughFood) {
            assertEquals("redirect:villagers", viewName);
            verify(playerServiceMock, times(1)).buyVillagers(mockedPlayer, workers, farmers, spies);
        } else {
            assertEquals("villagers", viewName);
            assertEquals("Insufficient food. Please try again.", model.get("errorMessage"));
            verify(playerServiceMock, times(1)).buyVillagers(mockedPlayer, workers, farmers, spies);
        }
    }

    @ParameterizedTest
    @CsvSource({"5, 3, 2, true", "5, 3, 2, false"})
    void sellVillagers_trueAndFalseTest(int workers, int farmers, int spies, boolean isEnoughVillagers) {

        when(playerServiceMock
                .sellVillagers(any(Player.class), anyInt(), anyInt(), anyInt())).thenReturn(isEnoughVillagers);

        String viewName = playerControllerMock.sellVillagers(mockedPlayer, workers, farmers, spies, model);

        if (isEnoughVillagers) {
            assertEquals("redirect:villagers", viewName);
            verify(playerServiceMock, times(1)).sellVillagers(mockedPlayer, workers, farmers, spies);
        } else {
            assertEquals("villagers", viewName);
            assertEquals("Insufficient villagers. Please try again.", model.get("errorMessage"));
            verify(playerServiceMock, times(1)).sellVillagers(mockedPlayer, workers, farmers, spies);
        }
    }

    @Test
    void soldiersPage() {
    }

    @Test
    void hireApprentice() {
    }

    @Test
    void trainApprentice() {
    }

    @Test
    void weaponsPage() {
    }

    @Test
    void buyWeapons() {
    }

    @Test
    void sellWeapons() {
    }

    @Test
    void upgradesPage() {
    }

    @Test
    void buyUpgrade() {
    }

    @Test
    void sciencePage() {
    }

    @Test
    void buyScience() {
    }

    @Test
    void playerRankings() {
    }

    @Test
    void opponentStats() {
    }

    @Test
    void battleOpponent() {
    }

    @Test
    void spyOnPlayer() {
    }
}