package com.asura.design_patterns.singleinstance;

/**
 * @author Created by Asura on 2018/3/23 18:08.
 */
public class SingleInstanceDemo {
    public static void main(String[] args) {
        Company company = new Company();
        //ceo 不能new
        Staff ceo1 = CEO.getCEO();
        Staff ceo2 = CEO.getCEO();
        Staff vp1 = new VP();
        Staff vp2 = new VP();
        Staff staff1 = new Staff();
        Staff staff2 = new Staff();
        Staff staff3 = new Staff();
        company.addStaff(ceo1);
        company.addStaff(ceo2);
        company.addStaff(vp1);
        company.addStaff(vp2);
        company.addStaff(staff1);
        company.addStaff(staff2);
        company.addStaff(staff3);
        company.showAllStaffs();
    }
}
