import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class Test {
	public static void main(String[] args) throws IOException {
	String url = "";
	Connection con = Jsoup.connect(url);
//	Response rs = con.execute();
//	HashMap<String, String> data = new HashMap<String, String>();
//	data.put("form_email", "17839192980");
//	data.put("form_password", "qq71616997290123");
//	data.put("login", "��¼");
//	
//	con.data(data);
//	Response rs2 = con.method(Method.POST).execute();
//	System.out.println(rs2.body());
//	Document doc = Jsoup.connect(url)
//			.header("Accept", "*/*")
//			.header("Accept-Encoding", "gzip, deflate")
//			.header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
//			.header("Referer", "https://www.baidu.com/")
//			.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
//			.timeout(5000)
//			.get();
//		Connection con = Jsoup.connect(url);
//    	con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");//����ģ�������  
//    	Response rs = con.execute();
//    	System.out.println(rs.body());
//    	
//    	con.ignoreContentType(true).method(Method.POST).data("name", "").data("password", "").cookies(rs.cookies()).execute();
	}
}