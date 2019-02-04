import java.io.IOException;

public class MainServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String token=request.getParameter("token");
        String username=request.getParameter("username");
        System.out.println("User="+username+"\n"
                +"token="+token);

        response.getWriter().write("connected to server \n" +
                "Hello "+username);
    }
}
