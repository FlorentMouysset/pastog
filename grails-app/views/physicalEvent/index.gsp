
<%@ page import="ups.pastog.PhysicalEvent" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'physicalEvent.label', default: 'PhysicalEvent')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-physicalEvent" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-physicalEvent" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="place" title="${message(code: 'physicalEvent.place.label', default: 'Place')}" />
					
						<th><g:message code="physicalEvent.eventBase.label" default="Event Base" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${physicalEventInstanceList}" status="i" var="physicalEventInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${physicalEventInstance.id}">${fieldValue(bean: physicalEventInstance, field: "place")}</g:link></td>
					
						<td>${fieldValue(bean: physicalEventInstance, field: "eventBase")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${physicalEventInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
