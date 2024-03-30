package com.Re.test;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagerTest {

	public static void main(String[] args) {
            ArrayList<Student> list = new ArrayList<>();
            //键盘输入
            Scanner sc = new Scanner(System.in);
            lo:
            while (true) {
                    //测试类，首先展示出羡慕菜单
                    System.out.println("----------welcome to student manager---------------");
                    System.out.println("1.添加学生");
                    System.out.println("2.删除学生");
                    System.out.println("3.修改学生");
                    System.out.println("4.查询学生");
                    System.out.println("5.退出");
                    System.out.println("---------------------------------------------------");
                    System.out.println("请输入你的选择：");
                    int choice = sc.nextInt();
                    switch (choice) {
                            case 1:
                                    addStudent(list);
                                    break;
                            case 2:
                                    deleteStudent(list);
                                    break;
                            case 3:
                                    setStudent(list);
                                    break;
                            case 4:
                                    queryStudent(list);
                                    break;
                            case 5:
                                    System.out.println("5.退出");
                                    break lo;
                            default:
                                    System.out.println("输入有误，请重新输入");
                    }
            }
    }

    /**修改学生信息
     *
     * @param list
     */
    private static void setStudent(ArrayList<Student> list) {
        //键盘录入要修改的学生ID，用于得到对应的索引
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要修改的学生ID");
        String index = sc.nextLine();
        //遍历arraylist，得到要修改的学生
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if (student.getId().equals(index)) {
                //使用set方法修改学生信息
                System.out.println("请输入新的姓名（name）");
                String name = sc.next();
                System.out.println("请输入新的年龄（age）");
                int age = sc.nextInt();
                System.out.println("请输入新的性别（gender）");
                String gender = sc.next();
                System.out.println("请输入新的分数（score）");
                Double score = sc.nextDouble();
                //调用set方法
                student.setName(name);
                student.setAge(age);
                student.setGender(gender);
                student.setScore(score);
                System.out.println("修改成功");
                return;
            }
        }
        System.out.println("输入的学号有错误，修改失败");
    }

    /**删除学生信息
     *
     * @param list
     */
    private static void deleteStudent(ArrayList<Student> list) {
        //键盘录入索引，用于得到徐奥删除的学生学号
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的学生ID");
        String index = sc.nextLine();
        //遍历arraylist集合，删除学生
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if (student.getId().equals(index)) {
                list.remove(i);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println(" 没有找到对应的ID，删除失败");
    }

    /**
     * 添加学生信息
     * @param list
     */
    private static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入添加的学生信息：");
        System.out.println("请输入学生ID：");
        String id = sc.next();
        System.out.println("请输入学生姓名(name)：");
        String name = sc.next();
        System.out.println("请输入学生年龄(age)：");
        int age = sc.nextInt();
        System.out.println("请输入学生性别(gender)：");
        String gender = sc.next();
        System.out.println("请输入学生分数(score)：");
        double score = sc.nextDouble();
        Student stu = new Student(id,name,age,gender,score);
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if (student.getId().equals(stu.getId())){
                System.out.println("学生信息添加失败，学生ID重复");
                return;
            }
        }
        System.out.println("学生信息添加成功");
        list.add(stu);
    }

    /**
     * 查询学生
     * @param list
     */
        private static void queryStudent(ArrayList<Student> list) {
            if (list.size() == 0){
                    System.out.println("当前没有学生信息");
            }else{
                    for (int i = 0; i < list.size(); i++) {
                        Student stu = list.get(i);
                        System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getGender() + "\t" + stu.getScore());
                    }
            }
        }


}
