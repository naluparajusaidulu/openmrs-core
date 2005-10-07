package org.openmrs.web.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.context.Context;

public class AuthTag extends TagSupport {

	public static final long serialVersionUID = 11233L;
	
	private final Log log = LogFactory.getLog(getClass());

	public int doStartTag() {

		HttpSession httpSession = pageContext.getSession();
		
		Context context = (Context)httpSession.getAttribute("__openmrs_context");
		if (context.isAuthenticated()) {
			return EVAL_BODY_INCLUDE;
		}
		else {
			return SKIP_BODY;
		}
	}
}
