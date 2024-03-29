<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<body>

	<!-- modelAttribute名字要addAttribute一樣 -->
	<form:form action="processForm" modelAttribute="student">
	
		First name: <form:input path="firstName" />
		
		<br><br>
		
		Last name: <form:input path="lastName" />
		
		<br><br>
		
		<form:select path="country">
		
			<!-- 如果用options是collection -->
			<form:options items="${student.countryOption}"/>
		
		</form:select>
		
		<br><br>
		
		Favorite Language:
		
		<%-- Java <form:radiobutton path="favoriteLanguage" value="Java"/>
		C# <form:radiobutton path="favoriteLanguage" value="C#"/> 
		PHP <form:radiobutton path="favoriteLanguage" value="PHP"/> 
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>   --%>
			<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOption}"/>
		
		<br><br>
		
		Operating System:
		
		Linux <form:checkbox path="operatingSystems" value="Linux" />
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
		MS Windows <form:checkbox path="operatingSystems" value="MS Windows" />
		
		
		
		
		<br><br>
		
		
		
		<input type="submit" value="Submit" />
	
	</form:form>


</body>

</html>
