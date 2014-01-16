<%@ page import="ups.pastog.Domain" %>



<div class="fieldcontain ${hasErrors(bean: domainInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="domain.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${domainInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: domainInstance, field: 'autor', 'error')} required">
	<label for="autor">
		<g:message code="domain.autor.label" default="Autor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="autor" name="autor.id" from="${ups.pastog.User.list()}" optionKey="id" required="" value="${domainInstance?.autor?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: domainInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="domain.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${domainInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: domainInstance, field: 'subDomain', 'error')} ">
	<label for="subDomain">
		<g:message code="domain.subDomain.label" default="Sub Domain" />
		
	</label>
	<g:select name="subDomain" from="${ups.pastog.SubDomain.list()}" multiple="multiple" optionKey="id" size="5" value="${domainInstance?.subDomain*.id}" class="many-to-many"/>
</div>

