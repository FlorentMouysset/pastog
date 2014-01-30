<!DOCTYPE html>
<html lang="en">
<head>
  <meta name="layout" content="main"/>
  <r:require modules="tsaap_ui_notes,tsaap_icons"/>
</head>

<body>

<div class="container context-nav">

  <ol class="breadcrumb">
    <li class="active">My account informations</li>
  </ol>

  <div class="body-content">
    <g:if test="${flash.message}">
      <div class="alert alert-info" role="status">${flash.message}</div>
    </g:if>
    <g:if test="${user?.hasErrors()}">
      <div class="alert">
        <g:eachError bean="${user}">
          <li><g:message error="${it}"/></li>
        </g:eachError>
      </div>
    </g:if>
  <!-- Example row of columns -->
    <div class="row">

      <div class="col-lg-6">
        <g:form controller="userAccount" action="doUpdate">
          <fieldset>

            <div class="form-group">
              <div class="row">
                <div class="col-lg-5">
                  <input type="text" class="form-control" id="firstName"
                         name="firstName"
                         value="${fieldValue(bean: user, field: 'firstName')}"
                         placeholder="First name">
                </div>

                <div class="col-lg-5">
                  <input type="text" class="form-control" id="lastName"
                         name="lastName"
                         value="${fieldValue(bean: user, field: 'lastName')}"
                         placeholder="Last name">
                </div>
              </div>
            </div>

            <div class="form-group">
              <input type="text" class="form-control" id="email" name="email"
                     placeholder="Your email"
                     value="${fieldValue(bean: user, field: 'email')}">
            </div>

            <div class="form-group">
              <label class="radio-inline">
                <g:radio name="role" value="STUDENT_ROLE" id="STUDENT_ROLE"
                         checked="${user.isLearner()}"/>
                Learner
              </label>
              <label class="radio-inline">
                <g:radio name="role" value="TEACHER_ROLE" id="TEACHER_ROLE"
                         checked="${user.isTeacher()}"/> Teacher
              </label>

            </div>

            <div class="form-group">
              <input type="text" class="form-control"
                     id="username" placeholder="Choose your username"
                     name="username"
                     value="${fieldValue(bean: user, field: 'name')}">
            </div>


            <div class="form-group">
              <input type="password" class="form-control"
                     id="password" placeholder="Password" name="password">
            </div>

            <div class="form-group">
              <input type="password" class="form-control"
                     id="password2" placeholder="Confirm password"
                     name="password2">
            </div>


            <button type="submit"
                    class="btn btn-primary">Save &raquo;</button><br/>

          </fieldset>
        </g:form>

      </div>

    </div>

  </div>

</div> <!-- /container -->
<div class="container">
  <hr>
  <g:link action="doUnsubscribe" controller="userAccount"
          class="btn btn-danger">logout from pastog</g:link>
  <hr>

  <footer>
    <p>&copy; Pastoghether</p>
  </footer>
</div>

</body>
</html>