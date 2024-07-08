<style>
    .fixed-width {
        width: 175px; /* Adjust the width as per your preference */
    }
</style>

<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<%@ include file="common/player-resource-bar.jspf" %>
<div class="container">

    <h1>Rankings</h1>

    <div>
        Check out where you rank on the leaderboard and choose players you want to attack or spy on! </br>
    </div>

    </br>

    <table class="table">
        <thead>
            <tr>
                <th class="fixed-width">Rank</th>
                <th class="fixed-width">Players</th>
                <th class="fixed-width">Population</th>
                <th class="fixed-width">Gold</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${playerList}" var="playerList">
                <tr>
                    <td>rank</td>
                    <td><a class="nav-link" href="/stats/${playerList.username}">${playerList.username}</a></td>
                    <td>${playerList.population}</td>
                    <td>${playerList.gold}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="common/footer.jspf" %>