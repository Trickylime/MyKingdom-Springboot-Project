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
        Spend your food to hire new Soldiers for your kingdom. </br>
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
                    <td>${player.soldiers.apprenticeWarCost} Food</td>
                    <td>${player.soldiers.apprenticeWarStr}</td>
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
                    <td>${player.soldiers.attackerLvl1}</td>
                    <td>${player.soldiers.attDefLvl1Cost} Food</td>
                    <td>${player.soldiers.attDefLvl1Str}</td>
                    <td><input type="number" name="attackerLvl1" value="0" required min="0" max="9999" size="10"/></td>
                </tr>
                <tr>
                    <td>${player.soldiers.getAttackerNames(1)}</td>
                    <td>${player.soldiers.attackerLvl2}</td>
                    <td>${player.soldiers.attDefLvl2Cost} Food</td>
                    <td>${player.soldiers.attDefLvl2Str}</td>
                    <td><input type="number" name="attackerLvl2" value="0" required min="0" max="9999" size="10"/></td>
                </tr>
                <tr>
                    <td>${player.soldiers.getAttackerNames(2)}</td>
                    <td>${player.soldiers.attackerLvl3}</td>
                    <td>${player.soldiers.attDefLvl3Cost} Food</td>
                    <td>${player.soldiers.attDefLvl3Str}</td>
                    <td><input type="number" name="attackerLvl3" value="0" required min="0" max="9999" size="10"/></td>
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
                    <td>${player.soldiers.defenderLvl1}</td>
                    <td>${player.soldiers.attDefLvl1Cost} Food</td>
                    <td>${player.soldiers.attDefLvl1Str}</td>
                    <td><input type="number" name="defenderLvl1" value="0" required min="0" max="9999" size="10"/></td>
                </tr>

                <tr>
                    <td>${player.soldiers.getDefenderNames(1)}</td>
                    <td>${player.soldiers.defenderLvl2}</td>
                    <td>${player.soldiers.attDefLvl2Cost} Food</td>
                    <td>${player.soldiers.attDefLvl2Str}</td>
                    <td><input type="number" name="defenderLvl2" value="0" required min="0" max="9999" size="10"/></td>
                </tr>

                <tr>
                    <td>${player.soldiers.getDefenderNames(2)}</td>
                    <td>${player.soldiers.defenderLvl3}</td>
                    <td>${player.soldiers.attDefLvl3Cost} Food</td>
                    <td>${player.soldiers.attDefLvl3Str}</td>
                    <td><input type="number" name="defenderLvl3" value="0" required min="0" max="9999" size="10"/></td>
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