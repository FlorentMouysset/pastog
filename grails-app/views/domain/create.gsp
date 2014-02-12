<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'domain.label', default: 'Domain')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
</head>
<body>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/domain')}"><h1><g:message code="Retour"/></h1></a></li>
    </ul>
</div>
<div id="Créer un nouveau domaine" class="content scaffold-create" role="main">
    <h1><g:message code="Créer un nouveau domaine" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${domainInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${domainInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form action="save" method="post" >
        <fieldset class="form">
            <g:render template="form"/>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="create" class="save" value="${message(code: 'Créer', default: 'Créer')}" />
        </fieldset>
    </g:form>
</div>
</body>
</html>
