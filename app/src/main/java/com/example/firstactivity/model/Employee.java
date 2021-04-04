package com.example.firstactivity.model;

public class Employee {
    private String name;
    private String add;
    private String bloodgroup;
    private int id;
    private int age;
    private String imageurl;

        public Employee(String name, String add, String bloodgroup, String imageurl, int id, int age)  {
            this.add = add ;
            this.name = name;
            this.bloodgroup = bloodgroup;
            this.id = id;
            this.age= age;
            this.imageurl=imageurl;
        }
        public Employee()
        {

        }

    public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }

        public String getAdd(){
            return add;
        }

        public void setAdd(String add){
            this.add = add;
        }

        public String getBloodgroup(){
            return bloodgroup;
        }

        public void setBloodgroup(String bloodgroup){
            this.bloodgroup = bloodgroup;
        }

        public String getImageurl(){
            return imageurl;
        }

        public void setImageurl(String imageurl){
            this.imageurl = imageurl;
        }

        public int getId(){
            return id;
        }

        public void setId(int id){
            this.id = id;
        }

        public int getAge(){
            return age;
        }

        public void setAge(int age){
            this.age = age;
        }
}
