
<%@ page import="ups.pastog.PhysicalEvent" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'physicalEvent.label', default: 'PhysicalEvent')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-physicalEvent" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-physicalEvent" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list physicalEvent">
			
				<g:if test="${physicalEventInstance?.place}">
				<li class="fieldcontain">
					<span id="place-label" class="property-label"><g:message code="physicalEvent.place.label" default="Place" /></span>
					
						<span class="property-value" aria-labelledby="place-label"><g:fieldValue bean="${physicalEventInstance}" field="place"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${physicalEventInstance?.eventBase}">
				<li class="fieldcontain">
					<span id="eventBase-label" class="property-label"><g:message code="physicalEvent.eventBase.label" default="Event Base" /></span>
					
						<span class="property-value" aria-labelledby="eventBase-label"><g:link controller="eventBase" action="show" id="${physicalEventInstance?.eventBase?.id}">${physicalEventInstance?.eventBase?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:physicalEventInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${physicalEventInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
