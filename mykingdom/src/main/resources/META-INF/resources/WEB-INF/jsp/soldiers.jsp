<style>
    .fixed-width {
        width: 175px; /* Adjust the width as per your preference */
    }
</style>

<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<%@ include file="common/player-resource-bar.jspf" %>
<div class="container">

    <h1>Soldiers</h1>

    <div>
        Spend your food to hire new Apprentice Warriors, which then can be trained as either </br>
        attackers or defenders for your kingdom. </br>
        > Attackers increase your attack power.</br>
        > Defenders increase your defense power.</br>
    </div>

    </br>

    <div style="text-align: center;"> <!-- Center the text -->
        <pre><b style="font-size: 20px; color: red;">${errorMessage}</b></pre> <!-- Increase font size and change color -->
    </div>


    <div><b>Current Food Supply:</b> ${player.food}</div>

    </br>

    <form:form method="post" action="hireApprentice">
        <table class="table">
            <thead>
                <tr>
                    <th class="fixed-width">Unit</th>
                    <th class="fixed-width">Quantity</th>
                    <th class="fixed-width">Cost</th>
                    <th class="fixed-width">Strength</th>
                    <th class="fixed-width">Hire Apprentices</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Apprentice Warriors</td>
                    <td>${player.soldiers.apprenticeWarriors}</td>
                    <td>${player.soldiers.apprenticeWarriorsCost} Food</td>
                    <td>${player.soldiers.apprenticeWarriorsStrength}</td>
                    <td><input type="number" id="apprenticeWarriors" name="apprenticeWarriors" value="0" required min="0" max="9999" size="10"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><input type="submit" value="HIRE Apprentices" ></td>
                </tr>
            </tbody>
        </table>
    </form:form>



    </br>
    <h1>Train Apprentices</h1>
    <hr>
    </br>

    <form:form method="post" action="trainApprentice">
        <table class="table">
            <thead>
                <tr>
                    <th class="fixed-width">Attackers</th>
                    <th class="fixed-width">Quantity</th>
                    <th class="fixed-width">Cost</th>
                    <th class="fixed-width">Strength</th>
                    <th class="fixed-width">Hire More</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${player.soldiers.getAttackerNames(0)}</td>
                    <td>${player.soldiers.getAttackers(0)}</td>
                    <td>${player.soldiers.getSoldiersCost(0)} Food</td>
                    <td>${player.soldiers.getSoldiersStrength(0)}</td>
                    <td><input type="number" name="attackers" value="0" required min="0" max="9999" size="10"/></td>
                </tr>
                <tr>
                    <td>${player.soldiers.getAttackerNames(1)}</td>
                    <td>${player.soldiers.getAttackers(1)}</td>
                    <td>${player.soldiers.getSoldiersCost(1)} Food</td>
                    <td>${player.soldiers.getSoldiersStrength(1)}</td>
                    <td><input type="number" name="attackers" value="0" required min="0" max="9999" size="10"/></td>
                </tr>
                <tr>
                    <td>${player.soldiers.getAttackerNames(2)}</td>
                    <td>${player.soldiers.getAttackers(2)}</td>
                    <td>${player.soldiers.getSoldiersCost(2)} Food</td>
                    <td>${player.soldiers.getSoldiersStrength(2)}</td>
                    <td><input type="number" name="attackers" value="0" required min="0" max="9999" size="10"/></td>
                </tr>
            </tbody>
        </table>

        <table class="table">
            <thead>
                <tr>
                    <th class="fixed-width">Defenders</th>
                    <th class="fixed-width">Quantity</th>
                    <th class="fixed-width">Cost</th>
                    <th class="fixed-width">Strength</th>
                    <th class="fixed-width">Hire More</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${player.soldiers.getDefenderNames(0)}</td>
                    <td>${player.soldiers.getDefenders(0)}</td>
                    <td>${player.soldiers.getSoldiersCost(0)} Food</td>
                    <td>${player.soldiers.getSoldiersStrength(0)}</td>
                    <td><input type="number" name="defenders" value="0" required min="0" max="9999" size="10"/></td>
                </tr>

                <tr>
                    <td>${player.soldiers.getDefenderNames(1)}</td>
                    <td>${player.soldiers.getDefenders(1)}</td>
                    <td>${player.soldiers.getSoldiersCost(1)} Food</td>
                    <td>${player.soldiers.getSoldiersStrength(1)}</td>
                    <td><input type="number" name="defenders" value="0" required min="0" max="9999" size="10"/></td>
                </tr>

                <tr>
                    <td>${player.soldiers.getDefenderNames(2)}</td>
                    <td>${player.soldiers.getDefenders(2)}</td>
                    <td>${player.soldiers.getSoldiersCost(2)} Food</td>
                    <td>${player.soldiers.getSoldiersStrength(2)}</td>
                    <td><input type="number" name="defenders" value="0" required min="0" max="9999" size="10"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><input type="submit" value="TRAIN Apprentices" ></td>
                </tr>
            </tbody>
        </table>
    </form:form>

</div>

<%@ include file="common/footer.jspf" %>