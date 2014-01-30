<%@ page import="ups.pastog.user.User" %>


<table>
  
  <tr>
    <td><div class="fieldcontain ${hasErrors(bean: userInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="user.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${userInstance?.name}"/>
	</div></td>
	</tr><tr>
    <td><div class="fieldcontain ${hasErrors(bean: userInstance, field: 'secondName', 'error')} required">
	<label for="secondName">
		<g:message code="user.secondName.label" default="Second Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="secondName" required="" value="${userInstance?.secondName}"/>
</div></td>
</tr>
<tr>
<td>
<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="user.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${userInstance?.email}"/>
</div>
  </td>
  </tr>
  <tr>
  <td>
  <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'passWord', 'error')} required">
	<label for="passWord">
		<g:message code="user.passWord.label" default="PassWord" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="password" name="passWord" required="" />
</div>
  </td>
  </tr>
   <tr>
  <td>
  <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'Confirmation passWord', 'error')} required">
	<label for="Confirmation passWord">
		<g:message code="user.passWord.label" default="Confirmation PassWord" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="password" name="passWord" required="" />
</div>
  </td>
  </tr>
</table>









