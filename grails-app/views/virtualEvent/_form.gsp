<%@ page import="ups.pastog.VirtualEvent" %>



<div class="fieldcontain ${hasErrors(bean: virtualEventInstance, field: 'eventBase', 'error')} required">
	<label for="eventBase">
		<g:message code="virtualEvent.eventBase.label" default="Event Base" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="eventBase" name="eventBase.id" from="${ups.pastog.EventBase.list()}" optionKey="id" required="" value="${virtualEventInstance?.eventBase?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: virtualEventInstance, field: 'questions', 'error')} ">
	<label for="questions">
		<g:message code="virtualEvent.questions.label" default="Questions" />
		
	</label>
	<g:select name="questions" from="${ups.pastog.Question.list()}" multiple="multiple" optionKey="id" size="5" value="${virtualEventInstance?.questions*.id}" class="many-to-many"/>
</div>

