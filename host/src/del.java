import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
@WebServlet(name="q"
        , urlPatterns={"/q"})

public class del extends HttpServlet{
    public void service(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException,java.io.IOException{

        String room =request.getParameter("room");
        try
        {
            // Servlet������ִ���κε�ҵ���߼�����������JavaBean�����û�����
            DbDao dd = new DbDao("com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost:3306/host","root","111");
            // ��ѯ�����
            ResultSet rs = dd.query("select * from room_inf"
                    + " where room = ?", room);
            if(rs.next())
            {
                dd.modify("UPDATE room_inf SET IsNull = 0 WHERE room = '" + room + "';");
                dd.modify("UPDATE room_inf SET username = '' WHERE room = '" + room + "';");
                dd.modify("UPDATE room_inf SET id_card = '' WHERE room = '" + room + "';");
            }

            response.sendRedirect("/quit.jsp");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
