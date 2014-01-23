



<div class="fieldcontain ${hasErrors(bean: subDomainInstance, field: 'physicalEvent', 'error')} ">
	<label for="physicalEvent">
		<g:message code="subDomain.physicalEvent.label" default="Physical Event" />
		
	</label>
	<g:select name="physicalEvent" from="${PhysicalEvent.list()}" multiple="multiple" optionKey="id" size="5" value="${subDomainInstance?.physicalEvent*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: subDomainInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="subDomain.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${User.list()}" optionKey="id" required="" value="${subDomainInstance?.user?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: subDomainInstance, field: 'virtualEvent', 'error')} ">
	<label for="virtualEvent">
		<g:message code="subDomain.virtualEvent.label" default="Virtual Event" />
		
	</label>
	<g:select name="virtualEvent" from="${VirtualEvent.list()}" multiple="multiple" optionKey="id" size="5" value="${subDomainInstance?.virtualEvent*.id}" class="many-to-many"/>
</div>

