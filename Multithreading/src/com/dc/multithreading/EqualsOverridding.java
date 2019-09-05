package com.dc.multithreading;

class Student {
    private String name;
    private int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the rollNo
     */
    public int getRollNo() {
        return rollNo;
    }

    /**
     * @param rollNo
     *            the rollNo to set
     */
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this==obj) {
            return true;
        }
        if(null == obj && this.getClass() != obj.getClass()) {
            return false;
        }
        
        Student s = (Student) obj;
        
        return rollNo==s.rollNo && (name== s.name ||  name.equals(s.name));
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * 7 + rollNo;
        hash = 31 * 7 + (null == name ? 0 : name.hashCode());
        return hash;
    }

}

public class EqualsOverridding {
    
    public static void main(String[] args) {
        Student s1 = new Student("Deepak", 12);
        Student s2 = new Student(null, 12);
        
        System.out.println(s1.equals(s2));
        
        System.out.println(s1.hashCode() +"  -  " + s2.hashCode());
    }

}
