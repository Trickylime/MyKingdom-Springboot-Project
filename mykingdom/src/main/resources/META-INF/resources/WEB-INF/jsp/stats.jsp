<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<%@ include file="common/player-resource-bar.jspf" %>
<div class="container">


    <h1>Attack/Spy</h1>
    <div>
        Spend your Battle Turns to attack the player and attempt to steal their gold! </br>
         > 10% of you attack power per Battle Turn spent.
        </br>
        </br>
        Spy on your opponent to gain more information on their army and resources. </br>
         > some information here to make the page look nice
    </div>

    </br>

    <div style="text-align: center;"> <!-- Center the text -->
        <pre><b style="font-size: 20px; color: red;">${errorMessage}</b></pre> <!-- Increase font size and change color -->
    </div>

        <table class="table">
            <thead>
                <tr>
                    <th class="fixed-width">Opponent</th>
                    <th class="fixed-width">Raid For Gold</th>
                    <th class="fixed-width">Infiltrate For More Stats</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${opponent.username}</td>
                    <td>
                        <span style="display: inline-block;">Battle Turns:</span>
                        <form:form method="post" action="../battle" style="display: inline-block;">
                            <input type="number" name="battleTurnsSpent" value="1" required min="1" max="10" size="5" style="display: inline-block;"/>
                            <input type="submit" value="ATTACK" style="display: inline-block;">
                            <input type="hidden" name="opponentUsername" value="${opponent.username}">
                        </form:form>
                        </br>
                        > Attacks in last 24 hours ${battleCount}/5 <
                    </td>
                    <td>
                        <form:form method="post" action="../spy">
                            <input type="submit" value="SPY" >
                            <input type="hidden" name="opponentUsername" value="${opponent.username}">
                        </form:form>
                    </td>
                </tr>
            </tbody>
        </table>

    </br>

    <h1>Player Stats</h1>
    <div class="row">
        <div class="col-md-3">Rank: </div>
        <div class="col-md-9">(PlayerRank Here) </div>

        <div class="col-md-3">Gold: </div>
        <div class="col-md-9">${opponent.gold}</div>

        <div class="col-md-3">Population: </div>
        <div class="col-md-9">${opponent.population}</div>
    </div>
    <hr>
<%@ include file="common/footer.jspf" %>