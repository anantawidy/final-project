# Final Project: Automation Test Framework

Repository ini berisi sebuah automation test framework yang menggabungkan pengujian untuk Web UI dan API dalam satu project. Framework ini dibuat menggunakan berbagai tools dan library yang telah dipelajari selama course, termasuk Git, GitHub, Java, Gradle, Selenium, Rest Assured, Cucumber, dan GitHub Actions.

---

## **Fitur Utama**
1. **Pengujian Web UI dan API**:
    - Pengujian Web UI dilakukan menggunakan Selenium.
    - Pengujian API dilakukan menggunakan Rest Assured.
2. **Format Gherkin**:
    - Semua test case ditulis dalam format Gherkin dan diimplementasikan menggunakan Cucumber.
3. **Struktur Folder yang Rapi**:
    - Kode Java, Step Definitions, dan Feature file dipisahkan untuk Web dan API.
4. **Gradle Task**:
    - Task untuk menjalankan test dengan tag `@api`.
    - Task untuk menjalankan test dengan tag `@web`.
5. **Report**:
    - Cucumber menghasilkan report dalam format **HTML** dan **JSON**.
6. **GitHub Actions**:
    - Workflow untuk menjalankan test secara otomatis:
        - Manual trigger.
        - Setiap kali ada Pull Request.

---

## **Tools dan Library yang Digunakan**
- **Java**: Bahasa pemrograman utama untuk framework ini.
- **Gradle**: Build tool untuk menjalankan task.
- **Selenium**: Library untuk pengujian Web UI.
- **Rest Assured**: Library untuk pengujian API.
- **Cucumber**: Framework untuk behavior-driven development (BDD).
- **GitHub Actions**: Untuk Continuous Integration (CI).

---

Note: untuk API automation menggunakan gorest.co.id karena tidak bisa login pada dummyapi.co.id
