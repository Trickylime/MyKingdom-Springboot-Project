<style>
    .fixed-width {
        width: 175px; /* Adjust the width as per your preference */
    }
</style>

<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<%@ include file="common/player-resource-bar.jspf" %>
<div class="container">

    <h1>Villagers</h1>

    <div>
        Spend your food to hire new villagers for your kingdom. </br>
        > Workers increase your income.</br>
        > Farmers increase your food production.</br>
        > Spies increase your espionage power.
    </div>

    </br>

    <div style="text-align: center;"> <!-- Center the text -->
        <pre><b style="font-size: 20px; color: red;">${errorMessage}</b></pre> <!-- Increase font size and change color -->
    </div>


    <div><b>Current Food Supply:</b> ${player.food}</div>

    </br>

    <form:form method="post" action="buyVillagers">
        <table class="table">
            <thead>
                <tr>
                    <th class="fixed-width">Unit</th>
                    <th class="fixed-width">Quantity</th>
                    <th class="fixed-width">Cost</th>
                    <th class="fixed-width">Hire Villagers</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Workers</td>
                    <td>${player.workers}</td>
                    <td>20 Food</td>
                    <td><input type="number" id="workers" name="workers" value="0" required min="0" max="9999" size="10"/></td>
                </tr>
                <tr>
                    <td>Farmers</td>
                    <td>${player.farmers}</td>
                    <td>20 Food</td>
                    <td><input type="number" id="farmers" name="farmers" value="0" required min="0" max="9999" size="10"/></td>
                </tr>
                <tr>
                    <td>Spies</td>
                    <td>${player.spies}</td>
                    <td>20 Food</td>
                    <td><input type="number" id="spies" name="spies" value="0" required min="0" max="9999" size="10"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><input type="submit" value="Buy Villagers" ></td>
                </tr>
            </tbody>
        </table>
    </form:form>



    </br>
    <div><b>Sell Villagers</b></div>
    <hr>
    </br>

    <form:form method="post" action="sellVillagers">
            <table class="table">
                <thead>
                    <tr>
                        <th class="fixed-width">Unit</th>
                        <th class="fixed-width">Quantity</th>
                        <th class="fixed-width">Cost</th>
                        <th class="fixed-width">Sell Villagers</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Workers</td>
                        <td>${player.workers}</td>
                        <td>20 Food</td>
                        <td><input type="number" id="workersSell" name="workers" value="0" required min="0" max="9999" size="10"/></td>
                    </tr>
                    <tr>
                        <td>Farmers</td>
                        <td>${player.farmers}</td>
                        <td>20 Food</td>
                        <td><input type="number" id="farmersSell" name="farmers" value="0" required min="0" max="9999" size="10"/></td>
                    </tr>
                    <tr>
                        <td>Spies</td>
                        <td>${player.spies}</td>
                        <td>20 Food</td>
                        <td><input type="number" id="spiesSell" name="spies" value="0" required min="0" max="9999" size="10"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><input type="submit" value="Sell Villagers" ></td>
                    </tr>
                </tbody>
            </table>
        </form:form>

</div>

<%@ include file="common/footer.jspf" %>