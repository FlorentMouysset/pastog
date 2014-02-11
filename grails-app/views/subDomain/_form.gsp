<%@ page import="ups.pastog.SubDomain" %>



<div class="fieldcontain ${hasErrors(bean: subDomainInstance, field: 'label', 'error')} required">
	<label for="label">
		<g:message code="subDomain.label.label" default="Label" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="label" required="" value="${subDomainInstance?.label}"/>
</div>



