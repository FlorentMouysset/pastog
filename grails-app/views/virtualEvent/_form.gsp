<%@ page import="ups.pastog.VirtualEvent" %>



<div class="fieldcontain ${hasErrors(field: 'titre', 'error')} required">
        <span class="required-indicator">*</span>
    </label>
    Titre: <g:textField name = "titre"/>
</div>
<div class="fieldcontain ${hasErrors(field: 'description', 'error')} required">
    <label for="description">
        <span class="required-indicator">*</span>
    </label>
    Description: <g:textField name = "description"/>
</div>
<div class="fieldcontain4">
    <label for="dateOfStart">
        <span class="required-indicator">*</span>
    </label>
    Date of start: <g:datePicker name="dateOfStart" precision="minute"  value="${new Date()}"/>
</div>
<div class="fieldcontain3">
    <label for="dateOfEnd">
        <span class="required-indicator">*</span>
    </label>
    Date of end: <g:datePicker name="dateOfEnd" precision="minute"  value="${new Date()}"/>
</div>

