
<%@ page import="ups.pastog.VirtualEvent" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'virtualEvent.label', default: 'VirtualEvent')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/eventBase')}"><g:message code="default.home.label"/></a></li>
				<li><a class="La liste des questions" href="${createLink(uri: '/question/index/')}"><g:message code="La liste des questions"/></a></li>
				<li><a class="Ajouter une question" href="${createLink(uri: '/question/create/')}"><g:message code="Ajouter une question"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-virtualEvent" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="virtualEvent.eventBase.label" default="Event Base" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${virtualEventInstanceList}" status="i" var="virtualEventInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${virtualEventInstance.id}">${fieldValue(bean: virtualEventInstance, field: "eventBase")}</g:link></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${virtualEventInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
