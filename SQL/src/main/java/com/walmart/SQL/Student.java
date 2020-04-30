package com.walmart.SQL;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
        @Id
        @GeneratedValue
        private int id;
        private String name;

        public int getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public void setId(int id) {
                this.id = id;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Student(int id, String name) {
                this.id = id;
                this.name = name;
        }

        public Student() {
        }
}
