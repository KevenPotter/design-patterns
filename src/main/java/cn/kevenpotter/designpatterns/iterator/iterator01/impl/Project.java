package cn.kevenpotter.designpatterns.iterator.iterator01.impl;

import cn.kevenpotter.designpatterns.iterator.iterator01.IProject;
import cn.kevenpotter.designpatterns.iterator.iterator01.IProjectIterator;

import java.util.ArrayList;

public class Project implements IProject {

    // 定义一个项目列表，说有的项目都放在这里
    private ArrayList<IProject> projectList = new ArrayList<IProject>();
    // 项目名称
    private String name = "";
    // 项目成员数量
    private int num = 0;
    // 项目费用
    private int cost = 0;

    public Project() {
    }

    public Project(String name, int num, int cost) {
        this.name = name;
        this.num = num;
        this.cost = cost;
    }

    @Override
    public void add(String name, int num, int cost) {
        this.projectList.add(new Project(name, num, cost));
    }

    @Override
    public String getProjectInfo() {
        String info = "";
        // 获得项目的名称
        info = info + "项目名称是: " + this.name;
        // 获得项目的人数
        info = info + "\t项目人数是: " + this.num;
        // 项目费用
        info = info + "\t项目费用是: " + this.cost;
        return info;
    }

    @Override
    public IProjectIterator iterator() {
        return new ProjectIterator(this.projectList);
    }
}
