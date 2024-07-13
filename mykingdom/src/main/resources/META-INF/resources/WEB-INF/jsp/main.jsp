<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<%@ include file="common/player-resource-bar.jspf" %>
<div class="container">

    <h1>Account Statistics</h1>

    <div class="row">
        <div class="col-md-3"><b>Username</b></div>
        <div class="col-md-9"><u><a href="/stats/${name}">${player.username}</a></u></div>
        <div class="col-md-3"><b>E-mail Address</b></div>
        <div class="col-md-9">jackmcgeown@yahoo.co.uk</div>
    </div>

    </br>
    </br>

    <h1>Army Statistics</h1>
    <div class="row">
        <div class="col-md-3"><b>Attack</b></div>
        <div class="col-md-4">${player.attack}</div>
        <div class="col-md-5">Rank: #1</div>

        <div class="col-md-3"><b>Defense</b></div>
        <div class="col-md-4">${player.defense}</div>
        <div class="col-md-5">Rank: #1</div>

        <div class="col-md-3"><b>Espionage</b></div>
        <div class="col-md-4">${player.spy}</div>
        <div class="col-md-5">Rank: #1</div>
    </div>

    </br>
    </br>

    <h1>Economy Statistics</h1>
    <div class="row">
        <div class="col-md-3"><b>Current Gold</b></div>
        <div class="col-md-9">${player.gold}</div>

        <div class="col-md-3"><b>Gold Income</b></div>
        <div class="col-md-9">${player.goldIncome}</div>

        <div class="col-md-3"><b>Current Food</b></div>
        <div class="col-md-9">${player.food}</div>

        <div class="col-md-3"><b>Farming Income</b></div>
        <div class="col-md-9">${player.farmingIncome}</div>
    </div>
    </br>
    <div class="row">
        <div class="col-md-3"><b>Battle Turns</b></div>
        <div class="col-md-9">${player.battleTurns}</div>
    </div>

    </br>
    </br>

    <h1>Citizens Statistics</h1>
    <div class="row">
        <div class="col-md-3"><b>Total Population</b></div>
        <div class="col-md-9">${player.villagers.total + player.soldiers.getTotal("total")}</div>

        <div class="col-md-3"><b>Villagers</b></div>
        <div class="col-md-9">${player.villagers.total}</div>

        <div class="col-md-3"><b>Soldiers</b></div>
        <div class="col-md-9">${player.soldiers.getTotal("total")}</div>
    </div>
</div>

<%@ include file="common/footer.jspf" %>