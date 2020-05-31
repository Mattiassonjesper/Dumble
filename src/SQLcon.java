import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLcon {

	public String connecting(String text) {
		String search = "";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/mydatabase?serverTimezone=UTC","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM mydatabase.masterscplist Where Title like '%"+ text+"%'");
			
			search += "<table id=\"customers\">\n" + 
					"  <tr>\n" + 
					"    <th>Title</th>\n" + 
					"    <th>rating</th>\n" + 
					"    <th>Type</th>\n" + 
					"  </tr>";
			
			while(rs.next())
			{
				search +="<tr><td>";
				search +=rs.getString("Title");
				search +="</td>";
				search +="<td>";
				search +=rs.getString("rating");
				search +="</td>";
				search +="<td>";
				search +=rs.getString("Type");
				search +="</td>";
				search +="</tr>";
			}
			
			
		}catch(Exception p) {
			System.out.println("Fan 1");
		}
			
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/mydatabase?serverTimezone=UTC","root","");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM mydatabase.ikea_names Where name like '%"+text+"%'\n" + 
					"union\n" + 
					"SELECT * FROM mydatabase.ikea_names Where description like '%"+ text+ "%';");
			
			
			while(rs.next())
			{
				search +="<tr><td>";
				search +=rs.getString("name");
				search +="</td>";
				search +="<td>";
				search +=rs.getString("description");
				search +="</td>";
				
				search +="<td>";
				search +=rs.getString("Column_3");
				search +="</td>";
				search +="</tr>";
			
			}
				
			
		}catch(Exception p) {
			System.out.println("Fan 2");
		}
		
		
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/mydatabase?serverTimezone=UTC","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM mydatabase.bearbase Where 'Character' like '%"+text+"%'\n" + 
					"union\n" + 
					"SELECT * FROM mydatabase.bearbase Where Origin like '%"+text+"%'\n" + 
					"union\n" + 
					"SELECT * FROM mydatabase.bearbase Where Notes like '%"+text+"%';");
			
			
			while(rs.next())
			{
				search +="<tr><td>";
				search +=rs.getString("Character");
				search +="</td>";
				search +="<td>";
				search +=rs.getString("Origin");
				search +="</td>";
				
				search +="<td>";
				search +=rs.getString("Creator");
				search +="</td>";
				search +="</tr>";
			
			}
				
			search +="</table>"; 
			
			
			
		}catch(Exception p) {
			System.out.println("Fan 3");
		}

		return search;
	}

}