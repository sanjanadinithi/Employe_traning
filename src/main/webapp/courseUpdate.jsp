<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<style type="text/css">
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }

        form {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
        }

        th {
            background-color: #007bff;
            color: white;
            font-weight: bold;
        }

        input[type="text"], input[type="url"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-top: 6px;
            margin-bottom: 16px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

	<%
		String cID = request.getParameter("cID");
		String cname = request.getParameter("cname");
		String cDuration = request.getParameter("cDuration");
		String cInstructor = request.getParameter("cInstructor");
		String cDescription = request.getParameter("cDescription");
		String cLink = request.getParameter("cLink");
	%>
	
	
	<form action="update" method="post">
	<table>
		<tr>
			<td>course ID</td>
			<td><input type="text" name="cID" value="<%= cID %>" readonly></td>
		</tr>
		<tr>
			<td>New Name</td>
			<td><input type="text" name="cname" value="<%= cname %>"></td>
		</tr>
		<tr>
		<td>New Duration</td>
		<td><input type="text" name="cDuration" value="<%= cDuration %>"></td>
	</tr>
	<tr>
		<td>New Instructor</td>
		<td><input type="text" name="cInstructor" value="<%= cInstructor %>"></td>
	</tr>
	<tr>
		<td>New Description</td>
		<td><input type="text" name="cDescription" value="<%= cDescription %>"></td>
	</tr>
	<tr>
		<td>New Link</td>
		<td><input type="url" name="cLink" value="<%= cLink %>"></td>
	</tr>		
	</table>
	<br>
	<input type="submit" name="submit" value="Update My Data">
	</form>

</body>
</html>