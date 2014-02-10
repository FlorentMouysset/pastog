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
	<g:select id="domaine" name="domaine.id" from="${ups.pastog.Domain.list()}" optionKey="id" required="" value="${subDomainInstance?.domaine?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: subDomainInstance, field: 'physicalEvent', 'error')} ">
	<label for="physicalEvent">
		<g:message code="subDomain.physicalEvent.label" default="Physical Event" />
		
	</label>
	<g:select name="physicalEvent" from="${ups.pastog.PhysicalEvent.list()}" multiple="multiple" optionKey="id" size="5" value="${subDomainInstance?.physicalEvent*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: subDomainInstance, field: 'virtualEvent', 'error')} ">
	<label for="virtualEvent">
		<g:message code="subDomain.virtualEvent.label" default="Virtual Event" />
		
	</label>
	<g:select name="virtualEvent" from="${ups.pastog.VirtualEvent.list()}" multiple="multiple" optionKey="id" size="5" value="${subDomainInstance?.virtualEvent*.id}" class="many-to-many"/>
</div>

