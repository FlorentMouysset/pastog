<%@ page import="ups.pastog.EventBase" %>



<div class="fieldcontain ${hasErrors(bean: eventBaseInstance, field: 'dateOfEnd', 'error')} required">
	<label for="dateOfEnd">
		<g:message code="eventBase.dateOfEnd.label" default="Date Of End" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateOfEnd" precision="day"  value="${eventBaseInstance?.dateOfEnd}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: eventBaseInstance, field: 'dateOfStart', 'error')} required">
	<label for="dateOfStart">
		<g:message code="eventBase.dateOfStart.label" default="Date Of Start" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateOfStart" precision="day"  value="${eventBaseInstance?.dateOfStart}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: eventBaseInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="eventBase.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${eventBaseInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventBaseInstance, field: 'participants', 'error')} ">
	<label for="participants">
		<g:message code="eventBase.participants.label" default="Participants" />
		
	</label>
	<g:select name="participants" from="${ups.pastog.user.User.list()}" multiple="multiple" optionKey="id" size="5" value="${eventBaseInstance?.participants*.id}" class="many-to-many"/>
</div>

