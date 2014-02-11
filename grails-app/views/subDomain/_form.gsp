<%@ page import="ups.pastog.SubDomain" %>



<div class="fieldcontain ${hasErrors(bean: subDomainInstance, field: 'label', 'error')} required">
	<label for="label">
		<g:message code="subDomain.label.label" default="Label" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="label" required="" value="${subDomainInstance?.label}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: subDomainInstance, field: 'domaine', 'error')} required">
	<label for="domaine">
		<g:message code="subDomain.domaine.label" default="Domaine" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="domaine" name="domaine.id" from="${ups.pastog.Domain.list()}" optionKey="id" required="" value="${subDomainInstance?.domaine?.title}" class="many-to-one"/>
</div>





