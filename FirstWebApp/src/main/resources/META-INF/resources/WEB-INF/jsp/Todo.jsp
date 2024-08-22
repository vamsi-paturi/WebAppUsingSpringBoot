<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <link href = "webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel = "stylesheet">
    <title> TODOS PAGE </title>
</head>
<body>
<div class="container">

    <h1>Enter TODO Details</h1>
    <form:form method="post" modelAttribute="todo">
        Description: <form:input type="text" path="description" name="description"/>
        <form:errors path="description" cssClass="textWarning"/>
        <form:input type="hidden" path="id"/>
        <form:input type="hidden" path="done"/>
        <input type="submit" class="btn btn-success"/>
    </form:form>


</div>

<script src= "webjars\bootstrap\5.1.3\css\bootstrap.min.css"></script>
<script src= "webjars\jquery\3.6.0\jquery.min.js"></script>
</body>
</html>