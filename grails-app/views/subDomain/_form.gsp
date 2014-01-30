<%@ page import="ups.pastog.SubDomain" %>



<div class="fieldcontain ${hasErrors(bean: subDomainInstance, field: 'label', 'error')} ">
	<label for="label">
		<g:message code="subDomain.label.label" default="Label" />
		
	</label>
	<g:textField name="label" value="${subDomainInstance?.label}"/>
</div>





