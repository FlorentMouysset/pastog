<%@ page import="ups.pastog.PhysicalEvent" %>



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
<div class="fieldcontain ${hasErrors(bean: physicalEventInstance, field: 'place', 'error')} required">
	<label for="place">
		<g:message code="physicalEvent.place.label" default="Place" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="place" required="" value="${physicalEventInstance?.place}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: physicalEventInstance, field: 'eventBase', 'error')} required">
	<label for="eventBase">
		<g:message code="physicalEvent.eventBase.label" default="Event Base" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="eventBase" name="eventBase.id" from="${ups.pastog.EventBase.list()}" optionKey="id" required="" value="${physicalEventInstance?.eventBase?.id}" class="many-to-one"/>
</div>

