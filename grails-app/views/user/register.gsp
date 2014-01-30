<html>
<head>
  <title>POP - User Registration</title>
  <meta name="layout" content="main" />
</head>
<body>
 
<g:form class="simpleform" url="[controller:'user',action:'register']">
  <fieldset>
    <legend>User Registration</legend>
    <p class="info">
      Complete the form below to create an account!
    </p>
    <g:hasErrors bean="${user}">
      <div class="errors">
        <g:renderErrors bean="${user}"/>
      </div>
    </g:hasErrors>
     
    <label for="name">Name</label>
    <div class="rightcol">
      <g:textField name="name" value="${user?.name}"
        class="${hasErrors(bean:user,field:'name','errors')}"/>
    </div>
    <label for="secondName">Surname</label>
    <div class="rightcol">
      <g:textField name="secondName" value="${user?.secondName}"
        class="${hasErrors(bean:user,field:'secondName','errors')}"/>
    </div>
 
    <label for="password">Password</label>
    <div class="rightcol">
      <g:passwordField name="password"
        class="${hasErrors(bean:user,field:'password','errors')}" />
    </div>
 
    <label for="confirmPassword">Confirm Password</label>
    <div class="rightcol">
      <g:passwordField name="confirmPassword"
        class="${hasErrors(bean:user,field:'confirmPassword','errors')}" />
    </div>
 
  <label for="email">Email</label>
    <div class="rightcol">
      <g:textField name="email" value="${user?.email}"
        class="${hasErrors(bean:user,field:'email','errors')}" />
    </div>
   
      <label>&nbsp;</label>
    <div class="rightcol">
      <g:submitButton class="button" name="submitButton" value="Create Account" />
    </div>
  </fieldset>
</g:form>
</body>
</html>