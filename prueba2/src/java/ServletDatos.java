import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ServletDatos"})
public class ServletDatos extends HttpServlet {
    
    public String isbn,titulo,nom_autor,apel_autor, categoria;
    public double precio;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Variable para la conexion a la BDD
            Connection conexion = null;
            Statement sentencia1 = null; //objeto para ejecutar una sentencia
            Statement sentencia2 = null;
            ResultSet resultados = null;//objeto para guardar los resultados
            
            //Varibalbes para la conexion
            String cadenaConexion = "jdbc:mysql://localhost:3306/colegio";
            String usuariobd = "root";
            String passwordbd = "";
            
            //Capturar los Datos de la Vista
            //Tranformar a INT
            isbn = request.getParameter("isbn");
            titulo = request.getParameter("titulo");
            nom_autor= request.getParameter("nom_autor");
            apel_autor=request.getParameter("apel_autor");
            categoria= request.getParameter("categoria");
            precio = Double.parseDouble(request.getParameter("precio"));
            
            
            try {
                //Leemos el driver de MySQL
                //EL .JAR
                Class.forName("com.mysql.jdbc.Driver");
                //Nos conectamos a la BD
                conexion = DriverManager.getConnection(cadenaConexion,usuariobd,passwordbd);
                // Insertar datos en la BDD
                sentencia1 = conexion.createStatement();
                //Visualizar o traer datps de la BDD
                sentencia2 = conexion.createStatement();
                
                sentencia1.execute("INSERT INTO libro (ISBN,titulo,nombre_autor,apellido_autor,precio, categoria)"+"VALUES('"+isbn+"','"+titulo+"','"+nom_autor+"','"+
                        apel_autor+"','"+precio+"','"+categoria+"');");
                //Traer los datos de la tabla de la BDD
                resultados = sentencia2.executeQuery("SELECT * FROM libro");
                //Imprimir los datos en una vista virtual
                out.println("<br>");
                //Imprimimos los valores
                out.println("");
                out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\" integrity=\"sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS\" crossorigin=\"anonymous\">");
                out.println("Libros Totales:");
                out.println("<br>");
                while (resultados.next()) {
                    out.println("ID:  " + resultados.getString("id"));
                    out.println("<br>");
                    out.println("ISBN: " + resultados.getString("isbn"));
                    out.println("<br>");
                    out.println("Título: "+resultados.getString("titulo"));
                    out.println("<br>");
                    out.println("Autor: "+resultados.getString("apellido_autor")+" " +resultados.getString("nombre_autor") );
                    out.println("<br>");
                    out.println("Precio: "+resultados.getString("precio"));
                    out.println("<br>");
                    out.println("Categoria: "+resultados.getString("categoria"));
                    out.println("<br>");
                    out.println("____________________");
                    out.println("<br>");
                }
                out.println("");
                out.println("<form action=\"datos.html\" method=\"GET\"><button type=\"submit\" class=\"btn btn-primary\">REGRESAR</button></form>");
            } catch (ClassNotFoundException e1) {
                
                //Error si no puedo leer el driver MySQL
                out.println("ERROR: No se encuentra el dirver de la BD: "+e1.getMessage());
                
                
            }catch (SQLException e2){
                out.println("ERROR: Fallo en SQL: "+e2.getMessage());
            }finally{
                try {
                    if (conexion != null){
                        conexion.close();
                    }
                } catch (SQLException e3) {
                    out.println("ERROR: Fallo al desconectar de la BD: "+e3.getMessage());
                }
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
