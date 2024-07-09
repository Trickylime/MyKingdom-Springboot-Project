<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<%@ include file="common/player-resource-bar.jspf" %>
<div class="container">

    <h1>Espionage Results</h1>

    <div class="row">
        <div class="col-md-3"><b>Username</b></div>
        <div class="col-md-9"><u><a href="/stats/${name}">${opponent.username}</a></u></div>

        <div class="col-md-3"><b>Rank</b></div>
        <div class="col-md-9"><u>##</u></div>
    </div>

    </br>
    <p style="color: red;">Your spies fail to infiltrate the enemy's settlement</p>
</div>

<%@ include file="common/footer.jspf" %>