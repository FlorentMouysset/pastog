
<%@ page import="ups.pastog.EventBase" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'eventBase.label', default: 'EventBase')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-eventBase" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-eventBase" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="description" title="${message(code: 'eventBase.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="dateOfEnd" title="${message(code: 'eventBase.dateOfEnd.label', default: 'Date Of End')}" />
					
						<g:sortableColumn property="dateOfStart" title="${message(code: 'eventBase.dateOfStart.label', default: 'Date Of Start')}" />
					
						<th><g:message code="eventBase.subdomain.label" default="Subdomain" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${eventBaseInstanceList}" status="i" var="eventBaseInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${eventBaseInstance.id}">${fieldValue(bean: eventBaseInstance, field: "description")}</g:link></td>
					
						<td><g:formatDate date="${eventBaseInstance.dateOfEnd}" /></td>
					
						<td><g:formatDate date="${eventBaseInstance.dateOfStart}" /></td>
					
						<td>${fieldValue(bean: eventBaseInstance, field: "subdomain")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${eventBaseInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
