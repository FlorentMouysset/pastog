
<%@ page import="ups.pastog.Domain" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'domain.label', default: 'Domain')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<div class="nav" role="navigation">
			<ul>
                <li><a class="Creer un virtual event" href="${createLink(uri: '/eventBase/create/')}"><g:message code="Creer un virtual event"/></a></li>
                <li><a class="Visualiser la liste des sous domaines" href="${createLink(uri: '/subDomain/show/')}"><g:message code="Visualiser la liste des sous domaines"/></a></li>
				<li><g:link class="create" action="create"><g:message code="Ajout d'un nouveau domaine " args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-domain" class="content scaffold-list" role="main">
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
				<g:each in="${domainInstanceList}" status="i" var="domainInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="show" id="${domainInstance.id}">${fieldValue(bean: domainInstance, field: "title")}</g:link></td>
					</tr>
				</g:each>
			<div class="pagination">
			<g:paginate total="${domainInstanceCount ?: 0}" />
		</div>
		</div>
	</body>
</html>
