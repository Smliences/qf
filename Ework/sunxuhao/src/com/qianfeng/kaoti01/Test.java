package com.qianfeng.kaoti01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Company company1 = new Company();
		Company company2 = new Company();
		Company company3 = new Company();
		Company company4 = new Company();
		Company company5 = new Company();

		company1.setCompanyId(1004);
		company1.setCompanyName("阿里巴巴");
		company1.setCompanyAddress("北京市");
		company1.setCompanyInfo("北京小米科技有限责任公司成立2010年4月，"
				+ "是一家专注于智能硬件和电子产品研发的移动互联网公司。“为发烧而生”是小米的产品概念。"
				+ "小米公司创造了用互联网模式开发手机操作系统、发烧友参与开发改进的模式。"
				+ "[1]  小米还是既苹果、三星、华为之后第四家拥有手机芯片自研能力的科技公司。");
		company2.setCompanyId(1003);
		company2.setCompanyName("百度");
		company2.setCompanyAddress("北京市");
		company2.setCompanyInfo("百度（纳斯达克：BIDU），全球最大的中文搜索引擎、最大的中文网站。"
				+ "1999年底,身在美国硅谷的李彦宏看到了中国互联网及中文搜索引擎服务的巨大发展潜力"
				+ "，抱着技术改变世界的梦想，他毅然辞掉硅谷的高薪工作，携搜索引擎专利技术，"
				+ "于 2000年1月1日在中关村创建了百度公司。");
		company3.setCompanyId(1002);
		company3.setCompanyName("京东");
		company3.setCompanyAddress("北京市");
		company3.setCompanyInfo("京东JD.COM-1998年成立专业的综合网上购物商城，"
				+ "销售超数万品牌、4020万种商品，囊括家电、手机、电脑、母婴、服装等13大品类。"
				+ "秉承客户为先的理念，京东所售商品为正品行货、全国联保、机打发票。");
		company4.setCompanyId(1005);
		company4.setCompanyName("小米");
		company4.setCompanyAddress("北京市");
		company4.setCompanyInfo("北京小米科技有限责任公司成立2010年4月，是一家专注于智能硬件和电子产品研发的移动互联网公司。"
				+ "“为发烧而生”是小米的产品概念。小米公司创造了用互联网模式开发手机操作系统、发烧友参与开发改进的模式。"
				+ "[1]  小米还是既苹果、三星、华为之后第四家拥有手机芯片自研能力的科技公司。");
		company5.setCompanyId(1001);
		company5.setCompanyName("腾讯");
		company5.setCompanyAddress("深圳");
		company5.setCompanyInfo("深圳市腾讯计算机系统有限公司成立于1998年11月，由马化腾、张志东、许晨晔、陈一丹、曾李青五位创始人共同创立 。"
				+ " 是中国最大的互联网综合服务提供商之一，也是中国服务用户最多的互联网企业之一。");

		HashMap<Company, String> hashMap = new HashMap<Company,String>();
		hashMap.put(company1, company1.getCompanyInfo());
		hashMap.put(company2, company2.getCompanyInfo());
		hashMap.put(company3, company3.getCompanyInfo());
		hashMap.put(company4, company4.getCompanyInfo());
		hashMap.put(company5, company5.getCompanyInfo());

		Set<Entry<Company, String>> entrySet = hashMap.entrySet();
		Iterator<Entry<Company, String>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		Set<Company> keySet = hashMap.keySet();
		Iterator<Company> iterator2 = keySet.iterator();
		while (iterator2.hasNext()) {
			Company key = iterator2.next();
			System.out.println(key + ":" + hashMap.get(key));
		}
		
		bubbleSortUsingComparator(hashMap, new MyComparator());
		selectSortUsingCompare(hashMap, new MyComparator());
	}

	public static void show(HashMap<Company, String> hashMap, ArrayList<Company> keyList){
		for (Company company : keyList) {
			System.out.println(company + ":" + hashMap.get(company));
		}
	}

	public static void mapToList(HashMap<Company, String> hashMap, ArrayList<Company> keyList) {
		Set<Company> keySet = hashMap.keySet();
		Iterator<Company> it1 = keySet.iterator();
		while (it1.hasNext()) {
			keyList.add(it1.next());
		}
	}

	public static void bubbleSortUsingComparator(HashMap<Company, String> hashMap, Comparator comp) {
		//参数合法性判断
		if (null == hashMap || null == comp || hashMap.size() == 0) {
			throw new NullPointerException("参数不合法");
		}
		//先把map的key放进一个list里面
		ArrayList<Company> keyList = new ArrayList<Company>();
		mapToList(hashMap, keyList);

		for (int i = 0; i < keyList.size() - 1; i++) {
			for (int j = 0; j < keyList.size() - 1 - i; j++) {

				if (comp.compare(keyList.get(j), keyList.get(j + 1)) > 0) {
					Company temp = keyList.get(j);
					keyList.set(j, keyList.get(j + 1));
					keyList.set(j + 1, temp);
				}	
			}
		}
		show(hashMap,keyList);
	}
	public static void selectSortUsingCompare(HashMap<Company, String> hashMap, Comparator comp) {
		//参数合法性判断
		if (null == hashMap || null == comp || hashMap.size() == 0) {
			throw new NullPointerException("参数不合法");
		}
		//先把map的key放进一个list里面
		ArrayList<Company> keyList = new ArrayList<Company>();
		mapToList(hashMap, keyList);
		
		for (int i = 0; i < keyList.size() - 1; i++) {
			int index = i;

			for (int j = i + 1; j < keyList.size(); j++) {
				if (comp.compare(keyList.get(index), keyList.get(j)) > 0) {
					index = j;
				}
			}

			if (index != i) {
				Company temp = keyList.get(index);
				keyList.get(index);
				keyList.set(index, keyList.get(i));
				keyList.set(i, temp);
			}
		}
		show(hashMap,keyList);
	}
}
//自定义比较器
class MyComparator implements Comparator<Company> {
	@Override
	public int compare(Company o1, Company o2) {
		return o1.getCompanyId() - o2.getCompanyId();
	}
}

class Company {
	private int companyId;
	private String companyName;
	private String companyAddress;
	private String companyInfo;
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyInfo() {
		return companyInfo;
	}
	public void setCompanyInfo(String companyInfo) {
		this.companyInfo = companyInfo;
	}
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", companyAddress=" + companyAddress
				+ ", companyInfo=" + companyInfo + "]";
	}

	@Override
	public int hashCode() {
		return this.getCompanyId();
	}
	@Override
	public boolean equals(Object obj) {
		Company c = (Company) obj;
		if (c.getCompanyId() == this.getCompanyId())
			return true;
		return false;
	}
}
