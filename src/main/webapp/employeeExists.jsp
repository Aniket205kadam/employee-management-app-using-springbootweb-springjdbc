<%@page language="java" %>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
<link rel="stylesheet" href="style.css">
<style>
.container {
    display: flex;
    text-align: left;
    background-color: #178932;
}

.container img {
    width: 200px;
    height: 200px;
    margin-right: 20px;
}
.button {
	text-align: left;
}
</style>
</head>
<body>

<div class="container">
	<img src="person.png" alt="Employee image">
    <div>
        <p>
            <strong>Name: </strong> ${empId}
        </p>
        <p>
            <strong>Employee Id: </strong> ${name}
        </p>
        <p>
            <strong>Department: </strong> ${department}
        </p>
        <p>
            <strong>Salary: </strong> ${salary}
        </p>
    </div>

</div>
<div class="button">
	<a href="index.jsp" class="btn"><</a>
</div>
</body>
</html>
