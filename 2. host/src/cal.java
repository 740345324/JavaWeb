
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;

@WebServlet(name="list",urlPatterns = {"/list"})
public class cal extends HttpServlet{
    // ��Ӧ�ͻ�������ķ���
    public void service(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException,java.io.IOException{

        RequestDispatcher rd;
        // ��ȡ�������
        request.setCharacterEncoding("utf8");
        String name = request.getParameter("name");
        String room =request.getParameter("room");
        String id = request.getParameter("id_card");
        String sprice=request.getParameter("price");
       /* String sdate =request.getParameter("date");
        System.out.println(sdate);*/
        int price=0;
        if(sprice!=null&&!sprice.equals(""))
        {
            price=Integer.parseInt(sprice);
        }
        try{
            // Servlet������ִ���κε�ҵ���߼�����������JavaBean�����û�����
            DbDao dd = new DbDao("com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost:3306/host","root","111");
            // ��ѯ�����
            ResultSet rs = dd.query("select * from room_inf"
                    + " where room = ?", room);
        if(rs.next()) {
            if (rs.getInt("IsNull") == 0) {
                if (price >= rs.getInt("money")) {
                    dd.modify("UPDATE room_inf SET username = '" + name + "' WHERE room = '" + room + "';");
                    dd.modify("UPDATE room_inf SET id_card = '" + id + "' WHERE room = '" + room + "';");
                    //dd.modify("UPDATE room_inf SET date = '"+sdate+"' WHERE room = '" + room + "';");
                    dd.modify("UPDATE room_inf SET IsNull = 1 WHERE room = '" + room + "';");
                    // ��ȡsession����
                    HttpSession session = request.getSession(true);
                    // ����session���ԣ������û��Ự״̬
                    session.setAttribute("message", "����ɹ���");
                    // ��ȡת������
                    response.sendRedirect("count.jsp");
                } else {
                    // ��ȡsession����
                    HttpSession session = request.getSession(true);
                    // ����session���ԣ������û��Ự״̬
                    session.setAttribute("message", "�۸��㣡");
                    // ��ȡת������
                    response.sendRedirect("count.jsp");
                }
            }else{
                // ��ȡsession����
                HttpSession session = request.getSession(true);
                // ����session���ԣ������û��Ự״̬
                session.setAttribute("message", "�Ѿ�������ס!");
                // ��ȡת������
                response.sendRedirect("count.jsp");
            }
        }
        else
        {
            // ��ȡsession����
            HttpSession session = request.getSession(true);
            // ����session���ԣ������û��Ự״̬
            session.setAttribute("message" , "���䲻����!");
            // ��ȡת������
            response.sendRedirect("count.jsp");
        }
        }catch (Exception e){
          e.printStackTrace();
        }
    }
}
