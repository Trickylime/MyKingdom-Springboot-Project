package com.trickylime.springboot.mykingdom.game.player;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentMatchers;
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
        } else {
            assertEquals("villagers", viewName);
            assertEquals("Insufficient food. Please try again.", model.get("errorMessage"));
        }

        verify(playerServiceMock, times(1)).buyVillagers(mockedPlayer, workers, farmers, spies);
    }

    @ParameterizedTest
    @CsvSource({"5, 3, 2, true", "5, 3, 2, false"})
    void sellVillagers_trueAndFalseTest(int workers, int farmers, int spies, boolean isEnoughVillagers) {

        when(playerServiceMock
                .sellVillagers(any(Player.class), anyInt(), anyInt(), anyInt())).thenReturn(isEnoughVillagers);

        String viewName = playerControllerMock.sellVillagers(mockedPlayer, workers, farmers, spies, model);

        if (isEnoughVillagers) {
            assertEquals("redirect:villagers", viewName);
        } else {
            assertEquals("villagers", viewName);
            assertEquals("Insufficient villagers. Please try again.", model.get("errorMessage"));
        }

        verify(playerServiceMock, times(1)).sellVillagers(mockedPlayer, workers, farmers, spies);
    }

    @Test
    void soldiersPage() {

        String viewName = playerControllerMock.soldiersPage(mockedPlayer, model);
        assertEquals("soldiers", viewName);
    }

    @ParameterizedTest
    @CsvSource({"5, true", "5, false"})
    void hireApprentice_trueAndFalseTest(int apprenticeWarriors, boolean isEnoughFood) {

        when(playerServiceMock.hireApprentice(any(Player.class), anyInt())).thenReturn(isEnoughFood);

        String viewName = playerControllerMock.hireApprentice(mockedPlayer, apprenticeWarriors, model);

        if (isEnoughFood) {
            assertEquals("redirect:soldiers", viewName);
        } else {
            assertEquals("soldiers", viewName);
            assertEquals("Insufficient food. Please try again.", model.get("errorMessage"));
        }

        verify(playerServiceMock, times(1)).hireApprentice(mockedPlayer, apprenticeWarriors);
    }

    @ParameterizedTest
    @CsvSource({"true", "false"})
    void trainApprentice_trueAndFalseTest(boolean isEnoughFood) {

        when(playerServiceMock.trainApprentice(any(Player.class),
                ArgumentMatchers.<long[]>any(), ArgumentMatchers.<long[]>any()))
                .thenReturn(isEnoughFood);

        long[] attackers = new long[0], defenders = new long[3];
        String viewName = playerControllerMock.trainApprentice(mockedPlayer, attackers, defenders, model);

        if (isEnoughFood) {
            assertEquals("redirect:soldiers", viewName);
        } else {
            assertEquals("soldiers", viewName);
            assertEquals("Insufficient food. Please try again.", model.get("errorMessage"));
        }

        verify(playerServiceMock, times(1)).trainApprentice(mockedPlayer, attackers, defenders);
    }

    @Test
    void weaponsPage() {

        String viewName = playerControllerMock.weaponsPage(mockedPlayer, model);
        assertEquals("weapons", viewName);
    }

    @ParameterizedTest
    @CsvSource({"true", "false"})
    void buyWeapons_trueAndFalseTest(boolean isEnoughGold) {

        when(playerServiceMock.buyWeapons(any(Player.class),
                ArgumentMatchers.<long[]>any(), ArgumentMatchers.<long[]>any()))
                .thenReturn(isEnoughGold);

        long[] attackWeapons = new long[0], defenceWeapons = new long[3];
        String viewName = playerControllerMock.buyWeapons(mockedPlayer, attackWeapons, defenceWeapons, model);

        if (isEnoughGold) {
            assertEquals("redirect:weapons", viewName);
        } else {
            assertEquals("weapons", viewName);
            assertEquals("Insufficient gold. Please try again.", model.get("errorMessage"));
        }

        verify(playerServiceMock, times(1))
                .buyWeapons(mockedPlayer, attackWeapons, defenceWeapons);
    }

    @Test
    void sellWeapons() {
    }

    @Test
    void upgradesPage() {

        String viewName = playerControllerMock.upgradesPage(mockedPlayer, model);
        assertEquals("upgrades", viewName);
    }

    @Test
    void buyUpgrade() {
    }

    @Test
    void sciencePage() {

        String viewName = playerControllerMock.sciencePage(mockedPlayer, model);
        assertEquals("science", viewName);
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