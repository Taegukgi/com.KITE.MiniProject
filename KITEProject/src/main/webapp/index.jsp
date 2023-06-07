<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Customer Consultation Questionnaire</title>
	<link rel="stylesheet" href="CSS/Quest.css">
	<script src="../webapp/JS/Quest.js"></script>
</head>
<body>
	 <div class="container">
        <h1>Customer Consultation Questionnaire</h1>
        <form id="consultation-form">
            <label for="name">Name:</label>
			<input type="text" id="name" name="name" required>

			<label for="birthyear">BirthYear:</label>
			<input type="text" id="birthyear" name="birthyear" required>

			<label for="gender">Gender:</label>
			<input type="text" id="gender" name="gender" required>
              
        </form>
     </div>

</body>
</html>