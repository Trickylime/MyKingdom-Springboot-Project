<style>
    #wrap {
        background: #e7e7e7;
        padding: 5%;
        text-align: center;
        display: flex;
        justify-content: space-between;
    }

    #left, #right {
         background: #ccc;
         width: 45%;
         padding: 2%;
         box-sizing: border-box;
         display: flex;
         flex-direction: column;
         justify-content: center;
         align-items: center;
    }

    form div {
        margin-bottom: 10px;
        width: 100%;
        text-align: left;
    }

    label {
        display: block;
        margin-bottom: 5px;
    }

    input {
        width: 100%;
        padding: 5px;
        box-sizing: border-box;
    }

    button {
        width: 100%;
        padding: 10px;
        background-color: #007bff;
        color: white;
        border: none;
        cursor: pointer;
    }

    button:hover {
        background-color: #0056b3;
    }
</style>


<%@ include file="common/header.jspf" %>
<div class="container">
    </br>
    </br>

    <div style="text-align: center;">
        <h1 >MyKingdom</h1>
    </div>

    </br>
    </br>

    <div id="wrap">
        <div id="left">
            <h1>Login</h1>
            <form action="${pageContext.request.contextPath}/login" method="post">
                <div>
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username"/>
                </div>
                <div>
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password"/>
                </div>
                <div>
                    <button type="submit">Login</button>
                </div>
                <a class="nav-link" href="/forgot">Forgot username or password?</a>
            </form>
        </div>
        <div id="right">
            <h1>Create Account</h1>
            <form method="post" action="createAccount">
                <div>
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required />
                </div>
                <div style="color: red;">
                    <c:if test="${not empty errorMessageEmail}">
                        <b>${errorMessageEmail}</b>
                    </c:if>
                </div>
                <div>
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" required />
                </div>
                <div style="color: red;">
                    <c:if test="${not empty errorMessageUsername}">
                        <b>${errorMessageUsername}</b>
                    </c:if>
                </div>
                <div>
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required />
                </div>
                <div style="color: red;">
                    <c:if test="${not empty errorMessagePassword}">
                        <b>${errorMessagePassword}</b>
                    </c:if>
                </div>
                <div>
                    <button type="submit">Create Account</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="common/footer.jspf" %>