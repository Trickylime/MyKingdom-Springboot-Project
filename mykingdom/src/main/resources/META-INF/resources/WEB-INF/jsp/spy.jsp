<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<%@ include file="common/player-resource-bar.jspf" %>
<div class="container">

    <h1>Espionage Results</h1>

    <div class="row">
        <div class="col-md-3"><b>Username</b></div>
        <div class="col-md-9"><u><a href="/stats/${name}">${opponent.username}</a></u></div>
    </div>

    </br>

    <h1>Army Statistics</h1>
    <div class="row">
        <div class="col-md-3"><b>Attack</b></div>
        <div class="col-md-4">${opponent.attack}</div>
        <div class="col-md-5">Rank: #1</div>

        <div class="col-md-3"><b>Defense</b></div>
        <div class="col-md-4">${opponent.defense}</div>
        <div class="col-md-5">Rank: #1</div>

        <div class="col-md-3"><b>Espionage</b></div>
        <div class="col-md-4">${opponent.spy}</div>
        <div class="col-md-5">Rank: #1</div>
    </div>

    </br>
    </br>

    <h1>Economy Statistics</h1>
    <div class="row">
        <div class="col-md-3"><b>Current Gold</b></div>
        <div class="col-md-9">${opponent.gold}</div>

        <div class="col-md-3"><b>Gold Income</b></div>
        <div class="col-md-9">${opponent.goldIncome}</div>

        <div class="col-md-3"><b>Current Food</b></div>
        <div class="col-md-9">${opponent.food}</div>

        <div class="col-md-3"><b>Farming Income</b></div>
        <div class="col-md-9">${opponent.goldIncome}</div>
    </div>
    </br>
    <div class="row">
        <div class="col-md-3"><b>Battle Turns</b></div>
        <div class="col-md-9">${opponent.battleTurns}</div>
    </div>

    </br>
    </br>

    <h1>Citizens Statistics</h1>
    <div class="row">
        <div class="col-md-3"><b>Total Population</b></div>
        <div class="col-md-9">${opponent.villagers.total + opponent.soldiers.getTotal("total")}</div>

        <div class="col-md-3"><b>Villagers</b></div>
        <div class="col-md-9">${opponent.villagers.total}</div>

        <div class="col-md-3"><b>Soldiers</b></div>
        <div class="col-md-9">${opponent.soldiers.getTotal("total")}</div>
    </div>
</div>

<%@ include file="common/footer.jspf" %>