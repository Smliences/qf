package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class Get {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		do_get("http://www.baidu.com");
	}
	public static void do_get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
		System.out.println(response1.getStatusLine());
		HttpEntity entity1 = response1.getEntity();
		
//		InputStream content = entity1.getContent();
//		char[] cbuf = new char[1024];
//		int length = -1;
//		InputStreamReader isr = new InputStreamReader(content,"utf-8");
//		
//		while ((length = isr.read(cbuf)) != -1) {
//			System.out.println(cbuf);
//		}
	}
}