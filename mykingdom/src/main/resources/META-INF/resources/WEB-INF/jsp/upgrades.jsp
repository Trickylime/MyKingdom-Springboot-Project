<style>
    .fixed-width {
        width: 175px; /* Adjust the width as per your preference */
    }
</style>

<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<%@ include file="common/player-resource-bar.jspf" %>
<div class="container">

    <h1>Upgrades</h1>

    <div>
        Spend your gold to upgrade your stats by +3% per level for your kingdom. </br>
    </div>

    </br>

    <div style="text-align: center;"> <!-- Center the text -->
        <pre><b style="font-size: 20px; color: red;">${errorMessage}</b></pre> <!-- Increase font size and change color -->
    </div>


    <div><b>Current Gold Supply:</b> ${player.gold}</div>

    </br>

    <table class="table">
        <thead>
            <tr>
                <th class="fixed-width">Upgrade Type</th>
                <th class="fixed-width">Current Level</th>
                <th class="fixed-width">Upgrade Cost</th>
                <th class="fixed-width">Upgrade</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Attack Upgrade</td>
                <td>Level ${player.upgrades.attackLevel}</td>
                <td>${player.upgrades.attackUpgradeCost} Gold</td>
                <td>
                    <form:form method="post" action="upgrades">
                        <input type="submit" value="Upgrade to Level ${player.upgrades.attackLevel + 1}">
                        <input type="hidden" name="upgradeValue" value="attack">
                    </form:form>
                </td>
            </tr>
            <tr>
                <td>Defense Upgrade</td>
                <td>Level ${player.upgrades.defenseLevel}</td>
                <td>${player.upgrades.defenseUpgradeCost} Gold</td>
                <td>
                    <form:form method="post" action="upgrades">
                        <input type="submit" value="Upgrade to Level ${player.upgrades.defenseLevel + 1}">
                        <input type="hidden" name="upgradeValue" value="defense">
                    </form:form>
                </td>
            </tr>
            <tr>
                <td>Spy Upgrade</td>
                <td>Level ${player.upgrades.spyLevel}</td>
                <td>${player.upgrades.spyUpgradeCost} Gold</td>
                <td>
                    <form:form method="post" action="upgrades">
                        <input type="submit" value="Upgrade to Level ${player.upgrades.spyLevel + 1}">
                        <input type="hidden" name="upgradeValue" value="spy">
                    </form:form>
                </td>
            </tr>
            <tr>
                <td>Farming Upgrade</td>
                <td>Level ${player.upgrades.farmLevel}</td>
                <td>${player.upgrades.farmUpgradeCost} Gold</td>
                <td>
                    <form:form method="post" action="upgrades">
                        <input type="submit" value="Upgrade to Level ${player.upgrades.farmLevel + 1}">
                        <input type="hidden" name="upgradeValue" value="farm">
                    </form:form>
                </td>
            </tr>
        </tbody>
    </table>
</div>

<%@ include file="common/footer.jspf" %>