<%@ page import="ups.pastog.PhysicalEvent" %>



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

