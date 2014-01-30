<%@ page import="ups.pastog.Domain" %>



<div class="fieldcontain ${hasErrors(bean: domainInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="domain.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${domainInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: domainInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="domain.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${domainInstance?.description}"/>
</div>



