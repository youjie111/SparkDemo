package cn.weiche.www;

import com.jcraft.jsch.*;

import java.sql.*;

public class JDBCSSHChannel {
//    public static void main(String[] args) {
//            goSSH(3306,"hostname",3306,"youjie","跳板机",22);
//            connDB();
//        //} catch (Exception e) {
//         //   System.err.println(e);
//      //  }
//    }
    /**
     *
     * @param localPort  本地host 建议mysql 3306
     * @param rhost    host 远程MySQL服务器
     * @param rport    port 3306
     * @param user   ssh 用户名
     * @param host   ssh主机
     * @param port   远程机器端口22
     */
    public static void goSSH(int localPort, String rhost, int rport,
                             String user, String host,
                             int port) {
        try {
            JSch jsch = new JSch();
            jsch.addIdentity("C:\\Users\\Administrator\\.ssh\\id_rsa");
            Session session = jsch.getSession(user, host, port);
            //session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            System.out.println(session.getServerVersion());//这里打印SSH服务器版本信息
            int assinged_port = session.setPortForwardingL(localPort, rhost, rport);
            System.out.println("localhost:" + assinged_port + " -> " + rhost + ":" + rport);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void connDB() {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/martin_order", "用户名", "密码");
            st = conn.createStatement();
            String sql = "SELECT * FROM order_base limit 1";
            rs = st.executeQuery(sql);
            while (rs.next())
                System.out.println(rs.getString(1));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

}
