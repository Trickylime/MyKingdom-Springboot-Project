package com.trickylime.springboot.mykingdom.account;

import com.trickylime.springboot.mykingdom.game.player.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AccountService {


    private PlayerRepository playerRepository;

    public AccountService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public enum ValidAccountResult {
        SUCCESS,
        INVALID_EMAIL_CHARACTERS,
        INVALID_EMAIL_IN_USE,
        INVALID_USERNAME_CHARACTERS,
        INVALID_USERNAME_IN_USE
    }

    public ValidAccountResult createAccount(String email, String username, String password) {

        /*TODO: This isn't going to work, need to return player
        */

        if (!isEmailValid(email)) return ValidAccountResult.INVALID_EMAIL_CHARACTERS;
        if (!isUsernameValid(username)) return ValidAccountResult.INVALID_USERNAME_CHARACTERS;
        if (isEmailTaken(email)) return ValidAccountResult.INVALID_EMAIL_IN_USE;
        if (isUsernameTaken(username)) return ValidAccountResult.INVALID_USERNAME_IN_USE;

        return ValidAccountResult.SUCCESS;
    }

    public static boolean isValid(String input, String patternStr) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean isEmailValid(String email) {
        final String VALID_EMAIL_CHARACTERS = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return isValid(email, VALID_EMAIL_CHARACTERS);
    }

    public static boolean isUsernameValid(String username) {
        final String VALID_USERNAME_CHARACTERS = "^[a-zA-Z0-9._-]+$";
        return isValid(username, VALID_USERNAME_CHARACTERS);
    }

    public boolean isUsernameTaken(String username) {
        return playerRepository.existsByUsername(username);
    }

    public boolean isEmailTaken(String email) {
        return playerRepository.existsByEmail(email);
    }
}
