<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<%@ include file="common/player-resource-bar.jspf" %>
<div class="container">
    <h1><b>Battle Results!</b></h1>
    <hr>
    <div>You lead your army in to battle!</div>
    </br>
    <div style="text-align: center;"> <!-- Center the text -->
        <pre><b style="font-size: 20px; color: red;">${battleResults}</b></pre>
    </div>

</div>
<%@ include file="common/footer.jspf" %>