
<%@ page import="ups.pastog.EventBase" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'eventBase.label', default: 'EventBase')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-eventBase" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-eventBase" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list eventBase">
			
				<g:if test="${eventBaseInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="eventBase.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${eventBaseInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventBaseInstance?.dateOfEnd}">
				<li class="fieldcontain">
					<span id="dateOfEnd-label" class="property-label"><g:message code="eventBase.dateOfEnd.label" default="Date Of End" /></span>
					
						<span class="property-value" aria-labelledby="dateOfEnd-label"><g:formatDate date="${eventBaseInstance?.dateOfEnd}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventBaseInstance?.dateOfStart}">
				<li class="fieldcontain">
					<span id="dateOfStart-label" class="property-label"><g:message code="eventBase.dateOfStart.label" default="Date Of Start" /></span>
					
						<span class="property-value" aria-labelledby="dateOfStart-label"><g:formatDate date="${eventBaseInstance?.dateOfStart}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventBaseInstance?.participants}">
				<li class="fieldcontain">
					<span id="participants-label" class="property-label"><g:message code="eventBase.participants.label" default="Participants" /></span>
					
						<g:each in="${eventBaseInstance.participants}" var="p">
						<span class="property-value" aria-labelledby="participants-label"><g:link controller="user" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${eventBaseInstance?.subdomain}">
				<li class="fieldcontain">
					<span id="subdomain-label" class="property-label"><g:message code="eventBase.subdomain.label" default="Subdomain" /></span>
					
						<span class="property-value" aria-labelledby="subdomain-label"><g:link controller="subDomain" action="show" id="${eventBaseInstance?.subdomain?.id}">${eventBaseInstance?.subdomain?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:eventBaseInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${eventBaseInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
