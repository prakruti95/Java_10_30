package com.custometag;


import jakarta.*;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class CopyrightTag extends SimpleTagSupport {

    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            out.println("© 2026 My Company. All Rights Reserved.");
        } catch (java.io.IOException e) {
            throw new JspException(e.getMessage(), e);
        }
    }
}