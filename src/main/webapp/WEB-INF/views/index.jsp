<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Loja Virtual</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css">
</head>
<body>

    <div class="container">
        <h1>Loja Virtual</h1>
        <p>Digite o ID do produto para consultar</p>

        <form action="${pageContext.request.contextPath}/consulta" method="post">
            <input type="text" name="id" placeholder="Ex: 1" required autofocus>
            <button type="submit">Buscar Produto</button>
        </form>
    </div>

</body>
</html>
