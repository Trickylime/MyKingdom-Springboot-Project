<style>
    .fixed-width {
        width: 175px; /* Adjust the width as per your preference */
    }
</style>

<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<%@ include file="common/player-resource-bar.jspf" %>
<div class="container">

    <h1>Science</h1>

    <div>
        Spend your gold to research new technologies to upgrade your kingdoms power and defences.</br>
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
                <th class="fixed-width">Attack Research</th>
                <th class="fixed-width">Required</th>
                <th class="fixed-width">Research Cost</th>
                <th class="fixed-width">Research</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${player.soldiers.getAttackerNames(0)}</td>
                <td>-</td>
                <td>${player.science.getSoldiersCost(0)} Gold</td>
                <td>
                    <form:form method="post" action="research">
                        <input type="submit" value="Research">
                        <input type="hidden" name="researchValue" value="atklvl0">
                    </form:form>
                </td>
            </tr>
            <tr>
                <td>${player.soldiers.getAttackerNames(1)}</td>
                <td>${player.soldiers.getAttackerNames(0)}</td>
                <td>${player.science.getSoldiersCost(1)} Gold</td>
                <td>
                    <form:form method="post" action="research">
                        <input type="submit" value="Research">
                        <input type="hidden" name="researchValue" value="atklvl1">
                    </form:form>
                </td>
            </tr>
            <tr>
                <td>${player.soldiers.getAttackerNames(2)}</td>
                <td>${player.soldiers.getAttackerNames(1)}</td>
                <td>${player.science.getSoldiersCost(2)} Gold</td>
                <td>
                    <form:form method="post" action="research">
                        <input type="submit" value="Research">
                        <input type="hidden" name="researchValue" value="atklvl2">
                    </form:form>
                </td>
            </tr>
        </tbody>
    </table>
    </br>
    <table class="table">
        <thead>
            <tr>
                <th class="fixed-width">Defence Research</th>
                <th class="fixed-width">Required</th>
                <th class="fixed-width">Research Cost</th>
                <th class="fixed-width">Research</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${player.soldiers.getDefenderNames(0)}</td>
                <td>-</td>
                <td>${player.science.getSoldiersCost(0)} Gold</td>
                <td>
                    <form:form method="post" action="research">
                        <input type="submit" value="Research">
                        <input type="hidden" name="researchValue" value="atklvl0">
                    </form:form>
                </td>
            </tr>
            <tr>
                <td>${player.soldiers.getDefenderNames(1)}</td>
                <td>${player.soldiers.getDefenderNames(0)}</td>
                <td>${player.science.getSoldiersCost(1)} Gold</td>
                <td>
                    <form:form method="post" action="research">
                        <input type="submit" value="Research">
                        <input type="hidden" name="researchValue" value="atklvl1">
                    </form:form>
                </td>
            </tr>
            <tr>
                <td>${player.soldiers.getDefenderNames(2)}</td>
                <td>${player.soldiers.getDefenderNames(1)}</td>
                <td>${player.science.getSoldiersCost(2)} Gold</td>
                <td>
                    <form:form method="post" action="research">
                        <input type="submit" value="Research">
                        <input type="hidden" name="researchValue" value="atklvl2">
                    </form:form>
                </td>
            </tr>
        </tbody>
    </table>
    </br>
    <table class="table">
        <thead>
            <tr>
                <th class="fixed-width">Blacksmith Research</th>
                <th class="fixed-width">Required</th>
                <th class="fixed-width">Research Cost</th>
                <th class="fixed-width">Research</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Furnace</td>
                <td>-</td>
                <td>${player.science.getWeaponsCost(0)} Gold</td>
                <td>
                    <form:form method="post" action="research">
                        <input type="submit" value="Research">
                        <input type="hidden" name="researchValue" value="atklvl0">
                    </form:form>
                </td>
            </tr>
            <tr>
                <td>Enchant Table</td>
                <td>Furnace</td>
                <td>${player.science.getWeaponsCost(1)} Gold</td>
                <td>
                    <form:form method="post" action="research">
                        <input type="submit" value="Research">
                        <input type="hidden" name="researchValue" value="atklvl1">
                    </form:form>
                </td>
            </tr>
            <tr>
                <td>God Workbench</td>
                <td>Enchant Table</td>
                <td>${player.science.getWeaponsCost(2)} Gold</td>
                <td>
                    <form:form method="post" action="research">
                        <input type="submit" value="Research">
                        <input type="hidden" name="researchValue" value="atklvl2">
                    </form:form>
                </td>
            </tr>
        </tbody>
    </table>
</div>

<%@ include file="common/footer.jspf" %>