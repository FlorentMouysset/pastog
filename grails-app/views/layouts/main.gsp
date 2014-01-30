<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title><g:layoutTitle default="Grails" /></title>
  <link rel="stylesheet" href="${resource(dir:'css',file:'pop.css')}" />
  <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
  <g:layoutHead />
</head>
<body>
  <div id="wrapper">
 
    <!-- header picture -->
    <div id="header">
      <img src="${resource(dir:'images',file:'header.jpg')}" alt="header" />
    </div> <!-- END #header -->
 
    <!-- username | logout link -->
    <g:if test="${session?.user}">
      <div id="login">
        ${session?.user?.name} ${session?.user?.secondName} |
        <g:link controller="user" action="logout">Logout</g:link>
      </div> <!-- END #login -->
    </g:if>
 
    <h1>PASTOG</h1>
 
    <div id="nav">
    </div> <!-- END #nav -->
 
    <div id="content">
      <g:layoutBody />
    </div> <!-- END #content -->
 
   
 
  </div> <!-- END #wrapper -->
</body>
</html>