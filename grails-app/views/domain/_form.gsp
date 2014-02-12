<%@ page import="ups.pastog.Domain" %>



<div class="fieldcontain ${hasErrors(bean: domainInstance, field: 'title', 'error')} ">
    <label for="title">
        <g:message code="domain.title.label" default="Title" />

    </label>
    <g:textField name="title" value="${domainInstance?.title}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: domainInstance, field: 'description', 'error')} ">
    <label for="description">
        <g:message code="domain.description.label" default="Description" />

    </label>
    <g:textField name="description" value="${domainInstance?.description}"/>
</div>



