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
		company1.setCompanyName("����Ͱ�");
		company1.setCompanyAddress("������");
		company1.setCompanyInfo("����С�׿Ƽ��������ι�˾����2010��4�£�"
				+ "��һ��רע������Ӳ���͵��Ӳ�Ʒ�з����ƶ���������˾����Ϊ���ն�������С�׵Ĳ�Ʒ���"
				+ "С�׹�˾�������û�����ģʽ�����ֻ�����ϵͳ�������Ѳ��뿪���Ľ���ģʽ��"
				+ "[1]  С�׻��Ǽ�ƻ�������ǡ���Ϊ֮����ļ�ӵ���ֻ�оƬ���������ĿƼ���˾��");
		company2.setCompanyId(1003);
		company2.setCompanyName("�ٶ�");
		company2.setCompanyAddress("������");
		company2.setCompanyInfo("�ٶȣ���˹��ˣ�BIDU����ȫ�����������������桢����������վ��"
				+ "1999���,����������ȵ�����꿴�����й������������������������ľ޴�չǱ��"
				+ "�����ż����ı���������룬����Ȼ�ǵ���ȵĸ�н������Я��������ר��������"
				+ "�� 2000��1��1�����йش崴���˰ٶȹ�˾��");
		company3.setCompanyId(1002);
		company3.setCompanyName("����");
		company3.setCompanyAddress("������");
		company3.setCompanyInfo("����JD.COM-1998�����רҵ���ۺ����Ϲ����̳ǣ�"
				+ "���۳�����Ʒ�ơ�4020������Ʒ�������ҵ硢�ֻ������ԡ�ĸӤ����װ��13��Ʒ�ࡣ"
				+ "���пͻ�Ϊ�ȵ��������������ƷΪ��Ʒ�л���ȫ������������Ʊ��");
		company4.setCompanyId(1005);
		company4.setCompanyName("С��");
		company4.setCompanyAddress("������");
		company4.setCompanyInfo("����С�׿Ƽ��������ι�˾����2010��4�£���һ��רע������Ӳ���͵��Ӳ�Ʒ�з����ƶ���������˾��"
				+ "��Ϊ���ն�������С�׵Ĳ�Ʒ���С�׹�˾�������û�����ģʽ�����ֻ�����ϵͳ�������Ѳ��뿪���Ľ���ģʽ��"
				+ "[1]  С�׻��Ǽ�ƻ�������ǡ���Ϊ֮����ļ�ӵ���ֻ�оƬ���������ĿƼ���˾��");
		company5.setCompanyId(1001);
		company5.setCompanyName("��Ѷ");
		company5.setCompanyAddress("����");
		company5.setCompanyInfo("��������Ѷ�����ϵͳ���޹�˾������1998��11�£������ڡ���־�������ʡ���һ������������λ��ʼ�˹�ͬ���� ��"
				+ " ���й����Ļ������ۺϷ����ṩ��֮һ��Ҳ���й������û����Ļ�������ҵ֮һ��");

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
		//�����Ϸ����ж�
		if (null == hashMap || null == comp || hashMap.size() == 0) {
			throw new NullPointerException("�������Ϸ�");
		}
		//�Ȱ�map��key�Ž�һ��list����
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
		//�����Ϸ����ж�
		if (null == hashMap || null == comp || hashMap.size() == 0) {
			throw new NullPointerException("�������Ϸ�");
		}
		//�Ȱ�map��key�Ž�һ��list����
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
//�Զ���Ƚ���
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
