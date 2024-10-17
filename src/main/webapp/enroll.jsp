<%@ page import="java.util.List" %>
<%@ page import="course_1.Course_1" %>
<%@ page import="course_1.course_1DButil" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Explore Our Courses</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<style>
    body {
       font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-image: url="assets/img/back.jpg";  
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
    }
    .container {
        max-width: 1200px;
        margin: 50px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 20px;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        overflow: hidden;
    }
    h1 {
        text-align: center;
        color: #333;
        margin-bottom: 30px;
    }
    .course-grid {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
        grid-gap: 30px;
    }
    .course {
        background-color: #fff;
        border-radius: 20px;
        overflow: hidden;
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        transition: transform 0.3s ease, box-shadow 0.3s ease;
    }
    .course:hover {
        transform: translateY(-5px);
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
    }
    .course img {
        width: 100%;
        height: auto;
        border-radius: 20px 20px 0 0;
    }
    .course-content {
        padding: 20px;
    }
    .course-title {
        margin: 0;
        font-size: 22px;
        color: #333;
        margin-bottom: 10px;
    }
    .course-description {
        color: #666;
        font-size: 16px;
        margin-bottom: 20px;
    }
    .enroll-btn {
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        padding: 10px 20px;
        cursor: pointer;
        transition: background-color 0.3s ease, transform 0.2s ease;
        display: inline-block;
        text-decoration: none;
        font-size: 16px;
    }
    .enroll-btn:hover {
        background-color: #0056b3;
        transform: translateY(-2px);
    }
    .enroll-btn i {
        margin-right: 5px;
    }
    .enroll-btn:active {
        transform: translateY(1px);
    }
</style>
</head>
<body>

<div class="container">
    <h1>Explore Our Courses</h1>
    
    <div class="course-grid">
        <% 
        // Retrieve all course details from the database
        List<Course_1> courses = course_1DButil.getAllCourse();
        
        // Iterate over the list of courses and generate HTML content for each course
        for (Course_1 course : courses) {
        %>
        <div class="course">
            <!-- Course Image -->
            <img src="assets/img/cou.jpg" alt="Course Image">
            <div class="course-content">
                <!-- Course Title -->
                <h3 class="course-title"><%= course.getCname() %></h3>
                <!-- Course Description -->
                <p class="course-description"><%= course.getcDescription() %></p>
                <!-- Enroll Button -->
                <a href="#" class="enroll-btn"><i class="fas fa-user-plus"></i>Enroll Now</a>
            </div>
        </div>
        <% } // End of for loop %>
    </div>
</div>

</body>
</html>
