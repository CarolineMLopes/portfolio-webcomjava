<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Resultado - Loja Virtual</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/resultado.css">
</head>
<body>

    <div class="container">
        <h2>Resultado da Consulta</h2>

        <%-- Mensagem de erro --%>
        <c:if test="${not empty erro}">
            <p class="erro">${erro}</p>
        </c:if>

        <%-- Dados do produto --%>
        <c:if test="${not empty produto}">
            <div class="info">ID: <span>${produto.id}</span></div>
            <div class="info">Nome: <span>${produto.nome}</span></div>
            <div class="info">Descrição: <span>${produto.descricao}</span></div>
            <hr>
            <div class="info">Preço: <span class="preco">R$ ${produto.preco}</span></div>
        </c:if>

        <a href="${pageContext.request.contextPath}/">&#8592; Voltar para busca</a>
    </div>

</body>
</html>
