<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<%@ include file="common/player-resource-bar.jspf" %>
<div class="container">

    <h1>Account Statistics</h1>

    <div class="row">
        <div class="col-md-3"><b>Username</b></div>
        <div class="col-md-9"><u><a href="/stats/${name}">${name}</a></u></div>
        <div class="col-md-3"><b>E-mail Address</b></div>
        <div class="col-md-9">jackmcgeown@yahoo.co.uk</div>
    </div>

    </br>
    </br>

    <h1>Army Statistics</h1>
    <div class="row">
        <div class="col-md-3"><b>Attack</b></div>
        <div class="col-md-4">${attack}</div>
        <div class="col-md-5">Rank: #1</div>

        <div class="col-md-3"><b>Defense</b></div>
        <div class="col-md-4">${defense}</div>
        <div class="col-md-5">Rank: #1</div>

        <div class="col-md-3"><b>Espionage</b></div>
        <div class="col-md-4">${spy}</div>
        <div class="col-md-5">Rank: #1</div>
    </div>

    </br>
    </br>

    <h1>Economy Statistics</h1>
    <div class="row">
        <div class="col-md-3"><b>Current Gold</b></div>
        <div class="col-md-9">${gold}</div>

        <div class="col-md-3"><b>Gold Income</b></div>
        <div class="col-md-9">0</div>

        <div class="col-md-3"><b>Current Food</b></div>
        <div class="col-md-9">${food}</div>

        <div class="col-md-3"><b>Farming Income</b></div>
        <div class="col-md-9">0</div>
    </div>
    </br>
    <div class="row">
        <div class="col-md-3"><b>Battle Turns</b></div>
        <div class="col-md-9">${battleturns}</div>
    </div>

    </br>
    </br>

    <h1>Citizens Statistics</h1>
    <div class="row">
        <div class="col-md-3"><b>Total Population</b></div>
        <div class="col-md-9">0</div>

        <div class="col-md-3"><b>Villagers</b></div>
        <div class="col-md-9">0</div>

        <div class="col-md-3"><b>Soldiers</b></div>
        <div class="col-md-9">0</div>
    </div>

<%@ include file="common/footer.jspf" %>