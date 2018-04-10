package com.asura.design_patterns.singleinstance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by Asura on 2018/3/23 18:13.
 *         公司
 */
public class Company {
    private List<Staff> mStaffs = new ArrayList<>();

    public void addStaff(Staff staff) {
        mStaffs.add(staff);
    }

    public void showAllStaffs() {
        for (Staff staff : mStaffs) {
            System.out.println(staff.toString());
//            Log.d("asura", staff.toString());
        }
    }
}
