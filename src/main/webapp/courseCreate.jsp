<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Course Details</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 800px;
            margin: 20px auto;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            padding: 40px;
        }

        h1 {
            text-align: center;
            margin-bottom: 30px;
            color: #333;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
        }

        .input-container {
            margin-bottom: 20px;
        }

        .input-container label {
            display: block;
            font-size: 16px;
            margin-bottom: 5px;
            color: #555;
        }

        .input-container input, .input-container textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
            transition: border-color 0.3s ease;
        }

        .input-container input:focus, .input-container textarea:focus {
            border-color: #71b7e6;
        }

        .input-icon {
            position: relative;
        }

        .input-icon i {
            position: absolute;
            top: 50%;
            right: 15px;
            transform: translateY(-50%);
            color: #ccc;
        }

        .button {
            text-align: center;
        }

        .button button {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 12px 24px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
            margin-right: 5px;
        }

        .button button:hover {
            background-color: #0056b3;
        }

        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }

        th, td {
            border: 1px solid #ddd;
            padding: 15px;
            text-align: left;
            max-width: 150px; 
            overflow: hidden;
            text-overflow: ellipsis; /* Adding ellipsis for overflow */
            white-space: nowrap; /* Preventing wrapping */
        }

        th {
            background-color: #007bff;
            color: #fff;
            font-weight: bold;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f0f0f0;
        }

        .action-buttons {
            display: flex;
            justify-content: center;
        }

        .action-buttons button {
            background-color: #dc3545;
            margin-right: 5px;
        }

        .action-buttons button:last-child {
            margin-right: 0;
        }

        .action-buttons button:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>

<!-- insert Part -->
<div class="container">
    <h1>Add Course Details</h1>
    <form action="course" method="post">
        <div class="input-container">
            <label for="course_name">Course Name:</label>
            <div class="input-icon">
                <input type="text" id="course_name" name="course_name" placeholder="Enter the course name" required>
                <i class="fas fa-book"></i>
            </div>
        </div>
        <div class="input-container">
            <label for="duration">Duration (hours):</label>
            <div class="input-icon">
                <input type="text" id="duration" name="duration" placeholder="Enter the duration in hours" required>
                <i class="fas fa-clock"></i>
            </div>
        </div>
        <div class="input-container">
            <label for="instructor">Instructor:</label>
            <div class="input-icon">
                <input type="text" id="instructor" name="instructor" placeholder="Enter the instructor's name" required>
                <i class="fas fa-user"></i>
            </div>
        </div>
        <div class="input-container">
            <label for="course_description">Course Description:</label>
            <div class="input-icon">
                <textarea id="course_description" name="course_description" placeholder="Enter the course description" required></textarea>
                <i class="fas fa-align-left"></i>
            </div>
        </div>
        <div class="input-container">
            <label for="link">Link:</label>
            <div class="input-icon">
                <input type="url" id="link" name="link" placeholder="Enter the link of the course" required>
                <i class="fas fa-link"></i>
            </div>
        </div>
        <div class="button">
            <button type="submit">Add Course</button>
        </div>
    </form>
</div>

<!-- View Part -->
<div class="container">
    <h1>Course Details</h1>
    <div style="overflow-x:auto;">
        <table>
            <tr>
                <th>Course ID</th>
                <th>Name</th>
                <th>Duration</th>
                <th>Instructor</th>
                <th>Description</th>
                <th>Link</th>
                <th>Action</th>
            </tr>
            
     <c:forEach items="${courseDetails}" var="course">
            
            <!-- update data -->
            
            <c:set var="cID" value="${course.cID}"/>
			<c:set var="cname" value="${course.cname}"/>
			<c:set var="cDuration" value="${course.cDuration}"/>
			<c:set var="cInstructor" value="${course.cInstructor}"/>
			<c:set var="cDescription" value="${course.cDescription}"/>
			<c:set var="cLink" value="${course.cLink}"/>
			
                <tr>
                    <td>${course.cID}</td>
                    <td>${course.cname}</td>
                    <td>${course.cDuration}</td>
                    <td>${course.cInstructor}</td>
                    <td>${course.cDescription}</td>
                    <td>${course.cLink}</td>
                    <td class="action-buttons">
						        
                    <!-- update data -->
                    
					<c:url value="courseUpdate.jsp" var="courseupdate">
						<c:param name="cID" value="${cID}" />
						<c:param name="cname" value="${cname}" />
						<c:param name="cDuration" value="${cDuration}" />
						<c:param name="cInstructor" value="${cInstructor}" />
						<c:param name="cDescription" value="${cDescription}" />
						<c:param name="cLink" value="${cLink}" />
					</c:url>
						
						
        	 			<a href="${courseupdate}">
                        <button style="background-color: #007bff;">Update</button>
                        </a>
                        
                    <c:url value="courseDelete.jsp" var="coursedelete">
						<c:param name="cID" value="${cID}" />
						<c:param name="cname" value="${cname}" />
						<c:param name="cDuration" value="${cDuration}" />
						<c:param name="cInstructor" value="${cInstructor}" />
						<c:param name="cDescription" value="${cDescription}" />
						<c:param name="cLink" value="${cLink}" />
					</c:url>
                                               
                        <a href="${coursedelete}">
							<button style="margin-left: 5px;">Delete</button>
						</a>
											
                </tr>
            </c:forEach>
        </table>	
    </div>
</div>
</body>
</html>