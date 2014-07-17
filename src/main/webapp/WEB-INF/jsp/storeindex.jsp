<%-- 
    Document   : Browse
    Created on : Jul 16, 2014, 1:02:15 PM
    Author     : seannils1
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/x-icon" href="/MVCMusicStore/Images/favicon.ico">
        <link rel="stylesheet" media="screen" type="text/css" href="/MVCMusicStore/css/Site.css" />
        <title>Store Home Page</title>
    </head>
    <body>
        <div id="header" class="">
            <h1>Spring MVC Music Store</h1>
            <ul id="navlist">
                <li class="first"><a href="/MVCMusicStore/" id="current">Home</a></li>
                <li><a href="/MVCMusicStore/spring/Store/">Store</a></li>
            </ul>
        </div>
        <div>
            <h1>Browse Genres</h1>
            <h2>Select from ${genreCount} genres: </h2>
            <ul>
            <c:forEach items="${genreList}" var="myGenre">
                       <c:url var="albumUrl" value="Browse?genre=${myGenre.name}" />
                           <h3><li><a href="${albumUrl}"><c:out value="${myGenre.name}" /></a></li></h3>
            </c:forEach>
            </ul>
        </div>
    </body>
</html>
