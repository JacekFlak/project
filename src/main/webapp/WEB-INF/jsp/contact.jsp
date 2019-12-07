<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
        <%@include file="/resources/css/style.css" %>
    </style>
    <title><s:message code="contact.support"/></title>
</head>
<body>
<%@include file="/WEB-INF/incl/menu.app" %>

<h2 align="left"><s:message code="contact.support"/></h2>

<div id="central">
    <div class="content">
        <div id="message" align="center">
            <form id="frmContact" name="frmContact" action="" method="POST"
                  novalidate="novalidate">
                <div class="label">Name:</div>
                <div class="field">
                    <input type="text" id="pp-name" name="name"
                           title="Please enter your name" class="required" aria-required="true" required>
                </div>
                <div class="label">Email:</div>
                <div class="field">
                    <input type="text" id="pp-email" name="email"
                           title="Please enter your email address" class="required email" aria-required="true" required>
                </div>
                <div class="label">Phone Number:</div>
                <div class="field">
                    <input type="text" id="pp-phone" name="phone"
                           title="Please enter your phone number" class="required phone" aria-required="true" required>
                </div>
                <div class="label">Message:</div>
                <div class="field">
						<textarea id="about-project" name="message"></textarea>
                </div>
                <div id="mail-status"></div>
                <input type="submit" name="submit" value="Send Message"
                       id="send-message" style="clear: both;" class="btn-two blue rounded">
            </form>
        </div>
    </div>
    <!-- content -->
</div>
<!-- central -->

</body>
</html>