
<%@ page import="ups.pastog.SubDomain" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'subDomain.label', default: 'SubDomain')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
	
		<div class="nav" role="navigation">
			<ul>
				<li><a class="Retour" href="${createLink(uri: '/domain')}"><g:message code="Retour"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-subDomain" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
						<th><g:message code="subDomain.domaine.label" default="Domaine" /></th>

					</tr>
				</thead>
				<tbody>
				<g:each in="${subDomainInstanceList}" status="i" var="subDomainInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${subDomainInstance.id}">${fieldValue(bean: subDomainInstance, field: "label")}</g:link></td>
	
						<td>${fieldValue(bean: subDomainInstance, field: "domaine")}</td>

					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${subDomainInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
