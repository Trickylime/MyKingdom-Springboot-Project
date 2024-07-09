<style>
    .fixed-width {
        width: 175px; /* Adjust the width as per your preference */
    }
</style>

<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<%@ include file="common/player-resource-bar.jspf" %>
<div class="container">

    <h1>Your Raids</h1>

    <table class="table">
        <thead>
            <tr>
                <th class="fixed-width">You Raided</th>
                <th class="fixed-width">Time</th>
                <th class="fixed-width">Your attack</th>
                <th class="fixed-width">Their Defense</th>
                <th class="fixed-width">Outcome</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${attackHistory}" var="attackHistory">
                <tr>
                    <td>${attackHistory.opponent.username}</td>
                    <td>TODO: Time</td>
                    <td>${attackHistory.attack}</td>
                    <td>${attackHistory.defense}</td>
                    <td>${attackHistory.gold} gold stolen</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h1>Raids Against You</h1>

    <table class="table">
        <thead>
            <tr>
                <th class="fixed-width">Raided You</th>
                <th class="fixed-width">Time</th>
                <th class="fixed-width">Your defense</th>
                <th class="fixed-width">Their Attack</th>
                <th class="fixed-width">Outcome</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${defenseHistory}" var="defenseHistory">
                <tr>
                    <td>${defenseHistory.player.username}</td>
                    <td>TODO: Time</td>
                    <td>${defenseHistory.defense}</td>
                    <td>${defenseHistory.attack}</td>
                    <td>${defenseHistory.gold} gold lost</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="common/footer.jspf" %>