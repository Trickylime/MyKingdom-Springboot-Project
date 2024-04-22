<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<%@ include file="common/player-resource-bar.jspf" %>
<div class="container">
    <h1><b>Battle Results!</b></h1>
    <hr>
    <div>You lead your army in to battle!</div>
    </br>
    <div>your forces deal ${player.attack} damage!</div>
    <div>${opponent.username}s defenses deal ${opponent.defense} damage!</div>
    </br>
    <div>Your army was defeated.</div>
</div>
<%@ include file="common/footer.jspf" %>