/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.30
 * Generated at: 2014-02-19 00:49:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/jsp/../html/menuComun.html", Long.valueOf(1392601474000L));
    _jspx_dependants.put("/jsp/header.jsp", Long.valueOf(1392770975000L));
    _jspx_dependants.put("/jsp/../html/menuUsComun.html", Long.valueOf(1392523304000L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>KiskoMandado</title>\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/normalize.css\">\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/header.css\">\n");
      out.write("\t<script src=\"js/modernizr-2.6.2.min.js\"></script>\n");
      out.write("\t<script src=\"js/jquery-1.10.1.min.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/main.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<header>\n");
      out.write("\t\t");
      out.write("\n");
      out.write("<div id=\"login\">\n");
      out.write("\tIngresar\n");
      out.write("</div>\n");
      out.write("<div id=\"registrarse\">\n");
      out.write("\tRegistrarse\n");
      out.write("</div>\n");
      out.write("<div id=\"ingreso\">\n");
      out.write("\t<form action=\"\" method=\"get\">\n");
      out.write("\t\t<label id=\"labelIngreUsu\">Usuario:</label>\n");
      out.write("\t\t<input id=\"inputTextIngre\" class=\"inputTextIngre\" type=\"text\" placeholder=\"ejemplo@ejemplo.com\" name=\"usuario\">\n");
      out.write("\t\t<label id=\"labelIngreCon\">Contraseña:</label>\n");
      out.write("\t\t<div id=\"contrasenaIngre\">\n");
      out.write("\t\t\t<input class=\"inputTextIngre\" type=\"password\" name=\"contrasena\">\n");
      out.write("\t\t\t<div>\n");
      out.write("\t\t\t\t<a href=\"#\">Olvidaste tu contraseña??</a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<input id=\"buttonIngre\" type=\"submit\" value=\"Entrar\">\n");
      out.write("\t</form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<hgroup>\n");
      out.write("\t<h1>Kiosko Mandado</h1>\n");
      out.write("\t<h2>facilitando tu vida...</h2>\n");
      out.write("</hgroup>\n");

	String mensaje = (String)request.getAttribute("registro");
	if(mensaje=="registrado"){

      out.write('\n');
      out.write('	');
      out.write('\n');

	}else{

      out.write('\n');
      out.write('	');
      out.write("<nav>\n");
      out.write("\t<ul>\n");
      out.write("\t\t<li class=\"active\"><a href=\"#\">Inicio</a></li>\n");
      out.write("\t\t<li><a href=\"#\">Kioskos</a></li>\n");
      out.write("\t\t<li><a href=\"#\">Contactos</a></li>\n");
      out.write("\t\t<li><a href=\"#\">Ayuda</a></li>\n");
      out.write("\t</ul>\n");
      out.write("\t<div>\n");
      out.write("\t\t<form action=\"\" method=\"get\">\n");
      out.write("\t\t\t<div>\n");
      out.write("\t\t\t\t<figure>\n");
      out.write("\t\t\t\t\t<img src = \"img/lupa.png\" />\n");
      out.write("\t\t\t\t</figure>\n");
      out.write("\t\t\t\t<input id=\"buscador\" type=\"text\" placeholder=\"Buscar..\" name=\"textoBuscar\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<input class=\"radioBusc\" type=\"radio\" name=\"tipoBusqueda\" value=\"kiosko\">\n");
      out.write("\t\t\t<label>Kiosko</label>\n");
      out.write("\t\t\t<input class=\"radioBusc\" type=\"radio\" name=\"tipoBusqueda\" value=\"producto\">\n");
      out.write("\t\t\t<label>Producto</label>\n");
      out.write("\t\t</form>\n");
      out.write("\t</div>\n");
      out.write("</nav>");
      out.write('\n');

	}

      out.write("\n");
      out.write("\t</header>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
