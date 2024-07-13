package com.trickylime.springboot.mykingdom.account;

import com.trickylime.springboot.mykingdom.game.player.Player;
import com.trickylime.springboot.mykingdom.game.player.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AccountService {


    private PlayerRepository playerRepository;

    private static int playerCount = 1;
    public AccountService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;

        savePlayer(new Player("Admin", "tricky@gmail.com"));
        savePlayer(new Player("Cristian", "cristian@gmail.com"));
        savePlayer(new Player("Dean", "dean@gmail.com"));
        savePlayer(new Player("Steve", "steve@gmail.com"));
        savePlayer(new Player("Katy", "katy@gmail.com"));

    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player createAccount(String email, String username, String password) {


        validateAccountDetails(email, username, password);

        return playerRepository.save(new Player(username, email));
    }

    private void validateAccountDetails(String email, String username, String password) {
        if (!isEmailValid(email)) throw new IllegalArgumentException("Invalid Email");

        if (!isUsernameValid(username))
            throw new IllegalArgumentException("Invalid Username, username must consist of upper or lower case letters, '.', '-', '_'");

        if (isEmailTaken(email)) throw new IllegalArgumentException("Email is already in use");

        if (isUsernameTaken(username)) throw new IllegalArgumentException("Username is already in use");

        if (password.length() < 6) throw new IllegalArgumentException("Password must be at least 6 characters long");
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
