

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'subDomain.label', default: 'SubDomain')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-subDomain" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-subDomain" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list subDomain">
			
				<g:if test="${subDomainInstance?.physicalEvent}">
				<li class="fieldcontain">
					<span id="physicalEvent-label" class="property-label"><g:message code="subDomain.physicalEvent.label" default="Physical Event" /></span>
					
						<g:each in="${subDomainInstance.physicalEvent}" var="p">
						<span class="property-value" aria-labelledby="physicalEvent-label"><g:link controller="physicalEvent" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${subDomainInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="subDomain.user.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${subDomainInstance?.user?.id}">${subDomainInstance?.user?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${subDomainInstance?.virtualEvent}">
				<li class="fieldcontain">
					<span id="virtualEvent-label" class="property-label"><g:message code="subDomain.virtualEvent.label" default="Virtual Event" /></span>
					
						<g:each in="${subDomainInstance.virtualEvent}" var="v">
						<span class="property-value" aria-labelledby="virtualEvent-label"><g:link controller="virtualEvent" action="show" id="${v.id}">${v?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:subDomainInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${subDomainInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
