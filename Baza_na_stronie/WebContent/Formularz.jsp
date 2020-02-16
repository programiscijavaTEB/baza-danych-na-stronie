<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="formularz" method="post">
		<input type="text" name="imie">Podaj imię<br /> 
		<input type="text" name="nazwisko">Podaj nazwisko<br /> 
		<input type="text" name="wiek">Podaj swój wiek<br /> 
		<input type="submit" value="zapis">
	</form>
		<form action="odczyt" method="post">
		<input type="submit" value="odczyt">
	</form>
</body>
</html>