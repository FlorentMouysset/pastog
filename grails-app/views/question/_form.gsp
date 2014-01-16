<%@ page import="ups.pastog.Question" %>



<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'enunciated', 'error')} ">
	<label for="enunciated">
		<g:message code="question.enunciated.label" default="Enunciated" />
		
	</label>
	<g:textField name="enunciated" value="${questionInstance?.enunciated}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'reponse', 'error')} ">
	<label for="reponse">
		<g:message code="question.reponse.label" default="Reponse" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${questionInstance?.reponse?}" var="r">
    <li><g:link controller="response" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="response" action="create" params="['question.id': questionInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'response.label', default: 'Response')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="question.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${ups.pastog.User.list()}" optionKey="id" required="" value="${questionInstance?.user?.id}" class="many-to-one"/>
</div>

