<%-- 
    Document   : Browse
    Created on : Jul 16, 2014, 1:02:15 PM
    Author     : seannils1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" media="screen" type="text/css" href="/MVCMusicStore/css/Site.css" />
        
        <title>Browser JSP</title>
    </head>
    <body>
        <div id="header" class="">
            <h1>Spring MVC Music Store</h1>
            <ul id="navlist">
                <li class="first"><a href="/MVCMusicStore/" id="current">Home</a></li>
                <li><a href="/MVCMusicStore/spring/Store/">Store</a></li>
            </ul>
        </div>
        <h1>Browse JSP</h1>
        <h2>${genre}</h2>
    </body>
</html>
