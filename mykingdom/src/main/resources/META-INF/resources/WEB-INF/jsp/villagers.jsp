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

    <div><b>Current Food Supply:</b> ${player.food}</div>

    </br>

    <form:form method="post">
        <table class="table">
            <thead>
                <tr>
                    <th>Unit</th>
                    <th>Quantity</th>
                    <th>Cost</th>
                    <th>Hire More</th>
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
                    <td><input type="submit" onclick="getValues()" class="btn btn-success"></td>
                </tr>
            </tbody>
        </table>
    </form:form>

</div>

<script>
    function getValues() {
        var workersValue = document.getElementById("workersInput").value;
        var farmersValue = document.getElementById("farmersInput").value;
        var spiesValue = document.getElementById("spiesInput").value;

        // Do something with the values (e.g., send them to the server via AJAX)
        console.log("Workers: " + workersValue);
        console.log("Farmers: " + farmersValue);
        console.log("Spies: " + spiesValue);
    }
</script>

<%@ include file="common/footer.jspf" %>