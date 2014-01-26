<%@ page import="ups.pastog.Domain" %>



<div class="fieldcontain ${hasErrors(bean: domainInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="domain.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${domainInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: domainInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="domain.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${domainInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: domainInstance, field: 'author', 'error')} required">
	<label for="author">
		<g:message code="domain.author.label" default="Author" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="author" name="author.id" from="${ups.pastog.User.list()}" optionKey="id" required="" value="${domainInstance?.author?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: domainInstance, field: 'subDomain', 'error')} ">
	<label for="subDomain">
		<g:message code="domain.subDomain.label" default="Sub Domain" />
		
	</label>
	<g:select name="subDomain" from="${ups.pastog.SubDomain.list()}" multiple="multiple" optionKey="id" size="5" value="${domainInstance?.subDomain*.id}" class="many-to-many"/>
</div>

