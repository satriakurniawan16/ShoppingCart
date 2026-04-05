# 🛒 Shopping App (Jetpack Compose)

A modern Android shopping application built using **Jetpack Compose**, applying **Clean Architecture**, **MVVM**, and **Modular Design (feature & core)**.

---

## ✨ Features

* 📦 Product List
* 🔍 Sorting (Default, Name, Highest Price, Lowest Price)
* ➕➖ Add / Reduce Product Quantity
* 🧾 Checkout Summary
* ✅ Success Checkout Dialog
* 🔄 Reset Cart

---

## 🧱 Architecture

This project follows **Clean Architecture + MVVM**:

```
feature/
 └── product/
     ├── presentation/   → UI (Compose, ViewModel, State)
     ├── domain/         → Model (optional)
     └── data/           → Repository

core/
 └── ui/
     ├── atom/
     ├── molecule/
     ├── organism/
     └── theme/

## 🧩 Tech Stack

* 🟣 Kotlin
* 🎨 Jetpack Compose
* 🧠 MVVM Architecture
* 💉 Hilt (Dependency Injection)
* 🔄 StateFlow
* 🧱 Modular Structure (feature & core)
* 🎯 Material 3

---

## 📸 Screenshots

| Product List          | Checkout Success      |
| --------------------- | --------------------- |
| <img width="176" height="380" alt="image" src="https://github.com/user-attachments/assets/baf1fbcc-6e2f-440e-986f-2decc65ad76a" />
 | <img width="182" height="381" alt="image" src="https://github.com/user-attachments/assets/806d26c8-9fc4-4720-a0cc-70be633b2c34" />
 |

## 📌 Notes

* UI built fully with **Jetpack Compose**
* Uses **StateFlow for reactive state management**
* Follows **Atomic Design System** for reusable UI

---

## 👨‍💻 Author

**Rahmad Satria Kurniawan**
