# 🛒 Product Management System (Java Backend)

## 📌 Overview

A backend system built using Core Java, demonstrating step-by-step evolution from in-memory storage to a database-driven application using JDBC and MySQL.

---

## 🚀 Features

### ✅ Version 1 — Collections

* Add Product
* Remove Product
* Update Product
* Get Product by ID
* View All Products
* Used HashMap for in-memory storage

---

### ✅ Version 2 — Exception Handling

* Custom Exceptions:

  * DuplicateProductException
  * ProductNotFoundException
* Improved validation and error handling

---

### ✅ Version 3 — File Handling

* Data stored permanently in file
* Implemented:

  * saveToFile()
  * loadFromFile()
* Used:

  * BufferedWriter
  * BufferedReader
* Data format: `id,name`

---

### ✅ Version 4 — JDBC + MySQL ⭐

* Connected Java application with MySQL database
* Implemented full CRUD operations:

  * INSERT (Add Product)
  * SELECT (Get Product)
  * UPDATE (Update Product)
  * DELETE (Remove Product)
* Used PreparedStatement for secure queries
* Added PRIMARY KEY for data integrity

---

## 🧠 Concepts Used

* Java Collections (HashMap)
* OOP (Encapsulation, Classes)
* Exception Handling
* File Handling
* JDBC
* MySQL
* CRUD Operations

---

## 🛠️ Tech Stack

* Java
* MySQL
* JDBC

---

## 📂 Project Structure

* Product.java → Model
* ProductManager.java → Business Logic (Collections + File + JDBC)
* Main.java → Execution

---

## 🎯 Learning Outcomes

* Built a real backend system step-by-step
* Understood transition:

  * Memory → File → Database
* Learned JDBC integration with MySQL
* Applied real-world backend logic and structure

---

## 🚀 Future Improvements

* Spring Boot (REST APIs)
* Layered Architecture (Controller, Service, Repository)
* Validation and DTOs
* Authentication
