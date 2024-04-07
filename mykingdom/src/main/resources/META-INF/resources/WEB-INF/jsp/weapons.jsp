<style>
    .fixed-width {
        width: 175px; /* Adjust the width as per your preference */
    }
</style>

<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<%@ include file="common/player-resource-bar.jspf" %>
<div class="container">

    <h1>Weapons</h1>

    <div>
        Spend your gold to buy new weapons for your soldiers. </br>
        Weapons only increase your stats if you have enough soldiers to wield them. </br>
        Upgrade your weapons on the science page! </br>
        > Attack weapons increase your attack power.</br>
        > Defend weapons increase your defense power.</br>

    </div>

    </br>

    <div style="text-align: center;"> <!-- Center the text -->
        <pre><b style="font-size: 20px; color: red;">${errorMessage}</b></pre> <!-- Increase font size and change color -->
    </div>


    <div><b>Current Gold Supply:</b> ${player.gold}</div>

    </br>

    <form:form method="post" action="buyWeapons">
        <table class="table">
            <thead>
                <tr>
                    <th class="fixed-width">Attack Weapons</th>
                    <th class="fixed-width">Quantity</th>
                    <th class="fixed-width">Cost</th>
                    <th class="fixed-width">Strength</th>
                    <th class="fixed-width">Hire More</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <c:if test="${player.science.getWeaponsUnlocked(0)}">
                        <td>${player.weapons.getAttackWeaponNames(0)}</td>
                        <td>${player.weapons.getAttackWeapons(0)}</td>
                        <td>${player.weapons.getWeaponCost(0)} Gold</td>
                        <td>${player.weapons.getWeaponStrength(0)}</td>
                        <td><input type="number" name="attackWeapons" value="0" required min="0" max="9999" size="10"/></td>
                    </c:if>
                </tr>
                <tr>
                    <c:if test="${player.science.getWeaponsUnlocked(1)}">
                        <td>${player.weapons.getAttackWeaponNames(1)}</td>
                        <td>${player.weapons.getAttackWeapons(1)}</td>
                        <td>${player.weapons.getWeaponCost(1)} Gold</td>
                        <td>${player.weapons.getWeaponStrength(1)}</td>
                        <td><input type="number" name="attackWeapons" value="0" required min="0" max="9999" size="10"/></td>
                    </c:if>
                </tr>
                <tr>
                    <c:if test="${player.science.getWeaponsUnlocked(2)}">
                        <td>${player.weapons.getAttackWeaponNames(2)}</td>
                        <td>${player.weapons.getAttackWeapons(2)}</td>
                        <td>${player.weapons.getWeaponCost(2)} Gold</td>
                        <td>${player.weapons.getWeaponStrength(2)}</td>
                        <td><input type="number" name="attackWeapons" value="0" required min="0" max="9999" size="10"/></td>
                    </c:if>
                </tr>
                <tr>
                    <c:if test="${player.science.getWeaponsUnlocked(3)}">
                        <td>${player.weapons.getAttackWeaponNames(3)}</td>
                        <td>${player.weapons.getAttackWeapons(3)}</td>
                        <td>${player.weapons.getWeaponCost(3)} Gold</td>
                        <td>${player.weapons.getWeaponStrength(3)}</td>
                        <td><input type="number" name="attackWeapons" value="0" required min="0" max="9999" size="10"/></td>
                    </c:if>
                </tr>
            </tbody>
        </table>

        <table class="table">
            <thead>
                <tr>
                    <th class="fixed-width">Defense Weapons</th>
                    <th class="fixed-width">Quantity</th>
                    <th class="fixed-width">Cost</th>
                    <th class="fixed-width">Strength</th>
                    <th class="fixed-width">Hire More</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <c:if test="${player.science.getWeaponsUnlocked(0)}">
                        <td>${player.weapons.getDefenseWeaponNames(0)}</td>
                        <td>${player.weapons.getDefenseWeapons(0)}</td>
                        <td>${player.weapons.getWeaponCost(0)} Gold</td>
                        <td>${player.weapons.getWeaponStrength(0)}</td>
                        <td><input type="number" name="defenseWeapons" value="0" required min="0" max="9999" size="10"/></td>
                    </c:if>
                </tr>

                <tr>
                    <c:if test="${player.science.getWeaponsUnlocked(1)}">
                        <td>${player.weapons.getDefenseWeaponNames(1)}</td>
                        <td>${player.weapons.getDefenseWeapons(1)}</td>
                        <td>${player.weapons.getWeaponCost(1)} Gold</td>
                        <td>${player.weapons.getWeaponStrength(1)}</td>
                        <td><input type="number" name="defenseWeapons" value="0" required min="0" max="9999" size="10"/></td>
                    </c:if>
                </tr>

                <tr>
                    <c:if test="${player.science.getWeaponsUnlocked(2)}">
                        <td>${player.weapons.getDefenseWeaponNames(2)}</td>
                        <td>${player.weapons.getDefenseWeapons(2)}</td>
                        <td>${player.weapons.getWeaponCost(2)} Gold</td>
                        <td>${player.weapons.getWeaponStrength(2)}</td>
                        <td><input type="number" name="defenseWeapons" value="0" required min="0" max="9999" size="10"/></td>
                    </c:if>
                </tr>

                <tr>
                    <c:if test="${player.science.getWeaponsUnlocked(3)}">
                        <td>${player.weapons.getDefenseWeaponNames(3)}</td>
                        <td>${player.weapons.getDefenseWeapons(3)}</td>
                        <td>${player.weapons.getWeaponCost(3)} Gold</td>
                        <td>${player.weapons.getWeaponStrength(3)}</td>
                        <td><input type="number" name="defenseWeapons" value="0" required min="0" max="9999" size="10"/></td>
                    </c:if>
                </tr>

                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><input type="submit" value="BUY Weapons" ></td>
                </tr>
            </tbody>
        </table>
    </form:form>

    </br>
    <div><b>Sell Villagers</b></div>
    <hr>
    </br>

    <form:form method="post" action="sellWeapons">
        <table class="table">
            <thead>
                <tr>
                    <th class="fixed-width">Attack Weapons</th>
                    <th class="fixed-width">Quantity</th>
                    <th class="fixed-width">Refund</th>
                    <th class="fixed-width">Strength</th>
                    <th class="fixed-width">Hire More</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <c:if test="${player.science.getWeaponsUnlocked(0)}">
                        <td>${player.weapons.getAttackWeaponNames(0)}</td>
                        <td>${player.weapons.getAttackWeapons(0)}</td>
                        <td>${player.weapons.getWeaponRefundCost(0)} Gold</td>
                        <td>${player.weapons.getWeaponStrength(0)}</td>
                        <td><input type="number" name="attackWeapons" value="0" required min="0" max="9999" size="10"/></td>
                    </c:if>
                </tr>
                <tr>
                    <c:if test="${player.science.getWeaponsUnlocked(1)}">
                        <td>${player.weapons.getAttackWeaponNames(1)}</td>
                        <td>${player.weapons.getAttackWeapons(1)}</td>
                        <td>${player.weapons.getWeaponRefundCost(1)} Gold</td>
                        <td>${player.weapons.getWeaponStrength(1)}</td>
                        <td><input type="number" name="attackWeapons" value="0" required min="0" max="9999" size="10"/></td>
                    </c:if>
                </tr>
                <tr>
                    <c:if test="${player.science.getWeaponsUnlocked(2)}">
                        <td>${player.weapons.getAttackWeaponNames(2)}</td>
                        <td>${player.weapons.getAttackWeapons(2)}</td>
                        <td>${player.weapons.getWeaponRefundCost(2)} Gold</td>
                        <td>${player.weapons.getWeaponStrength(2)}</td>
                        <td><input type="number" name="attackWeapons" value="0" required min="0" max="9999" size="10"/></td>
                    </c:if>
                </tr>
                <tr>
                    <c:if test="${player.science.getWeaponsUnlocked(3)}">
                        <td>${player.weapons.getAttackWeaponNames(3)}</td>
                        <td>${player.weapons.getAttackWeapons(3)}</td>
                        <td>${player.weapons.getWeaponRefundCost(3)} Gold</td>
                        <td>${player.weapons.getWeaponStrength(3)}</td>
                        <td><input type="number" name="attackWeapons" value="0" required min="0" max="9999" size="10"/></td>
                    </c:if>
                </tr>
            </tbody>
        </table>

        <table class="table">
            <thead>
                <tr>
                    <th class="fixed-width">Defense Weapons</th>
                    <th class="fixed-width">Quantity</th>
                    <th class="fixed-width">Refund</th>
                    <th class="fixed-width">Strength</th>
                    <th class="fixed-width">Hire More</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <c:if test="${player.science.getWeaponsUnlocked(0)}">
                        <td>${player.weapons.getDefenseWeaponNames(0)}</td>
                        <td>${player.weapons.getDefenseWeapons(0)}</td>
                        <td>${player.weapons.getWeaponRefundCost(0)} Gold</td>
                        <td>${player.weapons.getWeaponStrength(0)}</td>
                        <td><input type="number" name="defenseWeapons" value="0" required min="0" max="9999" size="10"/></td>
                    </c:if>
                </tr>

                <tr>
                    <c:if test="${player.science.getWeaponsUnlocked(1)}">
                        <td>${player.weapons.getDefenseWeaponNames(1)}</td>
                        <td>${player.weapons.getDefenseWeapons(1)}</td>
                        <td>${player.weapons.getWeaponRefundCost(1)} Gold</td>
                        <td>${player.weapons.getWeaponStrength(1)}</td>
                        <td><input type="number" name="defenseWeapons" value="0" required min="0" max="9999" size="10"/></td>
                    </c:if>
                </tr>

                <tr>
                    <c:if test="${player.science.getWeaponsUnlocked(2)}">
                        <td>${player.weapons.getDefenseWeaponNames(2)}</td>
                        <td>${player.weapons.getDefenseWeapons(2)}</td>
                        <td>${player.weapons.getWeaponRefundCost(2)} Gold</td>
                        <td>${player.weapons.getWeaponStrength(2)}</td>
                        <td><input type="number" name="defenseWeapons" value="0" required min="0" max="9999" size="10"/></td>
                    </c:if>
                </tr>

                <tr>
                    <c:if test="${player.science.getWeaponsUnlocked(3)}">
                        <td>${player.weapons.getDefenseWeaponNames(3)}</td>
                        <td>${player.weapons.getDefenseWeapons(3)}</td>
                        <td>${player.weapons.getWeaponRefundCost(3)} Gold</td>
                        <td>${player.weapons.getWeaponStrength(3)}</td>
                        <td><input type="number" name="defenseWeapons" value="0" required min="0" max="9999" size="10"/></td>
                    </c:if>
                </tr>

                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><input type="submit" value="SELL Weapons" ></td>
                </tr>
            </tbody>
        </table>
    </form:form>

</div>

<%@ include file="common/footer.jspf" %>