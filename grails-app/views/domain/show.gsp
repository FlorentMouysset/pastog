
<%@ page import="ups.pastog.Domain" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'domain.label', default: 'Domain')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-domain" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                <li><g:link url="[action:'newSubDomain',controller:'Domain']" params="${domainInstance?.title}"><g:message code="New Subdomain" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-domain" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list domain">
			
				<g:if test="${domainInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="domain.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${domainInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${domainInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="domain.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${domainInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${domainInstance?.author}">
				<li class="fieldcontain">
					<span id="author-label" class="property-label"><g:message code="domain.author.label" default="Author" /></span>
					
						<span class="property-value" aria-labelledby="author-label"><g:link controller="user" action="show" id="${domainInstance?.author?.id}">${domainInstance?.author?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${domainInstance?.subDomain}">
				<li class="fieldcontain">
					<span id="subDomain-label" class="property-label"><g:message code="domain.subDomain.label" default="Sub Domain" /></span>
					
						<g:each in="${domainInstance.subDomain}" var="s">
						<span class="property-value" aria-labelledby="subDomain-label"><g:link controller="subDomain" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:domainInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${domainInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
