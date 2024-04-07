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
                    <c:if test="${!player.science.getAttackersUnlocked(0)}">
                        <form:form method="post" action="research">
                            <input type="submit" value="Research">
                            <input type="hidden" name="researchValue" value="atkLvl0">
                        </form:form>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>${player.soldiers.getAttackerNames(1)}</td>
                <td>${player.soldiers.getAttackerNames(0)}</td>
                <td>${player.science.getSoldiersCost(1)} Gold</td>
                <td>
                    <c:if test="${player.science.getAttackersUnlocked(0) && !player.science.getAttackersUnlocked(1)}">
                        <form:form method="post" action="research">
                            <input type="submit" value="Research">
                            <input type="hidden" name="researchValue" value="atkLvl1">
                        </form:form>
                    </c:if>
                </td>
            </tr>
            <tr>

                <td>${player.soldiers.getAttackerNames(2)}</td>
                <td>${player.soldiers.getAttackerNames(1)}</td>
                <td>${player.science.getSoldiersCost(2)} Gold</td>
                <td>
                    <c:if test="${player.science.getAttackersUnlocked(1) && !player.science.getAttackersUnlocked(2)}">
                        <form:form method="post" action="research">
                            <input type="submit" value="Research">
                            <input type="hidden" name="researchValue" value="atkLvl2">
                        </form:form>
                    </c:if>
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
                    <c:if test="${!player.science.getDefendersUnlocked(0)}">
                        <form:form method="post" action="research">
                            <input type="submit" value="Research">
                            <input type="hidden" name="researchValue" value="defLvl0">
                        </form:form>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>${player.soldiers.getDefenderNames(1)}</td>
                <td>${player.soldiers.getDefenderNames(0)}</td>
                <td>${player.science.getSoldiersCost(1)} Gold</td>
                <td>
                    <c:if test="${player.science.getDefendersUnlocked(0) && !player.science.getDefendersUnlocked(1)}">
                        <form:form method="post" action="research">
                            <input type="submit" value="Research">
                            <input type="hidden" name="researchValue" value="defLvl1">
                        </form:form>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>${player.soldiers.getDefenderNames(2)}</td>
                <td>${player.soldiers.getDefenderNames(1)}</td>
                <td>${player.science.getSoldiersCost(2)} Gold</td>
                <td>
                    <c:if test="${player.science.getDefendersUnlocked(1) && !player.science.getDefendersUnlocked(2)}">
                        <form:form method="post" action="research">
                            <input type="submit" value="Research">
                            <input type="hidden" name="researchValue" value="defLvl2">
                        </form:form>
                    </c:if>
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
                    <c:if test="${!player.science.getWeaponsUnlocked(1)}">
                        <form:form method="post" action="research">
                            <input type="submit" value="Research">
                            <input type="hidden" name="researchValue" value="weaponLvl1">
                        </form:form>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>Enchant Table</td>
                <td>Furnace</td>
                <td>${player.science.getWeaponsCost(1)} Gold</td>
                <td>
                    <c:if test="${player.science.getWeaponsUnlocked(1) && !player.science.getWeaponsUnlocked(2)}">
                        <form:form method="post" action="research">
                            <input type="submit" value="Research">
                            <input type="hidden" name="researchValue" value="weaponLvl2">
                        </form:form>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>God Workbench</td>
                <td>Enchant Table</td>
                <td>${player.science.getWeaponsCost(2)} Gold</td>
                <td>
                    <c:if test="${player.science.getWeaponsUnlocked(2) && !player.science.getWeaponsUnlocked(3)}">
                        <form:form method="post" action="research">
                            <input type="submit" value="Research">
                            <input type="hidden" name="researchValue" value="weaponLvl3">
                        </form:form>
                    </c:if>
                </td>
            </tr>
        </tbody>
    </table>
    </br>
    <table class="table">
        <thead>
            <tr>
                <th class="fixed-width">Ward Research</th>
                <th class="fixed-width">Required</th>
                <th class="fixed-width">Research Cost</th>
                <th class="fixed-width">Research</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Ward1</td>
                <td>-</td>
                <td>${player.science.getWardsCost(0)} Gold</td>
                <td>
                    <c:if test="${!player.science.getWardsUnlocked(0)}">
                        <form:form method="post" action="research">
                            <input type="submit" value="Research">
                            <input type="hidden" name="researchValue" value="wardLvl0">
                        </form:form>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>Ward2</td>
                <td>Ward1</td>
                <td>${player.science.getWardsCost(1)} Gold</td>
                <td>
                    <c:if test="${player.science.getWardsUnlocked(0) && !player.science.getWardsUnlocked(1)}">
                        <form:form method="post" action="research">
                            <input type="submit" value="Research">
                            <input type="hidden" name="researchValue" value="wardLvl1">
                        </form:form>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>Ward3</td>
                <td>Ward2</td>
                <td>${player.science.getWardsCost(2)} Gold</td>
                <td>
                    <c:if test="${player.science.getWardsUnlocked(1) && !player.science.getWardsUnlocked(2)}">
                        <form:form method="post" action="research">
                            <input type="submit" value="Research">
                            <input type="hidden" name="researchValue" value="wardLvl2">
                        </form:form>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>Ward4</td>
                <td>Ward3</td>
                <td>${player.science.getWardsCost(3)} Gold</td>
                <td>
                    <c:if test="${player.science.getWardsUnlocked(2) && !player.science.getWardsUnlocked(3)}">
                        <form:form method="post" action="research">
                            <input type="submit" value="Research">
                            <input type="hidden" name="researchValue" value="wardLvl3">
                        </form:form>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>Ward5</td>
                <td>Ward4</td>
                <td>${player.science.getWardsCost(4)} Gold</td>
                <td>
                    <c:if test="${player.science.getWardsUnlocked(3) && !player.science.getWardsUnlocked(4)}">
                        <form:form method="post" action="research">
                            <input type="submit" value="Research">
                            <input type="hidden" name="researchValue" value="wardLvl4">
                        </form:form>
                    </c:if>
                </td>
            </tr>
        </tbody>
    </table>
</div>

<%@ include file="common/footer.jspf" %>