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
                    <td>Wooden Sword</td>
                    <td>${player.weapons.attackWepLvl0}</td>
                    <td>${player.weapons.wepLvl0Cost} Gold</td>
                    <td>${player.weapons.wepLvl0Str}</td>
                    <td><input type="number" name="attackWepLvl0" value="0" required min="0" max="9999" size="10"/></td>
                </tr>
                <tr>
                    <td>Steel Sword</td>
                    <td>${player.weapons.attackWepLvl1}</td>
                    <td>${player.weapons.wepLvl1Cost} Gold</td>
                    <td>${player.weapons.wepLvl1Str}</td>
                    <td><input type="number" name="attackWepLvl1" value="0" required min="0" max="9999" size="10"/></td>
                </tr>
                <tr>
                    <td>EarthShaking Great Sword</td>
                    <td>${player.weapons.attackWepLvl2}</td>
                    <td>${player.weapons.wepLvl2Cost} Gold</td>
                    <td>${player.weapons.wepLvl2Str}</td>
                    <td><input type="number" name="attackWepLvl2" value="0" required min="0" max="9999" size="10"/></td>
                </tr>
                <tr>
                    <td>Planet Splitting God Sword</td>
                    <td>${player.weapons.attackWepLvl3}</td>
                    <td>${player.weapons.wepLvl3Cost} Gold</td>
                    <td>${player.weapons.wepLvl3Str}</td>
                    <td><input type="number" name="attackWepLvl3" value="0" required min="0" max="9999" size="10"/></td>
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
                    <td>SlingShot</td>
                    <td>${player.weapons.defendWepLvl0}</td>
                    <td>${player.weapons.wepLvl0Cost} Gold</td>
                    <td>${player.weapons.wepLvl0Str}</td>
                    <td><input type="number" name="defendWepLvl0" value="0" required min="0" max="9999" size="10"/></td>
                </tr>

                <tr>
                    <td>Longbow</td>
                    <td>${player.weapons.defendWepLvl1}</td>
                    <td>${player.weapons.wepLvl1Cost} Gold</td>
                    <td>${player.weapons.wepLvl1Str}</td>
                    <td><input type="number" name="defendWepLvl1" value="0" required min="0" max="9999" size="10"/></td>
                </tr>

                <tr>
                    <td>SkullSplitter Compound Bow</td>
                    <td>${player.weapons.defendWepLvl2}</td>
                    <td>${player.weapons.wepLvl2Cost} Gold</td>
                    <td>${player.weapons.wepLvl2Str}</td>
                    <td><input type="number" name="defendWepLvl2" value="0" required min="0" max="9999" size="10"/></td>
                </tr>

                <tr>
                    <td>Crystal God Bow</td>
                    <td>${player.weapons.defendWepLvl3}</td>
                    <td>${player.weapons.wepLvl3Cost} Gold</td>
                    <td>${player.weapons.wepLvl3Str}</td>
                    <td><input type="number" name="defendWepLvl3" value="0" required min="0" max="9999" size="10"/></td>
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
                    <td>Wooden Sword</td>
                    <td>${player.weapons.attackWepLvl0}</td>
                    <td>${player.weapons.wepLvl0RefundCost} Gold</td>
                    <td>${player.weapons.wepLvl0Str}</td>
                    <td><input type="number" name="attackWepLvl0" value="0" required min="0" max="9999" size="10"/></td>
                </tr>
                <tr>
                    <td>Steel Sword</td>
                    <td>${player.weapons.attackWepLvl1}</td>
                    <td>${player.weapons.wepLvl1RefundCost} Gold</td>
                    <td>${player.weapons.wepLvl1Str}</td>
                    <td><input type="number" name="attackWepLvl1" value="0" required min="0" max="9999" size="10"/></td>
                </tr>
                <tr>
                    <td>EarthShaking Great Sword</td>
                    <td>${player.weapons.attackWepLvl2}</td>
                    <td>${player.weapons.wepLvl2RefundCost} Gold</td>
                    <td>${player.weapons.wepLvl2Str}</td>
                    <td><input type="number" name="attackWepLvl2" value="0" required min="0" max="9999" size="10"/></td>
                </tr>
                <tr>
                    <td>Planet Splitting God Sword</td>
                    <td>${player.weapons.attackWepLvl3}</td>
                    <td>${player.weapons.wepLvl3RefundCost} Gold</td>
                    <td>${player.weapons.wepLvl3Str}</td>
                    <td><input type="number" name="attackWepLvl3" value="0" required min="0" max="9999" size="10"/></td>
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
                    <td>SlingShot</td>
                    <td>${player.weapons.defendWepLvl0}</td>
                    <td>${player.weapons.wepLvl0RefundCost} Gold</td>
                    <td>${player.weapons.wepLvl0Str}</td>
                    <td><input type="number" name="defendWepLvl0" value="0" required min="0" max="9999" size="10"/></td>
                </tr>

                <tr>
                    <td>Longbow</td>
                    <td>${player.weapons.defendWepLvl1}</td>
                    <td>${player.weapons.wepLvl1RefundCost} Gold</td>
                    <td>${player.weapons.wepLvl1Str}</td>
                    <td><input type="number" name="defendWepLvl1" value="0" required min="0" max="9999" size="10"/></td>
                </tr>

                <tr>
                    <td>SkullSplitter Compound Bow</td>
                    <td>${player.weapons.defendWepLvl2}</td>
                    <td>${player.weapons.wepLvl2RefundCost} Gold</td>
                    <td>${player.weapons.wepLvl2Str}</td>
                    <td><input type="number" name="defendWepLvl2" value="0" required min="0" max="9999" size="10"/></td>
                </tr>

                <tr>
                    <td>Crystal God Bow</td>
                    <td>${player.weapons.defendWepLvl3}</td>
                    <td>${player.weapons.wepLvl3RefundCost} Gold</td>
                    <td>${player.weapons.wepLvl3Str}</td>
                    <td><input type="number" name="defendWepLvl3" value="0" required min="0" max="9999" size="10"/></td>
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