
<%@ page import="ups.pastog.Domain" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'domain.label', default: 'Domain')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-domain" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-domain" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'domain.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'domain.description.label', default: 'Description')}" />
					
						<th><g:message code="domain.author.label" default="Author" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${domainInstanceList}" status="i" var="domainInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${domainInstance.id}">${fieldValue(bean: domainInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: domainInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: domainInstance, field: "author")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${domainInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
