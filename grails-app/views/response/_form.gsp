<%@ page import="ups.pastog.Response" %>



<div class="fieldcontain ${hasErrors(bean: responseInstance, field: 'response', 'error')} required">
	<label for="response">
		<g:message code="response.response.label" default="Response" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="response" required="" value="${responseInstance?.response}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: responseInstance, field: 'question', 'error')} required">
	<label for="question">
		<g:message code="response.question.label" default="Question" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="question" name="question.id" from="${ups.pastog.Question.list()}" optionKey="id" required="" value="${responseInstance?.question?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: responseInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="response.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${ups.pastog.User.list()}" optionKey="id" required="" value="${responseInstance?.user?.id}" class="many-to-one"/>
</div>

