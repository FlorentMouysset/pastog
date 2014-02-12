<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-question" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/question')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div>
		 <ul class="nav navbar-nav navbar-right"/>
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Account <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="${createLink(controller: 'Question', action: 'update')}">Update</a></li>
                        <li class="divider"></li>
                        <li><a href="${createLink(controller: 'Question', action: 'list', params: [userOnly: 'true'])}">Mes Questions</a>
                        </li>
                    </ul>
                   </li>
          </div>
		<div id="Ajouter une nouvelle question" class="content scaffold-create" role="main">
			<h1><g:message code="Ajouter une nouvelle question" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${questionInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${questionInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:questionInstance, action:'save']" >
				<fieldset>
                        <div class="form-group">
                            <label for="inputDescription">Enoncé</label>
                            <textarea id="inputDescription"
                                      class="form-control"
                                      rows="3"
                                      name="description"
                                      placeholder="Describe the point of your post"
                                      style="resize: none">${questionInstance?.enunciated}</textarea>
                        </div>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
