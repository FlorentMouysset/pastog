<%@ page import="ups.pastog.Domain" %>



<div class="fieldcontain ${hasErrors(bean: domainInstance, field: 'title', 'error')} required">
	<tr>
	<td><label for="titre">
		<h5><g:message code="Titre" default="Titre" /></h5>
		<span class="required-indicator">*</span>
	</label></td>
	<td><g:textField name="titre" required="" value="${domainInstance?.title}"/></td>
	</tr>
</div>

<div class="fieldcontain ${hasErrors(bean: domainInstance, field: 'description', 'error')} required">
	<label for="description">
		<h5><g:message code="domain.description.label" default="Description" /></h5>
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${domainInstance?.description}"/>
</div>



