<%@ page import="ups.pastog.PhysicalEvent" %>



<div class="fieldcontain ${hasErrors(bean: physicalEventInstance, field: 'dateOfEnd', 'error')} required">
    <label for="dateOfEnd">
        <g:message code="eventBase.dateOfEnd.label" default="Date Of End" />
        <span class="required-indicator">*</span>
    </label>
    <g:datePicker name="dateOfEnd" precision="day"  value="${new Date()}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: physicalEventInstance, field: 'dateOfStart', 'error')} required">
    <label for="dateOfStart">
        <g:message code="eventBase.dateOfStart.label" default="Date Of Start" />
        <span class="required-indicator">*</span>
    </label>
    <g:datePicker name="dateOfStart" precision="day"  value="${new Date()}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: physicalEventInstance, field: 'place', 'error')} required">
	<label for="place">
		<g:message code="physicalEvent.place.label" default="Place" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="place" required="" value="${physicalEventInstance?.place}"/>
</div>



