<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<%@ include file="common/player-resource-bar.jspf" %>
<div class="container">

    <hr>
    <h1>Player Stats</h1>
    </br>
    <div class="row">
        <div class="col-md-3">Username: </div>
        <div class="col-md-9">${opponent.username}</div>

        <div class="col-md-3">Rank: </div>
        <div class="col-md-9">(PlayerRank Here) </div>

        <div class="col-md-3">Gold: </div>
        <div class="col-md-9">${opponent.gold}</div>

        <div class="col-md-3">Population: </div>
        <div class="col-md-9">${opponent.population}</div>
    </div>
    </br>
    <hr>
    </br>

    <div style="text-align: center;"> <!-- Center the text -->
        <pre><b style="font-size: 20px; color: red;">${errorMessage}</b></pre> <!-- Increase font size and change color -->
    </div>

    <div class="row">
        <div class="col-md-3"><h1>Raid For Gold</h1></div>
        <div class="col-md-9">Raids in the last 24 hours 0/5</div>
        </br>
        <div class="col-md-3"><b>Battle Turns</b></div>
        <form:form method="post" action="../battle">
            <div class="col-md-4">
                <input type="number" name="battleTurns" value="0" required min="0" max="10" size="5"/>
            </div>
            <div class="col-md-5">
                <input type="submit" value="ATTACK" >
                <input type="hidden" name="opponentUsername" value="${opponent.username}">
            </div>
        </form:form>
    </div>

    </br>

    <h1>Infiltrate For More Stats</h1>
    <div>
        <form:form method="post" action="../spy">
            <input type="submit" value="SPY" >
            <input type="hidden" name="opponentUsername" value="${opponent.username}">
        </form:form>
    </div>

    </br>
    <hr>
<%@ include file="common/footer.jspf" %>