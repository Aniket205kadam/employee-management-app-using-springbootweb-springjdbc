<%@page language="java" %>
<html>
    <head>
        <title>Add Employee</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <style>
            .container {
                max-width: 400px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Add Employee</h1>
            <form action="add" method="POST">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required><br><br>

                <label for="emp_id">Employee ID:</label>
                <input type="text" name="empId" id="empId" required><br><br>

                <label for="department">Department:</label>
                <input type="text" id="department" name="department" required><br><br>

                <label for="salary">Salary:</label>
                <input type="number" id="salary" name="salary" required><br><br>

                <div class="button">
                    <button type="submit" class="btn">Add Employee</button>
                    <a href="index.jsp" class="btn_cancel">Cancel</a>
                </div>
            </form>
        </div>
    </body>
</html>