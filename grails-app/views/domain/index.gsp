
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
			<ul><li><a class="La liste des domaines" href="${createLink(uri: '/domain')}"><g:message code="La liste des domaines"/></a></li>
			   <li><a class="Ajout d'un domaine" href="${createLink(uri: '/domain/create/')}"><g:message code="Ajout d'un domaine"/></a></li>
			</ul>
			  <ul class="nav navbar-nav navbar-right">
                   <li><a href="${createLink(controller: 'Domain', action: 'index', params: [userOnly: 'true'])}">La liste des domaines</a>
                 </li>
              
            </ul>
           
		</div>
		<%--<g:if test="${domain.subDomain}">
                <p>subDomain: ${domain.subDomain.size()}</p>
        </g:if>
		
		--%><div id="list-domain" class="content scaffold-list" role="main">
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
