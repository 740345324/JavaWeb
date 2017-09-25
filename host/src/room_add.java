import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;

@WebServlet(name="add_room"
        , urlPatterns={"/add_room"})

public class room_add extends HttpServlet{
    public void service(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException,java.io.IOException{
        String errMsg = "";
        RequestDispatcher rd;
        // ��ȡ�������
        String room = request.getParameter("room");
        String snum = request.getParameter("num");
        String smoney = request.getParameter("money");
        int num=0,money=0;
        if(snum!=null&&!snum.equals(""))
        {
            num=Integer.parseInt(snum);
        }
        if(smoney!=null&&!smoney.equals(""))
        {
            money=Integer.parseInt(smoney);
        }
        try
        {
            DbDao dd = new DbDao("com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost:3306/host","root","111");
            ResultSet rs = dd.query("select * from room_inf"
                    + " where room = ?", room);
            if(rs.next())
            {
                errMsg += "�÷����Ѿ����ڣ���ȷ��";
            }
            else if(room.equals("")||room==null)
            {
                errMsg +="����Ų�Ϊ��";
            }
            else
            {
                dd.insert("INSERT INTO room_inf(room,number,money,IsNull) values('" + room + "'," + num + ","+money+","+0+");");
                errMsg +="��ӳɹ���";
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        //�������������ӣ�
        if (errMsg != null && !errMsg.equals(""))
        {
            rd = request.getRequestDispatcher("/add.jsp");
            request.setAttribute("err" , errMsg);
            rd.forward(request,response);
        }
    }
}
