/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author viter
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg = "";
        String comp = "";
        String tarde = "", noite = "", dia = ""; 
        String lang = request.getParameter("lang");
        String Cord = request.getParameter("Cord");
        String tratamento = "";
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                msg = "Alô, ";
                dia = " Bom dia ";
                tarde = " Boa tarde";
                noite = " Boa noite";
                comp = " A data e Hora atual é: ";
                if("sr".equals(Cord)){
                    tratamento = "Senhor ";
                }else if ("sra".equals(Cord)){
                    tratamento = "Senhora ";
                }else{
                    tratamento = "";
                }
                break;
            case "en":
                msg = "Hello, ";
                dia = " Good Morning ";
                tarde = " Good afternoon ";
                noite = " good night ";                
                comp = " The current date and time is: ";
                if("sr".equals(Cord)){
                    tratamento = "Mr ";
                }else if ("sra".equals(Cord)){
                    tratamento = "Madan ";
                }else{
                    tratamento = "";
                }
                break;
            case "fr":
                msg = "Bonjour, ";
                dia = " Bonjour ";
                tarde = " Bon après-midi ";
                noite = " bonne nuit ";                
                comp = " La date et l'heure actuelles sont: ";
                if("sr".equals(Cord)){
                    tratamento = "Monsieur ";
                }else if ("sra".equals(Cord)){
                    tratamento = "Madame ";
                }else{
                    tratamento = "";
                }
                break;
            case "la":
                msg = "Salve, ";
                dia = " Bom dia ";
                tarde = " Boa tarde";
                noite = " Boa noite";                
                comp = " In current date and time is: ";
                if("sr".equals(Cord)){
                    tratamento = "Dominus ";
                }else if ("sra".equals(Cord)){
                    tratamento = "Madam ";
                }else{
                    tratamento = "";
                }
                break;
            case "it":        
                msg = "ciao, ";
                dia = " Buon giorno ";
                tarde = " Buon pomeriggio ";
                noite = " Buona Notte ";                
                comp = " La data e l'ora correnti sono: ";
                if("sr".equals(Cord)){
                    tratamento = "Sig ";
                }else if ("sra".equals(Cord)){
                    tratamento = "signora ";
                }else{
                    tratamento = "";
                }
                break;            
            case "de":
                msg = "Hallo, ";
                dia = " Guten Morgen ";
                tarde = " Guten Tag ";
                noite = " Gute Nacht ";                
                comp = " Das aktuelle Datum und die aktuelle Uhrzeit sind: ";
                if("sr".equals(Cord)){
                    tratamento = "Herr ";
                }else if ("sra".equals(Cord)){
                    tratamento = "gnädige Frau ";
                }else{
                    tratamento = "";
                }
                break;
        }
            Calendar cal = Calendar.getInstance();
            String periodo = "";
                int hora = cal.get(Calendar.HOUR_OF_DAY);


            if(hora < 12 ) {
                periodo = dia;
            }else if(hora >= 12 && hora < 19) {
                periodo = tarde;
            }else {
                periodo = noite;
            }    
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
     
        msg = msg+tratamento+nome+periodo+"!"+"<br><br>"+comp+"<br>"+timeStamp;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Trabalho 1</title>");            
            out.println("</head>");
            out.println("<body style=\"font-family:sans-serif;background-color:powderblue;\">");
            out.println("<h1>Trabalho 1 </h1>");
            out.println("<p style=\"font-family:sans-serif;\">" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
